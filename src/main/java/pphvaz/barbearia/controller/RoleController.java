package pphvaz.barbearia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pphvaz.barbearia.exceptions.CustomExceptions;
import pphvaz.barbearia.model.Role;
import pphvaz.barbearia.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleServ;

	// GET ROLE BY ID
	@GetMapping("**/{id}")
	private ResponseEntity<Role> findById(@PathVariable Long id) {
		Role role = roleServ.findById(id);

		if (role != null) {
			return ResponseEntity.ok(role);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// GET ALL ROLES
	@GetMapping
	private ResponseEntity<List<Role>> findAll() {

		List<Role> roles = roleServ.findAll();

		return ResponseEntity.ok(roles);

	}

	// CREATE ROLE IN DATABASE
	@PostMapping
	private ResponseEntity<Role> save(@RequestBody Role role, UriComponentsBuilder ucb) throws CustomExceptions {

		if (role.getId() == null) {
			List<Role> roles = roleServ.findByDescricao(role.getDescricao());
			if (!roles.isEmpty()) {
				throw new CustomExceptions("Role already taken: " + role.getDescricao());
			}
		}

		Role savedRole = roleServ.save(role);

		URI locationOfNewRole = ucb.path("/roles/{id}").buildAndExpand(savedRole.getId()).toUri();
		return ResponseEntity.created(locationOfNewRole).body(savedRole);

	}

	// DELETE ROLE IN DATABASE
	@DeleteMapping("/{id}")
	private ResponseEntity<Role> deleteById(@PathVariable Long id) {

		Role role = roleServ.findById(id);

		if (role != null) {
			roleServ.deleteById(id);
			return ResponseEntity.ok(role);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
