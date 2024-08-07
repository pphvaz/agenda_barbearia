package pphvaz.barbearia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pphvaz.barbearia.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{

	Users findByLogin(String login);
}

