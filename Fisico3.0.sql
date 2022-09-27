-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Cliente (
Rua  VARCHAR(10),
Bairro VARCHAR(10),
Cidade VARCHAR(10),
Municipio VARCHAR(10),
Numero VARCHAR(10),
Estado VARCHAR(10),
Telefone NUMERIC(10),
Id_Cliente INTEGER PRIMARY KEY,
Cep VARCHAR(10),
Cpf VARCHAR(15),
Nome VARCHAR(50)
)

CREATE TABLE Permissão (
Id_Permissao INTEGER PRIMARY KEY,
Tipo VARCHAR(10)
)

CREATE TABLE Usuario (
id_Usuario INTEGER PRIMARY KEY,
Senha VARCHAR(15),
Email VARCHAR(15),
Id_Permissao INTEGER,
Id_Cliente INTEGER,
FOREIGN KEY(Id_Permissao) REFERENCES Permissão (Id_Permissao),
FOREIGN KEY(Id_Cliente) REFERENCES Cliente (Id_Cliente)
)

CREATE TABLE Diarias+Hotelaria (
Id_Hotel INTEGER PRIMARY KEY,
Qtd_dias INTEGER,
Rua VARCHAR(40),
Cep VARCHAR(10),
Estado VARCHAR(40),
Municipio VARCHAR(40),
Numero INTEGER,
Nome_Hotel VARCHAR(40),
-- Erro: nome do campo duplicado nesta tabela!
Qtd_Quartos INTEGER
)

CREATE TABLE Voo (
Id_Voo INTEGER PRIMARY KEY,
Local_Partida VARCHAR(40),
Quantidade_Pessoas INTEGER,
Destino VARCHAR(40),
Data_volta DATETIME,
Data_ida DATETIME,
Transfer VARCHAR(10),
Valor_voo NUMERIC(10)
)

CREATE TABLE Itens_Compra (
Id_itensCompra INTEGER PRIMARY KEY,
Quantidade VARCHAR(10),
Valor_Itens VARCHAR(10),
Id_Reserva INTEGER,
Id_Itens_Pacote VARCHAR(10),
Id_Voo INTEGER,
FOREIGN KEY(Id_Voo) REFERENCES Voo (Id_Voo)
FOREIGN KEY(Id_Reserva) REFERENCES Reserva (Id_Reserva)
FOREIGN KEY(Id_Itens_Pacote) REFERENCES Pacote (Id_Itens_Pacote)
)

CREATE TABLE Reserva (
Id_Reserva INTEGER PRIMARY KEY,
Valor_total DECIMAL(10),
Pagamento VARCHAR(10),
id_Usuario INTEGER,
FOREIGN KEY(id_Usuario) REFERENCES Usuario (id_Usuario)
)

CREATE TABLE Pacote (
Id_Itens_Pacote VARCHAR(10) PRIMARY KEY,
Quantidade_Pessoas INTEGER,
Tipo VARCHAR(15),
Valor_Pacote DECIMAL(10),
Id_Voo INTEGER,
Id_Hotel INTEGER,
FOREIGN KEY(Id_Voo) REFERENCES Voo (Id_Voo),
FOREIGN KEY(Id_Hotel) REFERENCES Diarias+Hotelaria (Id_Hotel)
)

ALTER TABLE Itens_Compra ADD FOREIGN KEY(Id_Reserva) REFERENCES Reserva (Id_Reserva)
ALTER TABLE Itens_Compra ADD FOREIGN KEY(Id_Itens_Pacote) REFERENCES Pacote (Id_Itens_Pacote)
