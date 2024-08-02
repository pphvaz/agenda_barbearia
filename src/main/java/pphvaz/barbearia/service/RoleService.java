package pphvaz.barbearia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pphvaz.barbearia.model.Role;
import pphvaz.barbearia.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	public Role save(Role role) {
		return roleRepo.save(role);
	}
	
	public Role findById(Long id) {
		return roleRepo.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		roleRepo.deleteById(id);
	}
	
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	public List<Role> findByDescricao(String descricao) {
		return roleRepo.findByDescricao(descricao);
	}
	
}
