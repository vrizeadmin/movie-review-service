package vrize.community.moviereview.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import vrize.community.moviereview.auth.config.JwtService;
import vrize.community.moviereview.auth.dto.AuthenticationResponseDTO;
import vrize.community.moviereview.auth.dto.UserDTO;
import vrize.community.moviereview.auth.internal.token.TokenService;
import vrize.community.moviereview.auth.internal.user.UserService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final TokenService tokenService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO register(UserDTO userDTO) {
        var savedUser = userService.createUser(userDTO);
        var jwtToken = jwtService.generateToken(savedUser);
        var refreshToken = jwtService.generateRefreshToken(savedUser);
        tokenService.createUserToken(savedUser, jwtToken);
        return new AuthenticationResponseDTO(jwtToken, refreshToken);
    }

    public AuthenticationResponseDTO authenticate(UserDTO userDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.username(), userDTO.password()));
        var user = userService.findByUsername(userDTO.username()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        tokenService.revokeAllUserTokens(user);
        tokenService.createUserToken(user, jwtToken);
        return new AuthenticationResponseDTO(jwtToken, refreshToken);
    }


    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = userService.findByUsername(userEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                tokenService.revokeAllUserTokens(user);
                tokenService.createUserToken(user, accessToken);
                var authResponse = new AuthenticationResponseDTO(accessToken, refreshToken);;
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
