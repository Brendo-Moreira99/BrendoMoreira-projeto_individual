package com.org.recode.NovosAres.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Cliente {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int Id_Cliente;
	   
	   @Column (nullable = false)
		private String Rua;
	   
	   @Column  (nullable = false)
		private String Bairro;
	   
	   @DateTimeFormat(pattern = "dd/MM/yyyy")
		private Date Data_cli;
	   
	   @Column  (nullable = false)
		private String Municipio;
	   
	   @Column  (nullable = false)
		private int Numero;
	   
	   @Column  (nullable = false)
		private String Estado;
	   
	   @Column  (nullable = false)
		private String Telefone;
	   
	   @Column  (nullable = false)
		private String Cep;
	   
	   @Column  (nullable = false)
		private String CPF;
	   
	   @Column  (nullable = false)
		private String Nome;
	   
	   
		public Cliente() {
			
		}

	public Cliente(int id_Cliente, String rua, String bairro, Date data_cli, String municipio, int numero,
			String estado, String telefone, String cep, String cPF, String nome) {
		
		Id_Cliente = id_Cliente;
		Rua = rua;
		Bairro = bairro;
		Data_cli = data_cli;
		Municipio = municipio;
		Numero = numero;
		Estado = estado;
		Telefone = telefone;
		Cep = cep;
		CPF = cPF;
		Nome = nome;
	}

	
	public int getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public Date getData_cli() {
		return Data_cli;
	}

	public void setData_cli(Date data_cli) {
		
		Data_cli = data_cli;
	}

	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCep() {
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Bairro, CPF, Cep, Data_cli, Estado, Id_Cliente, Municipio, Nome, Numero, Rua, Telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(Bairro, other.Bairro) && Objects.equals(CPF, other.CPF) && Objects.equals(Cep, other.Cep)
				&& Objects.equals(Data_cli, other.Data_cli) && Objects.equals(Estado, other.Estado)
				&& Id_Cliente == other.Id_Cliente && Objects.equals(Municipio, other.Municipio)
				&& Objects.equals(Nome, other.Nome) && Numero == other.Numero && Objects.equals(Rua, other.Rua)
				&& Objects.equals(Telefone, other.Telefone);
	}

	@Override
	public String toString() {
		return "Cliente [Id_Cliente=" + Id_Cliente + ", Rua=" + Rua + ", Bairro=" + Bairro + ", Data_cli=" + Data_cli
				+ ", Municipio=" + Municipio + ", Numero=" + Numero + ", Estado=" + Estado + ", Telefone=" + Telefone
				+ ", Cep=" + Cep + ", CPF=" + CPF + ", Nome=" + Nome + "]";
	}




	
	
	
	
	
	   
	
}
