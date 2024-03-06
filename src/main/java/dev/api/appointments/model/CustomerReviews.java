package dev.api.appointments.model;

import jakarta.persistence.*;

@Entity
@Table
public class CustomerReviews {

    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private long reviewId;
    @ManyToOne
    @JoinColumn(name = "business_id")
    private Businesses business;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;
    private int rating;
    private String reviewText;

    public CustomerReviews() {
    }

    public CustomerReviews(long reviewId, int rating, String reviewText) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "CustomerReviews{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
