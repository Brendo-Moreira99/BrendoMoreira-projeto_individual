<<<<<<< HEAD
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Voo {

	private int Id_Voo;
	private String Local_Partida;
	private int Quantidade_Pessoas;
	private String Destino;
	private LocalDate Data_ida;
	private LocalDate Data_volta;
	private double Valor_viagem;
	private String Transfer;

	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// construtor

	public Voo() {

	}

	public Voo(int id_Voo, String local_Partida, int quantidade_Pessoas, String destino, String data_ida,
			String data_volta, double valor_viagem, String transfer) {

		Id_Voo = id_Voo;
		Local_Partida = local_Partida;
		Quantidade_Pessoas = quantidade_Pessoas;
		Destino = destino;
		Data_ida = LocalDate.parse(data_ida, formatter2);
		Data_volta = LocalDate.parse(data_volta, formatter1);
		Valor_viagem = valor_viagem;
		Transfer = transfer;

	}

	// getters e setters
	public int getId_Voo() {
		return Id_Voo;
	}

	public void setId_Voo(int id_Voo) {
		Id_Voo = id_Voo;
	}

	public String getLocal_Partida() {
		return Local_Partida;
	}

	public void setLocal_Partida(String local_Partida) {
		Local_Partida = local_Partida;
	}

	public int getQuantidade_Pessoas() {
		return Quantidade_Pessoas;
	}

	public void setQuantidade_Pessoas(int quantidade_Pessoas) {
		Quantidade_Pessoas = quantidade_Pessoas;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public void setData_ida(String data_ida) {
		this.Data_ida = LocalDate.parse(data_ida, formatter2);
	}

	public String getData_ida() {
		return formatter2.format(Data_ida);
	}

	public void setData_volta(String data_volta) {
		this.Data_volta = LocalDate.parse(data_volta, formatter1);
	}

	public String getData_volta() {
		return formatter1.format(Data_volta);
	}

	public double getValor_viagem() {
		return Valor_viagem;
	}

	public void setValor_viagem(double valor_viagem) {
		Valor_viagem = valor_viagem;
	}

	public String getTransfer() {
		return Transfer;
	}

	public void setTransfer(String transfer) {
		Transfer = transfer;
	}

	// método

	public void Transfer_saber(int transfer) {
		switch (transfer) {

		case 1: {
			this.Transfer = "in/out";
			break;
		}
		case 2: {
			this.Transfer = "in";
			break;
		}
		case 3: {
			this.Transfer = "out";
			break;
		}
		}
	}
=======
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Voo {

	private int Id_Voo;
	private String Local_Partida;
	private int Quantidade_Pessoas;
	private String Destino;
	private LocalDate Data_ida;
	private LocalDate Data_volta;
	private double Valor_viagem;
	private String Transfer;

	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// construtor

	public Voo() {

	}

	public Voo(int id_Voo, String local_Partida, int quantidade_Pessoas, String destino, String data_ida,
			String data_volta, double valor_viagem, String transfer) {

		Id_Voo = id_Voo;
		Local_Partida = local_Partida;
		Quantidade_Pessoas = quantidade_Pessoas;
		Destino = destino;
		Data_ida = LocalDate.parse(data_ida, formatter2);
		Data_volta = LocalDate.parse(data_volta, formatter1);
		Valor_viagem = valor_viagem;
		Transfer = transfer;

	}

	// getters e setters
	public int getId_Voo() {
		return Id_Voo;
	}

	public void setId_Voo(int id_Voo) {
		Id_Voo = id_Voo;
	}

	public String getLocal_Partida() {
		return Local_Partida;
	}

	public void setLocal_Partida(String local_Partida) {
		Local_Partida = local_Partida;
	}

	public int getQuantidade_Pessoas() {
		return Quantidade_Pessoas;
	}

	public void setQuantidade_Pessoas(int quantidade_Pessoas) {
		Quantidade_Pessoas = quantidade_Pessoas;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public void setData_ida(String data_ida) {
		this.Data_ida = LocalDate.parse(data_ida, formatter2);
	}

	public String getData_ida() {
		return formatter2.format(Data_ida);
	}

	public void setData_volta(String data_volta) {
		this.Data_volta = LocalDate.parse(data_volta, formatter1);
	}

	public String getData_volta() {
		return formatter1.format(Data_volta);
	}

	public double getValor_viagem() {
		return Valor_viagem;
	}

	public void setValor_viagem(double valor_viagem) {
		Valor_viagem = valor_viagem;
	}

	public String getTransfer() {
		return Transfer;
	}

	public void setTransfer(String transfer) {
		Transfer = transfer;
	}

	// método

	public void Transfer_saber(int transfer) {
		switch (transfer) {

		case 1: {
			this.Transfer = "in/out";
			break;
		}
		case 2: {
			this.Transfer = "in";
			break;
		}
		case 3: {
			this.Transfer = "out";
			break;
		}
		}
	}
>>>>>>> 0f8b9f6a000d2ff7c19dcd3b1c91c4acee1454da
}