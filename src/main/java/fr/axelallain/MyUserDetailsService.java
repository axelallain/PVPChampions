package fr.axelallain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.axelallain.entity.Utilisateur;
import fr.axelallain.service.UtilisateurService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Utilisateur utilisateur = utilisateurService.findByEmail(email);
		
		if(utilisateur == null) {
			throw new UsernameNotFoundException("Les identifiants sont incorrects ou ce compte n'existe pas.");
		}
		
		return new UserPrincipal(utilisateur);
	}

}