-- tables
-- Table: Ahorros
CREATE TABLE Ahorros (
    save_id SERIAL NOT NULL,
    amount int NULL,
    client_id int NOT NULL,
    CONSTRAINT Ahorros_pk PRIMARY KEY (save_id)
);

-- Table: Card
CREATE TABLE Card (
    card_id SERIAL NOT NULL,
    type_id int NOT NULL,
    CONSTRAINT Card_pk PRIMARY KEY (card_id)
);

-- Table: Cliente
CREATE TABLE Cliente (
    client_id SERIAL NOT NULL,
    first_name varchar(128) NULL,
    last_name varchar(128) NULL,
    gender varchar(20) NULL,
    client_age int NULL,
    address varchar(128) NOT NULL,
    card_id int NOT NULL,
    CONSTRAINT Cliente_pk PRIMARY KEY (client_id)
);

-- Table: Consulta_saldo
CREATE TABLE Consulta_saldo (
    bal_id SERIAL NOT NULL,
    saldo int NULL,
    client_id int NOT NULL,
    CONSTRAINT Consulta_saldo_pk PRIMARY KEY (bal_id)
);

-- Table: Credito
CREATE TABLE Credito (
                         credito_id SERIAL primary key,
                         garante varchar(100) NULL,
                         ingreso int NULL,
                         cantidadT decimal NOT NULL,
                         cantidadF decimal NULL,
                         cuotas int NOT NULL,
                         cuotasR int NULL,
                         cuotasP int NULL,
                         fechaC date,
                         inmueble varchar(100) NULL,
                         client_id int NOT NULL
);

-- Table: Deposito
CREATE TABLE Deposito (
    deposit_id SERIAL NOT NULL,
    amount int NULL,
    client_id int NOT NULL,
    CONSTRAINT Deposito_pk PRIMARY KEY (deposit_id)
);

-- Table: Registros
CREATE TABLE Registros (
    record_id SERIAL NOT NULL,
    typeT_id int NOT NULL,
    client_id int NOT NULL,
    card_id int NOT NULL,
    record_date timestamp NOT NULL,
    CONSTRAINT Registros_pk PRIMARY KEY (record_id)
);

-- Table: Retiro
CREATE TABLE Retiro (
    with_id SERIAL NOT NULL,
    amount int NULL,
    client_id int NOT NULL,
    CONSTRAINT Retiro_pk PRIMARY KEY (with_id)
);

-- Table: Transaction_type
CREATE TABLE Transaction_type (
    typeT_id SERIAL NOT NULL,
    save_id int NOT NULL,
    bal_id int NOT NULL,
    with_id int NOT NULL,
    deposit_id int NOT NULL,
    CONSTRAINT Transaction_type_pk PRIMARY KEY (typeT_id)
);

-- Table: Type_Card
CREATE TABLE Type_Card (
    type_id SERIAL NOT NULL,
    type_card varchar(128) NULL,
    CONSTRAINT Type_Card_pk PRIMARY KEY (type_id)
);

-- foreign keys
-- Reference: Card_Type_Card (table: Card)
ALTER TABLE Card ADD CONSTRAINT Card_Type_Card FOREIGN KEY (type_id)
    REFERENCES Type_Card (type_id);

-- Reference: Consulta_saldo_Cliente (table: Consulta_saldo)
ALTER TABLE Consulta_saldo ADD CONSTRAINT Consulta_saldo_Cliente FOREIGN KEY (client_id)
    REFERENCES Cliente (client_id);

-- Reference: Copy_of_client_Card (table: Cliente)
ALTER TABLE Cliente ADD CONSTRAINT Client_Card FOREIGN KEY  (card_id)
    REFERENCES Card (card_id);

-- Reference: Credito_Cliente (table: Credito)
ALTER TABLE Credito ADD CONSTRAINT Credito_Cliente FOREIGN KEY (client_id)
    REFERENCES Cliente (client_id);

-- Reference: Deposito_Cliente (table: Deposito)
ALTER TABLE Deposito ADD CONSTRAINT Deposito_Cliente FOREIGN KEY (client_id)
    REFERENCES Cliente (client_id);

-- Reference: Registros_Card (table: Registros)
ALTER TABLE Registros ADD CONSTRAINT Registros_Card FOREIGN key (card_id)
    REFERENCES Card (card_id);

-- Reference: Registros_Cliente (table: Registros)
ALTER TABLE Registros ADD CONSTRAINT Registros_Cliente FOREIGN key (client_id)
    REFERENCES Cliente (client_id);

-- Reference: Registros_Transaction_type (table: Registros)
ALTER TABLE Registros ADD CONSTRAINT Registros_Transaction_type FOREIGN KEY (typeT_id)
    REFERENCES Transaction_type (typeT_id);

-- Reference: Retiro_Cliente (table: Retiro)
ALTER TABLE Retiro ADD CONSTRAINT Retiro_Cliente FOREIGN KEY (client_id)
    REFERENCES Cliente (client_id);

-- Reference: Savings_Copy_of_client (table: Ahorros)
ALTER TABLE Ahorros ADD CONSTRAINT Savings_client FOREIGN key (client_id)
    REFERENCES Cliente (client_id);

-- Reference: Transaction_type_Ahorros (table: Transaction_type)
ALTER TABLE Transaction_type ADD CONSTRAINT Transaction_type_Ahorros FOREIGN KEY (save_id)
    REFERENCES Ahorros (save_id);

-- Reference: Transaction_type_Consulta_saldo (table: Transaction_type)
ALTER TABLE Transaction_type ADD CONSTRAINT Transaction_type_Consulta_saldo FOREIGN KEY (bal_id)
    REFERENCES Consulta_saldo (bal_id);

-- Reference: Transaction_type_Deposito (table: Transaction_type)
ALTER TABLE Transaction_type ADD CONSTRAINT Transaction_type_Deposito FOREIGN key (deposit_id)
    REFERENCES Deposito (deposit_id);

-- Reference: Transaction_type_Retiro (table: Transaction_type)
ALTER TABLE Transaction_type ADD CONSTRAINT Transaction_type_Retiro FOREIGN KEY (with_id)
    REFERENCES Retiro (with_id);

-- End of file.