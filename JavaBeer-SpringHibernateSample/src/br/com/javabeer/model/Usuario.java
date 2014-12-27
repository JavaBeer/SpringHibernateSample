package br.com.javabeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	private String nome;
	private String sobrenome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@Override
	public String toString(){
		return "id="+id+", nome="+nome+", sobrenome="+sobrenome;
	}

}
