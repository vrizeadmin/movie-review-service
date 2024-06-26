package vrize.community.moviereview.auth.dto;

public record ChangePasswordRequestDTO(String currentPassword, String newPassword, String confirmationPassword) {
}
