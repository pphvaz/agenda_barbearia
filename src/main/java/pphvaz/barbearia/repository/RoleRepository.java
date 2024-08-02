package pphvaz.barbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pphvaz.barbearia.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findByDescricao(String descricao);
}