package vrize.community.moviereview.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vrize.community.moviereview.entity.Actor;
import vrize.community.moviereview.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository repo;

	public List<Actor> getAllActors() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Actor getActorById(UUID id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Actor saveActor(Actor actor) {
		// TODO Auto-generated method stub
		return repo.save(actor);
	}

	public void deleteActor(UUID id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
