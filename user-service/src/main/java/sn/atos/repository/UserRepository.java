package sn.atos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.atos.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Integer> {

    Optional<UserEntity> findUserByFirstNameAndLastName(String firstName, String lastName);

    UserEntity findByEmail(String email);

}
