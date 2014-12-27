package br.com.javabeer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.javabeer.dao.UsuarioDAO;
import br.com.javabeer.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@Override
	@Transactional
	public void salvarUsuario(Usuario u) {
		this.usuarioDAO.salvarUsuario(u);
	}

	@Override
	@Transactional
	public void atualizarUsuario(Usuario u) {
		this.usuarioDAO.atualizarUsuario(u);
	}

	@Override
	@Transactional
	public List<Usuario> listarUsuarios() {
		return this.usuarioDAO.listarUsuarios();
	}

	@Override
	@Transactional
	public void removerUsuario(Integer id) {
		this.usuarioDAO.removerUsuario(id);
	}

	@Override
	@Transactional
	public Usuario getUsuarioPorId(Integer id) {
		return this.usuarioDAO.getUsuarioPorId(id);
	}


}
