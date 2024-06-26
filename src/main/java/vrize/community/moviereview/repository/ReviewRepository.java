package vrize.community.moviereview.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vrize.community.moviereview.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID>{
	
}
