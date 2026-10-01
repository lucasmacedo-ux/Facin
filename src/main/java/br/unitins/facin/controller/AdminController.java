package br.unitins.facin.controller;

import br.unitins.facin.model.Aluno;
import br.unitins.facin.repository.AlunoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AlunoRepository repository;

    public AdminController(AlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        List<Aluno> alunos;
        if (busca == null || busca.isBlank()) {
            alunos = repository.findAll(Sort.by("nome"));
        } else {
            alunos = repository.findByNomeContainingIgnoreCaseOrderByNomeAsc(busca.trim());
        }
        model.addAttribute("alunos", alunos);
        model.addAttribute("busca", busca);
        return "admin/lista";
    }

    @GetMapping("/alunos/{id}")
    public String detalhe(@PathVariable Long id, Model model) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("aluno", aluno);
        return "admin/detalhe";
    }

    @PostMapping("/alunos/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes redirect) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            redirect.addFlashAttribute("mensagem", "Cadastro excluído.");
        }
        return "redirect:/admin";
    }
}
