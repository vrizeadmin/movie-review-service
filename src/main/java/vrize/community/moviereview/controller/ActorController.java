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

import vrize.community.moviereview.entity.Actor;
import vrize.community.moviereview.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {
	@Autowired
	private ActorService service;
	
	@GetMapping
	public List<Actor> getAllActors(){
		return service.getAllActors();
	}
	
	@GetMapping("/{id}")
	public Actor getActorById(@PathVariable UUID id) {
		return service.getActorById(id);
	}
	
	@PostMapping
	public Actor createActor(@RequestBody Actor actor) {
		return service.saveActor(actor);
	}
	
	@PutMapping("/{id}")
	public Actor updateActor(@PathVariable UUID id, @RequestBody Actor actor) {
		actor.setId(id);
		return service.saveActor(actor);
	}
	
	@DeleteMapping("/{id}")
	public void deleteActor(@PathVariable UUID id) {
		service.deleteActor(id);
	}

}
