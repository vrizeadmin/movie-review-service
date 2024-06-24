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

import vrize.community.moviereview.entity.Users;
import vrize.community.moviereview.entity.Watchlist;
import vrize.community.moviereview.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService userService;
	
	@GetMapping
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable UUID id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public Users createUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/{id}")
	public Users updateUser(@PathVariable UUID id, @RequestBody Users user) {
		user.setId(id);
		return userService.saveUser(user);	
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable UUID id) {
		userService.deleteUser(id);
	}
	
	@PostMapping("/{id}/watchlist")
	public void addToWatchlist(@PathVariable UUID id, @RequestBody Watchlist watchlist) {
		userService.addToWatchlist(id, watchlist);
	}
	
	@DeleteMapping("/{id}/watchlist/{watchlistId}")
	public void removeFromWatchlist(@PathVariable UUID id, @PathVariable UUID watchlistId) {
		userService.removeFromWatchlist(id, watchlistId);
	}
	
	@GetMapping("/{id}/watchlist")
	public List<Watchlist> getUserWatchlist(@PathVariable UUID id) {
		return userService.getUserWatchlist(id);
	}
	
	
	

}
