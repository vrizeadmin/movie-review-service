package vrize.community.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vrize.community.moviereview.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
}
