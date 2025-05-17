package za.ac.cput.domain;

/* Review.java
      Review POJO class
     Author: Cameron Savage (230582567)
     Date: 11 May 2025
     */

import java.time.LocalDateTime;

public class Review {
    private String reviewID;
    private int rating;
    private String comment;
    private LocalDateTime dateSubmitted;

    public Review() {
    }
    private Review(ReviewBuilder builder) {
        this.reviewID = builder.reviewID;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.dateSubmitted = builder.dateSubmitted;
    }

    public String getReviewID() {
        return reviewID;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }
    @Override
    public String toString() {
        return "Review{" +
                "reviewID='" + reviewID + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", dateSubmitted=" + dateSubmitted +
                '}';
    }

    public static class ReviewBuilder {
        private String reviewID;
        private int rating;
        private String comment;
        private LocalDateTime dateSubmitted;

        public ReviewBuilder(String reviewID, int rating, String comment, LocalDateTime dateSubmitted) {
            this.reviewID = reviewID;
            this.rating = rating;
            this.comment = comment;
            this.dateSubmitted = dateSubmitted;
        }

        public Review build() {
            return new Review(this);
        }
    }
}