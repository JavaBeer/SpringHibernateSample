package br.com.javabeer.dao;

import java.util.List;

import br.com.javabeer.model.Usuario;

public interface UsuarioDAO {

	public void salvarUsuario(Usuario u);
	public void atualizarUsuario(Usuario u);
	public List<Usuario> listarUsuarios();
	public void removerUsuario(Integer id);
	public Usuario getUsuarioPorId(Integer id);
}
