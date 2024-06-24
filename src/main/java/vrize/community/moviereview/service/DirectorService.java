package vrize.community.moviereview.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vrize.community.moviereview.entity.Director;
import vrize.community.moviereview.repository.DirectorRepository;

@Service
public class DirectorService {

	@Autowired
	private DirectorRepository repo;
	
	public List<Director> getAllDirectors() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Director getDirectorById(UUID id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Director saveDirector(Director director) {
		// TODO Auto-generated method stub
		return repo.save(director);
	}

	public void deleteDirector(UUID id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
