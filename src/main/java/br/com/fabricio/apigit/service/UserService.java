package br.com.fabricio.apigit.service;

import br.com.fabricio.apigit.models.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsuariosService usrService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usrService.findByLogin(username);

        if(Objects.isNull(usuario)) {
            String msg = "Usuário "+ username +" não encontrado";
            log.error(msg);
            throw new UsernameNotFoundException(msg);
        }

        List<GrantedAuthority> autorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome()))
                .peek(autority -> log.info("Role: "+autority))
                .collect(Collectors.toList());

        log.info("Usuário autenticado: " + username);

        return new User(usuario.getLogin(), usuario.getPassword(), usuario.getEnabled(), true,
                true, true, autorities);
    }
}
