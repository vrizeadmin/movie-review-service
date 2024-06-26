package vrize.community.moviereview.auth.dto;

import vrize.community.moviereview.auth.internal.user.Role;

public record UserDTO(String username, String password, Role role) {
}
