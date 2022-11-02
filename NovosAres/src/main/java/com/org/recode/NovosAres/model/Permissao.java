package com.org.recode.NovosAres.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Permissao {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int Id_permissao;
	 
	 @Column (nullable = false)
	 private String Tipo;
	 
	 @OneToMany(mappedBy = "permissao", fetch = FetchType.LAZY)
	 private List<Usuario> usuario;

	public Permissao() {
		
	}

	public Permissao(int id_permissao, String tipo, List<Usuario> usuario) {
		
		Id_permissao = id_permissao;
		Tipo = tipo;
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_permissao, Tipo, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		return Id_permissao == other.Id_permissao && Objects.equals(Tipo, other.Tipo)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Permissao [Id_permissao=" + Id_permissao + ", Tipo=" + Tipo + ", usuario=" + usuario + "]";
	}
	 
	
	 
}
