package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private static ReviewService service;

    private ReviewRepository repository;

    @Override
    public Review create(Review review) {
        return this.repository.save(review);
    }

    @Override
    public Review read(String reviewID) {
        return this.repository.findById(reviewID).orElse(null);
    }

    @Override
    public Review update(Review review) {
        return this.repository.save(review);
    }

    @Override
    public boolean delete(String reviewID) {
        this.repository.deleteById(reviewID);
        return true;
    }

    @Override
    public List<Review> getAll() {
        return this.repository.findAll();
    }
}
