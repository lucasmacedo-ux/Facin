package br.unitins.facin.security;

import br.unitins.facin.model.Administrador;
import br.unitins.facin.repository.AdministradorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Cria o primeiro administrador ao iniciar a aplicação, lendo usuário e senha
 * das variáveis de ambiente ADMIN_USER e ADMIN_PASSWORD. A senha é gravada
 * apenas como hash BCrypt e nunca fica escrita no código.
 */
@Component
public class AdminInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminInitializer.class);

    private final AdministradorRepository repository;
    private final PasswordEncoder encoder;

    @Value("${ADMIN_USER:}")
    private String usuario;

    @Value("${ADMIN_PASSWORD:}")
    private String senha;

    public AdminInitializer(AdministradorRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        if (usuario.isBlank() || senha.isBlank()) {
            log.warn("ADMIN_USER e ADMIN_PASSWORD não definidos: nenhum administrador foi criado.");
            return;
        }
        if (repository.existsByUsuario(usuario)) {
            return;
        }
        repository.save(new Administrador(usuario, encoder.encode(senha)));
        log.info("Administrador '{}' criado.", usuario);
    }
}
