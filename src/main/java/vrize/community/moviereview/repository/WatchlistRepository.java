package vrize.community.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vrize.community.moviereview.entity.Watchlist;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long>{

}
