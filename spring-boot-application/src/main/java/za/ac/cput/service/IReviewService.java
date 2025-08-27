package za.ac.cput.service;
import za.ac.cput.domain.Review;
import java.util.List;
/* IReviewService.java
      Review service interface
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */

public interface IReviewService {
    Review create(Review review);
    Review read(String id);
    Review update(Review review);
    boolean delete(String id);
    List<Review> getAll();
}



