package topics.LLD.DummyInstagram.model;

import java.time.LocalDateTime;

public class Comment {
    private final String commentId;
    private final User commentedBy;
    private final String commentedText;
    private final LocalDateTime commentedOn;

    public Comment(String commentId, User commentedBy, String commentedText, LocalDateTime commentedOn) {
        this.commentId = commentId;
        this.commentedBy = commentedBy;
        this.commentedText = commentedText;
        this.commentedOn = commentedOn;
    }

    public String getCommentId() {
        return commentId;
    }

    public User getCommentedBy() {
        return commentedBy;
    }

    public String getCommentedText() {
        return commentedText;
    }

    public LocalDateTime getCommentedOn() {
        return commentedOn;
    }
}
