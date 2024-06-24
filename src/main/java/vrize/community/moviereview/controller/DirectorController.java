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

import vrize.community.moviereview.entity.Director;
import vrize.community.moviereview.service.DirectorService;

@RestController
@RequestMapping("/directors")
public class DirectorController {
	@Autowired
	private DirectorService service;
	
	@GetMapping
	public List<Director> getAllDirectors(){
		return service.getAllDirectors();
	}
	
	@GetMapping("/{id}")
	public Director getDirectorById(@PathVariable UUID id) {
		return service.getDirectorById(id);
	}
	
	@PostMapping
	public Director createDirector(@RequestBody Director director) {
		return service.saveDirector(director);
	}
	
	@PutMapping("/{id}")
	public Director updateDirector(@PathVariable UUID id, @RequestBody Director director) {
		director.setId(id);
		return service.saveDirector(director);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDirector(@PathVariable UUID id) {
		service.deleteDirector(id);
	}

}
