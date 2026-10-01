package br.unitins.facin.security;

import br.unitins.facin.model.Administrador;
import br.unitins.facin.repository.AdministradorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    private final AdministradorRepository repository;

    public AdminUserDetailsService(AdministradorRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Administrador admin = repository.findByUsuario(usuario)
                .orElseThrow(() -> new UsernameNotFoundException("Administrador não encontrado"));

        return User.withUsername(admin.getUsuario())
                .password(admin.getSenhaHash())
                .roles("ADMIN")
                .build();
    }
}
