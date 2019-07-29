package userProject.exception;

public class UserNotFoundException extends RuntimeException {
    private Integer id_user;

    public UserNotFoundException(Integer id_user) {
        super(String.format("User is not found with id : '%s'", id_user));
    }

}
