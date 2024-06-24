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

import vrize.community.moviereview.entity.Genre;
import vrize.community.moviereview.service.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {
	@Autowired
	private GenreService service;
	
	@GetMapping
	public List<Genre> getAllGenres(){
		return service.getAllGenres();
	}
	
	@GetMapping("/{id}")
	public Genre getGenreById(@PathVariable UUID id) {
		return service.getGenreById(id);
	}
	
	@PostMapping
	public Genre createGenre(@RequestBody Genre genre) {
		return service.saveGenre(genre);
	}
	
	@PutMapping("/{id}")
	public Genre updateGenre(@PathVariable UUID id, @RequestBody Genre genre) {
		genre.setId(id);
		return service.saveGenre(genre);
	}
	
	@DeleteMapping("/{id}")
	public void deleteGenre(@PathVariable UUID id) {
		service.deleteGenre(id);
	}

}
