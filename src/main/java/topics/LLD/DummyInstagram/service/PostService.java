package topics.LLD.DummyInstagram.service;

import topics.LLD.DummyInstagram.model.Comment;
import topics.LLD.DummyInstagram.model.Post;
import topics.LLD.DummyInstagram.model.User;

import java.time.LocalDateTime;
import java.util.*;

public class PostService {
    private final Map<String, Post> postsById = new HashMap<>();
    private final Map<String, List<Post>> postsByHashTag = new HashMap<>();
    private final UserService userService;

    public PostService(UserService userService) {
        this.userService = userService;
    }

    public Post createPost(String postContent, String userId, List<String> hashTags) {
        User currentUser = userService.users.get(userId);
        String generatedPostId = UUID.randomUUID().toString();
        Post newPost = new Post(generatedPostId, currentUser, postContent, hashTags, LocalDateTime.now());
        postsById.put(generatedPostId, newPost);
        currentUser.getPosts().add(newPost);

        for(String hashTag : hashTags) {
            List<Post> postList = postsByHashTag.get(hashTag);
            if(postList == null || postList.isEmpty()) {
                postList = new ArrayList<>();
                postList.add(newPost);
                postsByHashTag.put(hashTag, postList);
            }
        }
        System.out.println("Successfully Posted .");
        return newPost;
    }

    public void likePost(String userId, String postId) {
        User currentUser = userService.users.get(userId);
        Post currentPost = postsById.get(postId);
        currentPost.getLikedBy().add(currentUser);
    }

    public void commentOnPost(String userId, String postId, String commentedText) {
        Post currentPost = postsById.get(postId);
        User currentUser = userService.users.get(userId);

        if(currentPost != null || currentUser != null) {
            String generatedCommentId = UUID.randomUUID().toString();
            Comment comment = new Comment(generatedCommentId, currentUser, commentedText, LocalDateTime.now());

            currentPost.getComments().add(comment);
        }
    }

    public List<Post> getFeed(String userId) {
        User currentUser = userService.users.get(userId);
        Set<Post> feed = new HashSet<>();

        for(User following : currentUser.getFollowingUser()) {
            feed.addAll(following.getPosts());
        }

        for(String hashtag : currentUser.getFollwgingHastags()) {
            List<Post> posts = postsByHashTag.getOrDefault(hashtag, Collections.emptyList());
            feed.addAll(posts);
        }

        return feed.stream().toList();
    }
}
