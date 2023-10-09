package curso.springboot.controller;

import curso.springboot.model.Projeto;
import curso.springboot.repository.ProjetoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

  @Autowired
  private ProjetoRepository projetoRepository;

  @GetMapping("/")
  public String listarProjetos(Model model) {
    List<Projeto> projetos = (List<Projeto>) projetoRepository.findAll();
    model.addAttribute("projetos", projetos);
    return "projeto/list";
  }

  @GetMapping("/novo")
  public String novoProjetoForm(Model model) {
    model.addAttribute("projeto", new Projeto());
    return "projeto/form";
  }

  @PostMapping("/novo")
  public String salvarProjeto(@ModelAttribute("projeto") Projeto projeto) {
    projetoRepository.save(projeto);
    return "redirect:/projetos/";
  }

  @GetMapping("/{id}/editar")
  public String editarProjetoForm(@PathVariable Long id, Model model) {
    Projeto projeto = projetoRepository.findById(id).orElse(null);
    model.addAttribute("projeto", projeto);
    return "projeto/form";
  }

  @PostMapping("/{id}/editar")
  public String atualizarProjeto(
    @PathVariable Long id,
    @ModelAttribute("projeto") Projeto projeto
  ) {
    projetoRepository.save(projeto);
    return "redirect:/projetos/";
  }

  @GetMapping("/{id}/excluir")
  public String excluirProjeto(@PathVariable Long id) {
    projetoRepository.deleteById(id);
    return "redirect:/projetos/";
  }
}
