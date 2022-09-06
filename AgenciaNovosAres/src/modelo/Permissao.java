package modelo;

public class Permissao {

	private int Id_Permissao;
	private String Tipo;

	//construtor
	public Permissao() {

	}

	public Permissao(int id_Permissao, String tipo) {

		this.Id_Permissao = id_Permissao;
		Tipo = tipo;
	}
	
	//getters e setters
	public int getId_Permissao() {
		return Id_Permissao;
	}

	public void setId_Permissao(int id_Permissao) {
		this.Id_Permissao = id_Permissao;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	// Metodos
	

	
}
