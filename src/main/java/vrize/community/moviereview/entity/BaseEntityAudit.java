package vrize.community.moviereview.entity;

import java.sql.Timestamp;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

	private Integer createdProgramId;
	private Integer modifiedProgramId;
	
	private Timestamp createdTimestamp;
	private Timestamp modifiedTimestamp;
}
