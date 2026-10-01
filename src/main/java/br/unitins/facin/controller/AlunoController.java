package br.unitins.facin.controller;

import br.unitins.facin.model.Aluno;
import br.unitins.facin.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/cadastro";
    }

    @GetMapping("/cadastro")
    public String formulario(Model model) {
        if (!model.containsAttribute("aluno")) {
            model.addAttribute("aluno", new Aluno());
        }
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String salvar(@Valid Aluno aluno, BindingResult result, RedirectAttributes redirect) {
        // Verifica duplicidade somente quando o campo já passou na validação de formato.
        String cpfDigitos = aluno.getCpf() == null ? null : aluno.getCpf().replaceAll("\\D", "");

        if (!result.hasFieldErrors("cpf") && repository.existsByCpf(cpfDigitos)) {
            result.rejectValue("cpf", "duplicado", "Já existe um cadastro com este CPF.");
        }
        if (!result.hasFieldErrors("email") && repository.existsByEmail(aluno.getEmail())) {
            result.rejectValue("email", "duplicado", "Já existe um cadastro com este e-mail.");
        }

        if (result.hasErrors()) {
            return "cadastro";
        }

        aluno.setCpf(cpfDigitos);
        repository.save(aluno);
        redirect.addFlashAttribute("mensagem", "Cadastro realizado com sucesso!");
        return "redirect:/cadastro";
    }
}
