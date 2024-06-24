package vrize.community.moviereview.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vrize.community.moviereview.entity.Users;
import vrize.community.moviereview.entity.Watchlist;
import vrize.community.moviereview.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;
	
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Users getUserById(UUID id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	public void deleteUser(UUID id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Transactional
	public void addToWatchlist(UUID id, Watchlist watchlist) {
		// TODO Auto-generated method stub
		Users user = getUserById(id);
		if(user != null) {
			user.getWatchlist().add(watchlist);
			watchlist.setUser(user);
			repo.save(user);
		}
		
	}

	@Transactional
	public void removeFromWatchlist(UUID id, UUID watchlistId) {
		// TODO Auto-generated method stub
		Users user = getUserById(id);
		if(user != null) {
			for(Watchlist wl : user.getWatchlist()) {
				if(wl.getId().equals(watchlistId)) {
					user.getWatchlist().remove(wl);
				}
			}
			repo.save(user);
		}
	}

	@Transactional
	public List<Watchlist> getUserWatchlist(UUID id) {
		// TODO Auto-generated method stub
		Users user = getUserById(id);
		return user != null ? user.getWatchlist() : null;
	}

}
