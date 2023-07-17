package kz.study.debug.repository;

import jakarta.transaction.Transactional;
import kz.study.debug.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
