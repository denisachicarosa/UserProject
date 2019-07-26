package userProject.repository;

import userProject.model.MapRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRoleRepository extends JpaRepository<MapRole, Integer> {
}
