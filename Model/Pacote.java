package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pacote {
	private int Id_itens_Pacote;
	private int Quantidade_Pessoas;
	private String Tipo;
	private double Valor_Pacote;
	private String Destino;
	private LocalDate Pacote_ida;
	private LocalDate Pacote_volta;
	private String Transfer_pacote;

	private DiariasHotelaria hotelaria;
	private List<DiariasHotelaria> diarias = new ArrayList<>();

	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// construtor

	public Pacote() {

	}

	public Pacote(int id_itens_Pacote, int quantidade_Pessoas, String tipo, double valor_Pacote, String destino,
			String pacote_ida, String pacote_volta, DiariasHotelaria hotelaria, List<DiariasHotelaria> diarias,
			String transfer_pacote) {

		Id_itens_Pacote = id_itens_Pacote;
		Quantidade_Pessoas = quantidade_Pessoas;
		Tipo = tipo;
		Valor_Pacote = valor_Pacote;
		Destino = destino;
		Pacote_ida = LocalDate.parse(pacote_ida, formatter1);
		Pacote_volta = LocalDate.parse(pacote_volta, formatter1);
		this.hotelaria = hotelaria;
		this.diarias = diarias;
		this.Transfer_pacote = transfer_pacote;

	}

	// getters e setters

	public int getId_itens() {
		return Id_itens_Pacote;
	}

	public void setId_itens(int id_itens) {
		Id_itens_Pacote = id_itens;
	}

	public int getQuantidade_Pessoas() {
		return Quantidade_Pessoas;
	}

	public void setQuantidade_Pessoas(int quantidade_Pessoas) {
		Quantidade_Pessoas = quantidade_Pessoas;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public double getValor_Pacote() {
		return Valor_Pacote;
	}

	public void setValor_Pacote(double valor_Pacote) {
		Valor_Pacote = valor_Pacote;
	}

	public List<DiariasHotelaria> getDiarias() {
		return diarias;
	}

	public void setDiarias(List<DiariasHotelaria> diarias) {
		this.diarias = diarias;
	}

	public int getId_itens_Pacote() {
		return Id_itens_Pacote;
	}

	public void setId_itens_Pacote(int id_itens_Pacote) {
		Id_itens_Pacote = id_itens_Pacote;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public String getPacote_ida() {
		return formatter1.format(this.Pacote_ida);
	}

	public void setPacote_ida(String pacote_ida) {
		this.Pacote_ida = LocalDate.parse(pacote_ida, formatter1);
	}

	public String getPacote_volta() {
		return formatter1.format(this.Pacote_volta);
	}

	public void setPacote_volta(String pacote_volta) {
		this.Pacote_volta = LocalDate.parse(pacote_volta, formatter1);
	}

	public DiariasHotelaria getHotelaria() {
		return hotelaria;
	}

	public void setHotelaria(DiariasHotelaria hotelaria) {
		this.hotelaria = hotelaria;

	}

	public String getTransfer_pacote() {
		return Transfer_pacote;
	}

	public void setTransfer_pacote(String transfer_pacote) {
		Transfer_pacote = transfer_pacote;
	}

	// metodo

	public void Tipo_saber(int quantidade) {

		this.Tipo = "";

		if (quantidade == 1) {
			this.Tipo = "Solteiro";

		} else if (quantidade == 2) {

			this.Tipo = "Casal";
		} else if (quantidade >= 3) {
			this.Tipo = "Familia";
		}

	}

	public void Transferpacote_saber(int transfer) {
		switch (transfer) {

		case 1: {
			this.Transfer_pacote = "in/out";
			break;
		}
		case 2: {
			this.Transfer_pacote = "in";
			break;
		}
		case 3: {
			this.Transfer_pacote = "out";
			break;
		}
		case 4:{
			this.Transfer_pacote = "sem transfer";
			
			break;
		}
		}
	}
}

