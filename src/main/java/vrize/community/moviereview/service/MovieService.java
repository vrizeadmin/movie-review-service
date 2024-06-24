package vrize.community.moviereview.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vrize.community.moviereview.entity.Movie;
import vrize.community.moviereview.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;

	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Movie getMovieById(UUID id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return repo.save(movie);
	}

	public void deleteMovie(UUID id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
