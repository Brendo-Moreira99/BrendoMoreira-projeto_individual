package modelo;

import java.util.Date;

public class Cliente {

	// atributos
	private int Id_Cliente;
	private String Rua;
	private String Bairro;
	private Date Data_cli;
	private String Municipio;
	private int Numero;
	private String Estado;
	private String Telefone;
	private String Cep;
	private String CPF;
	private String Nome;

	// construtor

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

	
	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
	public Date getData_cli() {
		return Data_cli;
	}


	public void setData_cli(Date data_cli) {
		Data_cli = data_cli;
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

}
