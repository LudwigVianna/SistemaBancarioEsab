
CREATE TABLE CLIENTE (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    endereco VARCHAR(255),
    telefone VARCHAR(20)
);


CREATE TABLE AGENCIA (
    id_agencia INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    numero INT NOT NULL UNIQUE,
    endereco VARCHAR(255)
);


CREATE TABLE SALDO (
    id_saldo INT PRIMARY KEY AUTO_INCREMENT,
    saldo_atual DECIMAL(10, 2) NOT NULL,
    data_hora DATETIME NOT NULL
);


CREATE TABLE TRANSFERENCIAS (
    id_transferencia INT PRIMARY KEY AUTO_INCREMENT,
    data_hora_transferencia DATETIME NOT NULL,
    valor_transferencia DECIMAL(10, 2) NOT NULL,
    id_origem INT,
    id_destino INT,
    FOREIGN KEY (id_origem) REFERENCES CLIENTE(id_cliente),
    FOREIGN KEY (id_destino) REFERENCES CLIENTE(id_cliente)
);
