package modelo;

public class Itens_Compra {
	
	private int Id_itensCompra;
	private int Quantidade;
	private double valor_itens;
	private Voo voo;
	private Pacote pack;
	private Reserva reserva;
	

	public Itens_Compra() {
		
	}


	public Itens_Compra(int id_itensCompra, int quantidade, double valor_itens, Voo voo, Pacote pack, Reserva reserva) {
		
		Id_itensCompra = id_itensCompra;
		Quantidade = quantidade;
		this.valor_itens = valor_itens;
		this.voo = voo;
		this.pack = pack;
		this.reserva = reserva;
	}



	public int getId_itensCompra() {
		return Id_itensCompra;
	}
	public void setId_itensCompra(int id_itensCompra) {
		Id_itensCompra = id_itensCompra;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public double getValor_itens() {
		return valor_itens;
	}
	public void setValor_itens(double valor_itens) {
		this.valor_itens = valor_itens;
	}
	public Voo getVoo() {
		return voo;
	}
	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	public Pacote getPack() {
		return pack;
	}
	public void setPack(Pacote pack) {
		this.pack = pack;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	//métodos
	
	public double Calcular_Itens(){
		
		this.valor_itens = this.Quantidade*(pack.getValor_Pacote() + voo.getValor_viagem());
		
		reserva.Calcular_Total();
		
		return this.valor_itens;
	}         
}
