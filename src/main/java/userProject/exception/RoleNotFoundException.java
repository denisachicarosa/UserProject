package userProject.exception;

public class RoleNotFoundException extends Exception {
    private Integer role_id;

    public RoleNotFoundException(Integer role_id) {
        super(String.format("Role is not found with id : '%s'", role_id));
    }
}
