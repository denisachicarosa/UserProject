package userProject.exception;

public class PermissionNotFoundException extends Exception {
    private Integer permission_id;

    public PermissionNotFoundException(Integer permission_id) {
        super(String.format("Permission is not found with id : '%s'", permission_id));
    }

}
