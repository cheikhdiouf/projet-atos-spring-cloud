package sn.atos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.atos.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository <UserEntity, Integer> {

    Optional<UserEntity> findUserEntitiesByFirstNameAndLastName(String firstName, String lastName);

    Optional <UserEntity> findByLe(String libelle);

}
