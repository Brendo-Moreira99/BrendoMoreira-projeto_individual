<<<<<<< HEAD
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

	// atributos

	private int Id_Reserva;
	private double Valor_total;
	private String Pagamento;
	
	private Usuario usuario;
	List<Itens_Compra> itens = new ArrayList<Itens_Compra>();

	// construtor

	public Reserva() {

	}

	

	public Reserva(int id_Reserva, double valor_total, String pagamento, Usuario usuario, List<Itens_Compra> itens) {
		
		Id_Reserva = id_Reserva;
		Valor_total = valor_total;
		Pagamento = pagamento;
		this.usuario = usuario;
		this.itens = itens;
	}







	//Getters e setters






	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public int getId_Reserva() {
		return Id_Reserva;
	}

	public void setId_Reserva(int id_Reserva) {
		this.Id_Reserva = id_Reserva;
	}

	public double getValor_total() {
		return Valor_total;
	}

	public void setValor_total(double valor_total) {
		Valor_total = valor_total;
	}

	public String getPagamento() {
		return Pagamento;
	}
	
	public void setPagamento(String pagamento) {
		Pagamento = pagamento;
	}

	public List<Itens_Compra> getItens() {
		return itens;
	}

	public void setItens(List<Itens_Compra> itens) {
		this.itens = itens;
	}


	
	//metodos
	
	public void Pagamento_saber(int pagamento) {
		
		switch (pagamento) {

		case 1: {
			this.Pagamento = "Cartão de Crédito";
			break;
		}
		case 2: {
			this.Pagamento = "Bolheto Bancário";
			break;
		}
		case 3: {
			this.Pagamento = "Cartão de Débito";
			break;
		}
		case 4: {
			this.Pagamento = "PIX";
			break;
		}
		}}
	
	public double Calcular_Total() {
		
		this.Valor_total= 0;
	
		for(int i = 0; i<itens.size();i++) {
			
			this.Valor_total += itens.get(i).getValor_itens();
		
		}	
		return this.Valor_total;
		
	}
}
=======
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

	// atributos

	private int Id_Reserva;
	private double Valor_total;
	private String Pagamento;
	
	private Usuario usuario;
	List<Itens_Compra> itens = new ArrayList<Itens_Compra>();

	// construtor

	public Reserva() {

	}

	

	public Reserva(int id_Reserva, double valor_total, String pagamento, Usuario usuario, List<Itens_Compra> itens) {
		
		Id_Reserva = id_Reserva;
		Valor_total = valor_total;
		Pagamento = pagamento;
		this.usuario = usuario;
		this.itens = itens;
	}







	//Getters e setters






	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public int getId_Reserva() {
		return Id_Reserva;
	}

	public void setId_Reserva(int id_Reserva) {
		this.Id_Reserva = id_Reserva;
	}

	public double getValor_total() {
		return Valor_total;
	}

	public void setValor_total(double valor_total) {
		Valor_total = valor_total;
	}

	public String getPagamento() {
		return Pagamento;
	}
	
	public void setPagamento(String pagamento) {
		Pagamento = pagamento;
	}

	public List<Itens_Compra> getItens() {
		return itens;
	}

	public void setItens(List<Itens_Compra> itens) {
		this.itens = itens;
	}


	
	//metodos
	
	public void Pagamento_saber(int pagamento) {
		
		switch (pagamento) {

		case 1: {
			this.Pagamento = "Cartão de Crédito";
			break;
		}
		case 2: {
			this.Pagamento = "Bolheto Bancário";
			break;
		}
		case 3: {
			this.Pagamento = "Cartão de Débito";
			break;
		}
		case 4: {
			this.Pagamento = "PIX";
			break;
		}
		}}
	
	public double Calcular_Total() {
		
		this.Valor_total= 0;
	
		for(int i = 0; i<itens.size();i++) {
			
			this.Valor_total += itens.get(i).getValor_itens();
		
		}	
		return this.Valor_total;
		
	}
}
>>>>>>> 0f8b9f6a000d2ff7c19dcd3b1c91c4acee1454da
