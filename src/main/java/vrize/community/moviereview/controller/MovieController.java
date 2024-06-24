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

import vrize.community.moviereview.entity.Movie;
import vrize.community.moviereview.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable UUID id) {
		return movieService.getMovieById(id);
	}
	
	@PostMapping
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable UUID id, @RequestBody Movie movie) {
		movie.setId(id);
		return movieService.saveMovie(movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable UUID id){
		movieService.deleteMovie(id);
	}
}
