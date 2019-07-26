package userProject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userProject.service.PermissionService;

@RestController
@RequestMapping("api/v1/")
public class PermissionController {

    static Logger log = Logger.getLogger(RoleController.class.getName());

    @Autowired
    public PermissionService permissionService;
}
