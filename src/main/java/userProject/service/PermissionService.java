package userProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userProject.repository.PermissionRepository;

@Service
public class PermissionService implements PermissionServiceInterface{

    @Autowired
    private PermissionRepository permissionRepository;


}
