package sn.atos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.atos.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByLibelle(String libelle);
}
