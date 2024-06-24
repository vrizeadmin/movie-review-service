package vrize.community.moviereview.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vrize.community.moviereview.entity.Genre;
import vrize.community.moviereview.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository repo; 

	public List<Genre> getAllGenres() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Genre getGenreById(UUID id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Genre saveGenre(Genre genre) {
		// TODO Auto-generated method stub
		return repo.save(genre);
	}

	public void deleteGenre(UUID id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
