package br.unitins.facin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------- Dados pessoais ----------

    @NotBlank(message = "Informe o nome completo.")
    @Size(max = 120, message = "O nome deve ter no máximo 120 caracteres.")
    @Column(nullable = false, length = 120)
    private String nome;

    @NotBlank(message = "Selecione o estado civil.")
    @Column(name = "estado_civil", nullable = false, length = 30)
    private String estadoCivil;

    @NotBlank(message = "Informe a nacionalidade.")
    @Size(max = 60, message = "A nacionalidade deve ter no máximo 60 caracteres.")
    @Column(nullable = false, length = 60)
    private String nacionalidade;

    @NotBlank(message = "Selecione o sexo.")
    @Column(nullable = false, length = 30)
    private String sexo;

    @NotNull(message = "Informe a data de nascimento.")
    @Past(message = "A data de nascimento deve estar no passado.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotBlank(message = "Informe a naturalidade.")
    @Size(max = 100, message = "A naturalidade deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String naturalidade;

    // ---------- Filiação ----------

    @NotBlank(message = "Informe o nome da mãe.")
    @Size(max = 120, message = "O nome da mãe deve ter no máximo 120 caracteres.")
    @Column(name = "nome_mae", nullable = false, length = 120)
    private String nomeMae;

    // Opcional: nem todo registro tem o nome do pai.
    @Size(max = 120, message = "O nome do pai deve ter no máximo 120 caracteres.")
    @Column(name = "nome_pai", length = 120)
    private String nomePai;

    // ---------- Documento ----------

    // Validado pelo dígito verificador; o controller grava apenas os dígitos.
    @NotBlank(message = "Informe o CPF.")
    @CPF(message = "CPF inválido.")
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    // ---------- Formação ----------

    @NotBlank(message = "Informe a formação.")
    @Size(max = 120, message = "A formação deve ter no máximo 120 caracteres.")
    @Column(nullable = false, length = 120)
    private String formacao;

    @NotBlank(message = "Informe a cidade/estado da formação.")
    @Size(max = 100, message = "Cidade/estado deve ter no máximo 100 caracteres.")
    @Column(name = "cidade_estado_formacao", nullable = false, length = 100)
    private String cidadeEstadoFormacao;

    @NotBlank(message = "Selecione o grau.")
    @Column(nullable = false, length = 40)
    private String grau;

    @NotNull(message = "Informe o ano de conclusão.")
    @Min(value = 1950, message = "Ano de conclusão inválido.")
    @Max(value = 2100, message = "Ano de conclusão inválido.")
    @Column(name = "ano_conclusao", nullable = false)
    private Integer anoConclusao;

    // ---------- Contato ----------

    @NotBlank(message = "Informe o endereço.")
    @Size(max = 200, message = "O endereço deve ter no máximo 200 caracteres.")
    @Column(nullable = false, length = 200)
    private String endereco;

    @NotBlank(message = "Informe o e-mail.")
    @Email(message = "E-mail inválido.")
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @NotBlank(message = "Informe o telefone.")
    @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
             message = "Telefone inválido. Exemplo: (63) 91234-5678.")
    @Column(nullable = false, length = 20)
    private String telefone;

    // ---------- Getters e setters ----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getNaturalidade() { return naturalidade; }
    public void setNaturalidade(String naturalidade) { this.naturalidade = naturalidade; }

    public String getNomeMae() { return nomeMae; }
    public void setNomeMae(String nomeMae) { this.nomeMae = nomeMae; }

    public String getNomePai() { return nomePai; }
    public void setNomePai(String nomePai) { this.nomePai = nomePai; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getFormacao() { return formacao; }
    public void setFormacao(String formacao) { this.formacao = formacao; }

    public String getCidadeEstadoFormacao() { return cidadeEstadoFormacao; }
    public void setCidadeEstadoFormacao(String cidadeEstadoFormacao) { this.cidadeEstadoFormacao = cidadeEstadoFormacao; }

    public String getGrau() { return grau; }
    public void setGrau(String grau) { this.grau = grau; }

    public Integer getAnoConclusao() { return anoConclusao; }
    public void setAnoConclusao(Integer anoConclusao) { this.anoConclusao = anoConclusao; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}