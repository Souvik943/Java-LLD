package topics.LLD.DummyInstagram.service;

import topics.LLD.DummyInstagram.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    Map<String, User> users = new HashMap<>();

    public User createUser(String userName) {
        String generatedUserId = UUID.randomUUID().toString();
        User newUser = new User(generatedUserId, userName);
        users.put(generatedUserId, newUser);
        System.out.println("Created new User : " + userName);
        return newUser;
    }

    public void followUser(String followerId, String followeeId) {
        User followerUser = users.get(followerId);
        User followeeUser = users.get(followeeId);
        if(followerUser == null) {
            System.out.println("Follower not present .");
            return;
        } else if(followeeUser == null) {
            System.out.println("Followee not present .");
            return;
        }
        followerUser.getFollowingUser().add(followeeUser);
        System.out.println(followeeUser.getUserName() + " is following : " + followerUser.getUserName());
    }

    public void followHashtag(String userId, List<String> hashTagList) {
        User currentUser = users.get(userId);
        if(currentUser == null) {
            System.out.println("User not present .");
            return;
        }

        currentUser.getFollwgingHastags().addAll(hashTagList);
        System.out.println("User successfully followed : " + hashTagList.size() + " hashtags");
    }
}
