package modelo;

public class DiariasHotelaria {
	
	private int Id_Hotel;
	private int Qtd_dias;
	private String Rua;
	private int Numero;
	private String Cep;
	private String Estado;
	private String Municipio;
	private String Nome_Hotel;
	private int Qtd_Quartos;
	
	
	
	public DiariasHotelaria() {


	}
	
	public DiariasHotelaria(int id_Hotel, int qtd_dias, String rua, int numero, String cep, String estado,
			String municipio, String nome_Hotel, int qtd_Quartos) {
		super();
		Id_Hotel = id_Hotel;
		Qtd_dias = qtd_dias;
		Rua = rua;
		Numero = numero;
		Cep = cep;
		Estado = estado;
		Municipio = municipio;
		Nome_Hotel = nome_Hotel;
		Qtd_Quartos = qtd_Quartos;
	}

	
	public int getId_Hotel() {
		return Id_Hotel;
	}
	public void setId_Hotel(int id_Hotel) {
		Id_Hotel = id_Hotel;
	}
	public int getQtd_dias() {
		return Qtd_dias;
	}
	public void setQtd_dias(int qtd_dias) {
		Qtd_dias = qtd_dias;
	}
	public String getRua() {
		return Rua;
	}
	public void setRua(String rua) {
		Rua = rua;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
	public String getNome_Hotel() {
		return Nome_Hotel;
	}
	public void setNome_Hotel(String nome_Hotel) {
		Nome_Hotel = nome_Hotel;
	}
	public int getQtd_Quartos() {
		return Qtd_Quartos;
	}
	public void setQtd_Quartos(int qtd_Quartos) {
		Qtd_Quartos = qtd_Quartos;
	}
	
	

}
