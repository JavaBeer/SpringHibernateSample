package br.com.javabeer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.javabeer.model.Usuario;
import br.com.javabeer.service.UsuarioService;

@Controller
public class UsuarioController {
	private UsuarioService usuarioService;
	
	@Autowired(required = true)
	@Qualifier(value="usuarioService")
	public void setUsuarioService(UsuarioService us) {
		this.usuarioService = us;
	}
	
	@RequestMapping("/usuarios")
	public String listarUsuarios(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaDeUsuarios", this.usuarioService.listarUsuarios());
		return "usuario";
	}
	
	@RequestMapping(value="/usuario/salvarOuAtualizar", method = RequestMethod.POST)
	public String salvarOuAtualizar(@ModelAttribute("usuario") Usuario u) {
		if (u.getId() == null) {
			this.usuarioService.salvarUsuario(u);
		} else {
			this.usuarioService.atualizarUsuario(u);
		}
		return "redirect:/usuarios";
	}
	
	@RequestMapping("/remover/{id}")
	public String removerUsuario(@PathVariable("id") Integer id) {
		this.usuarioService.removerUsuario(id);
		return "redirect:/usuarios";
	}
	
	@RequestMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("usuario", this.usuarioService.getUsuarioPorId(id));
		model.addAttribute("listaDeUsuarios", this.usuarioService.listarUsuarios());
		return "usuario";
	}
	
}
