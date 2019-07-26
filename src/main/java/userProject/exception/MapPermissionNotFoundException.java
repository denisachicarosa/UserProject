package userProject.exception;

public class MapPermissionNotFoundException extends Exception {
    private Integer map_permission_id;

    public MapPermissionNotFoundException(Integer map_permission_id) {
        super(String.format("Map Permission is not found with id : '%s'", map_permission_id));
    }

}
