package userProject.repository;

import userProject.model.MapPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapPermissionRepository extends JpaRepository<MapPermission, Integer> {
}
