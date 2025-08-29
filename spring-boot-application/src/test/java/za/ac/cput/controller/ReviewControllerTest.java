package za.ac.cput.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewControllerTest {

    private static Review review;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/review";

    @BeforeAll
    public static void setup() {
        review = ReviewFactory.createReview(
                "R001",                // reviewID
                5,                     // rating
                "Excellent service!",  // comment
                LocalDateTime.now()    // dateSubmitted
        );
    }

    @Test
    @Order(1)
    void createReview() {
        String url = BASE_URL + "/create";
        ResponseEntity<Review> response = restTemplate.postForEntity(url, review, Review.class);
        assertNotNull(response.getBody());
        review = response.getBody(); // store created review
        System.out.println("Created_Review: " + review);
    }

    @Test
    @Order(2)
    void readReview() {
        String url = BASE_URL + "/read/" + review.getReviewID();
        ResponseEntity<Review> response = restTemplate.getForEntity(url, Review.class);
        assertNotNull(response.getBody());
        assertEquals(review.getReviewID(), response.getBody().getReviewID());
        System.out.println("Read_Review: " + response.getBody());
    }

    @Test
    @Order(3)
    void updateReview() {
        Review updatedReview = new Review.ReviewBuilder()
                .copy(review)
                .setComment("Great service, but delivery was late.") // update comment
                .build();

        String url = BASE_URL + "/update";
        ResponseEntity<Review> response = restTemplate.exchange(
                url, HttpMethod.PUT, new HttpEntity<>(updatedReview), Review.class);

        assertNotNull(response.getBody());
        assertEquals(updatedReview.getReviewID(), response.getBody().getReviewID());
        System.out.println("Updated_Review: " + response.getBody());
    }

    @Test
    @Order(4)
    void deleteReview() {
        String url = BASE_URL + "/delete/" + review.getReviewID();
        restTemplate.delete(url);

        ResponseEntity<Review> response = restTemplate.getForEntity(BASE_URL + "/read/" + review.getReviewID(), Review.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted_Review: Status " + response.getStatusCode());
    }
}