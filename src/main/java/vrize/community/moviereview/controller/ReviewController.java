package vrize.community.moviereview.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vrize.community.moviereview.entity.Review;
import vrize.community.moviereview.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService service;
	
	@GetMapping
	public List<Review> getAllReviews(){
		return service.getAllReviews();
	}
	
	@GetMapping("/{id}")
	public Review getReviewById(@PathVariable UUID id) {
		return service.getReviewById(id);
	}
	
	@PostMapping
	public Review createReview(@RequestBody Review review) {
		return service.saveReview(review);
	}
	
	@PutMapping("/{id}")
	public Review updateReview(@PathVariable UUID id, @RequestBody Review review) {
		review.setId(id);
		return service.saveReview(review);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReview(@PathVariable UUID id) {
		service.deleteReview(id);
	}

}
