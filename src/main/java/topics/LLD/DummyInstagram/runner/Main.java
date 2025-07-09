package topics.LLD.DummyInstagram.runner;

import topics.LLD.DummyInstagram.model.Comment;
import topics.LLD.DummyInstagram.model.Post;
import topics.LLD.DummyInstagram.model.User;
import topics.LLD.DummyInstagram.service.PostService;
import topics.LLD.DummyInstagram.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        PostService postService = new PostService(userService);

        User souvik = userService.createUser("Souvik");
        User adrika = userService.createUser("Adrika");

        userService.followUser(adrika.getUserId(), souvik.getUserId());
        userService.followHashtag(souvik.getUserId(), List.of("travel","gaming"));

        Post post = postService.createPost("What a beautiful view .", adrika.getUserId(), List.of("travel"));
        postService.likePost(souvik.getUserId(), post.getPostId());
        postService.commentOnPost(souvik.getUserId(), post.getPostId(), "Great view");

        List<Post> feed = postService.getFeed(souvik.getUserId());
        System.out.println("Souvik's Feed:");
        for (Post currPost : feed) {
            System.out.println("- " + currPost.getPostedBy().getUserName() + ": " + currPost.getPostContent());
            System.out.println("  Likes: " + currPost.getLikedBy().size());
            System.out.println("  Comments:");
            for (Comment comment : currPost.getComments()) {
                System.out.println("    - " + comment.getCommentedBy().getUserName() + ": " + comment.getCommentedText());
            }
        }
    }
}
