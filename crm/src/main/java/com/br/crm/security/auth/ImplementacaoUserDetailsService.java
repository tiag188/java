package com.br.crm.security.auth;

import com.br.crm.model.auth.Usuario;
import com.br.crm.repository.auth.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImplementacaoUserDetailsService implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findUserByLogin(username);

    if (usuario == null) {
      throw new UsernameNotFoundException("Usuário não foi encontrado");
    }

    return new User(
      usuario.getLogin(),
      usuario.getPassword(),
      true,
      true,
      true,
      true,
      usuario.getAuthorities()
    );
  }
}
