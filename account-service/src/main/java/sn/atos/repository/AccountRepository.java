package sn.atos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sn.atos.entity.AccountEntity;
@Repository
public interface AccountRepository extends MongoRepository<AccountEntity, String>{

}
