package pphvaz.barbearia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pphvaz.barbearia.model.Users;
import pphvaz.barbearia.repository.UsersRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = usersRepo.findByLogin(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		return new User(user.getLogin(), user.getPassword(), user.getAuthorities());
	}

}