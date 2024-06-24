package vrize.community.moviereview.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Genre extends BaseEntityAudit{
	
	private String GenreName;
	
	@ManyToMany(mappedBy = "genre")
	private List<Movie> movies;
}
