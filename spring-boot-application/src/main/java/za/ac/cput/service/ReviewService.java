


package za.ac.cput.service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* ReviewService.java
      Review service class
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */
@Service
public class ReviewService implements IReviewService {

    private static IReviewService service;
    private ReviewRepository repository;

    //@Override
    public Review create(Review review) {
        return this.repository.save(review);
    }

    //@Override
    public Review read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    //@Override
    public Review update(Review review) {
        return this.repository.save(review);
    }

    //@Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    //@Override
    public List<Review> getAll() {
        return this.repository.findAll();
    }
}




