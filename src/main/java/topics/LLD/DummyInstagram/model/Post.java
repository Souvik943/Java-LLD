package topics.LLD.DummyInstagram.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Post {
    private final String postId;
    private final User postedBy;
    private final String postContent;
    private final List<String> hashTag;
    private final Set<User> likedBy = new HashSet<>();
    private final List<Comment> comments = new ArrayList<>();
    private final LocalDateTime postedOn;

    public Post(String postId, User postedBy, String postContent, List<String> hashTag, LocalDateTime postedOn) {
        this.postId = postId;
        this.postedBy = postedBy;
        this.postContent = postContent;
        this.hashTag = hashTag;
        this.postedOn = postedOn;
    }

    public String getPostId() {
        return postId;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public List<String> getHashTag() {
        return hashTag;
    }

    public Set<User> getLikedBy() {
        return likedBy;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getPostedOn() {
        return postedOn;
    }

    public String getPostContent() {
        return postContent;
    }
}
