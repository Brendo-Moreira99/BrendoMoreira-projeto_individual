package com.org.recode.NovosAres.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int Id_Usuario;
	 
	 @Column(nullable=false)
	 private String Senha;
	 
	 @Column(nullable=false)
	  private String email;
	 
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @JoinColumn(name = "cliente_id_fk", nullable = false)
	 private Cliente cliente;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "permissao_id_fk", nullable = false)
	 private Permissao permissao;

	public Usuario() {
		
	}

	public Usuario(int id_Usuario, String senha, String email, Cliente cliente, Permissao permissao) {
		
		Id_Usuario = id_Usuario;
		Senha = senha;
		this.email = email;
		this.cliente = cliente;
		this.permissao = permissao;
	}

	public int getId_Usuario() {
		return Id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		Id_Usuario = id_Usuario;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_Usuario, Senha, cliente, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Id_Usuario == other.Id_Usuario && Objects.equals(Senha, other.Senha)
				&& Objects.equals(cliente, other.cliente) && Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "Usuario [Id_Usuario=" + Id_Usuario + ", Senha=" + Senha + ", email=" + email + ", cliente=" + cliente
				+ "]";
	}
	 
	 
}
