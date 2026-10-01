package br.unitins.facin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String usuario;

    // Hash BCrypt da senha. A senha em texto puro nunca é gravada.
    @Column(name = "senha_hash", nullable = false, length = 100)
    private String senhaHash;

    public Administrador() {
    }

    public Administrador(String usuario, String senhaHash) {
        this.usuario = usuario;
        this.senhaHash = senhaHash;
    }

    public Long getId() { return id; }
    public String getUsuario() { return usuario; }
    public String getSenhaHash() { return senhaHash; }
}
