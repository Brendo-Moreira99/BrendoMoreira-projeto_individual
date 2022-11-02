package com.org.recode.NovosAres.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.recode.NovosAres.model.UserDetailsImpl;
import com.org.recode.NovosAres.model.Usuario;
import com.org.recode.NovosAres.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{


    @Autowired
    private UsuarioRepository usuarioRepositorio; 

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new UserDetailsImpl(usuario);
    }
    
	
	
	
}
