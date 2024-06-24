package vrize.community.moviereview.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review extends BaseEntityAudit{
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;
	
	private String review;
	private Integer rating;
	private Integer totalLikes = 0;
	private Integer totalDislikes = 0;
	private Integer createdProgramId;
	private Integer modifiedProgramId;
	private Integer createdUserId;
	private Integer modifiedUserId;
	private Timestamp createdTimestamp;
	private Timestamp modifiedTimestamp;
	private String lockid;
}
