package vrize.community.moviereview.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private Integer yearOfRelease;
	private Integer duration;
	private String director;
	private String cast;
	private String genre;
	private String languages;
	private Float aggregateReviewRatings = 0f;
	private Integer totalReviews = 0;
	private String movieRating;
	
}
