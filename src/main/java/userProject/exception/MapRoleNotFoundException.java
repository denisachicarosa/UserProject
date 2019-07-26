package userProject.exception;

public class MapRoleNotFoundException extends Exception {
    private Integer map_role_id;

    public MapRoleNotFoundException(Integer map_role_id) {
        super(String.format("Map Role is not found with id : '%s'", map_role_id));
    }

}
