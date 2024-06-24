package vrize.community.moviereview.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Director extends BaseEntityAudit {
	
	private String firstName;
	private String lastName;
	private String nationality;
	private Date birthDate;
	
	@ManyToMany(mappedBy = "director")
	private List<Movie> movies;

}
