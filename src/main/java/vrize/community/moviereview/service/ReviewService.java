package vrize.community.moviereview.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vrize.community.moviereview.entity.Review;
import vrize.community.moviereview.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repo;

	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Review getReviewById(UUID id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Review saveReview(Review review) {
		// TODO Auto-generated method stub
		return repo.save(review);
	}

	public void deleteReview(UUID id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
	
}
