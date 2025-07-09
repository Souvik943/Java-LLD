package topics.LLD.DummyInstagram.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final String userId;
    private final String userName;
    private final Set<User> followingUser = new HashSet<>();
    private final List<String> follwgingHastags = new ArrayList<>();
    private final List<Post> posts = new ArrayList<>();

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Set<User> getFollowingUser() {
        return followingUser;
    }

    public List<String> getFollwgingHastags() {
        return follwgingHastags;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
