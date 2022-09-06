package modelo;

public class Usuario {
	
	private int id;
	private String senha;
	private String email;
	private Permissao permissao;
	private Cliente cliente;
	
	public Usuario(){
		
	}
	
	
	
	public Usuario(int id, String senha, String email, Permissao permissao, Cliente cliente) {
		
		this.id = id;
		this.senha = senha;
		this.email = email;
		this.permissao = permissao;
		this.cliente = cliente;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	


	
}
