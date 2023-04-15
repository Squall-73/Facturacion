CREATE TABLE IF NOT EXISTS clients(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(75),
    lastname varchar(75),
    docNumber varchar(11) NOT NULL UNIQUE,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS invoice(
    id int NOT NULL AUTO_INCREMENT,
    client_id INT NOT NULL,
    created_at DATE,
    total double DEFAULT 0,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (id),
    CONSTRAINT fk_id_client_tbl	FOREIGN KEY(client_id) REFERENCES clients(id)
	);



CREATE TABLE IF NOT EXISTS products(
    id int NOT NULL AUTO_INCREMENT,
    description varchar(150),
    code varchar(50),
    stock int,
    price double,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (id)
    );



CREATE TABLE IF NOT EXISTS invoice_details(
    invoice_details_id int NOT NULL AUTO_INCREMENT,
    invoice_id int NOT NULL,
    amount int,
    product_id int NOT NULL,
    product_price double NOT NULL,
    price double NOT NULL,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (invoice_details_id),
    CONSTRAINT fk_id_product_tbl FOREIGN KEY(product_id) REFERENCES products(id),
    CONSTRAINT fk_id_invoice_tbl FOREIGN KEY(invoice_id) REFERENCES invoice(id)
    );

INSERT INTO CLIENTS (NAME, LASTNAME ,DOCNUMBER)
VALUES ('Jon','Snow','30000000'),
       ('Robb','Stark','30000001'),
       ('Tyrion','Lannister','30000002'),
       ('Petyr','Baelish','30000003'),
       ('Daenerys','Targaryen','30000004'),
       ('Davos','Seaworth','30000005'),
       ('Jorah','Mormont','30000006'),
       ('Asha','Greyjoy','30000007'),
       ('Edmure','Tully','30000008'),
       ('Robert','Baratheon','30000009');

INSERT INTO PRODUCTS (CODE ,DESCRIPTION ,STOCK ,PRICE )
VALUES('A0001','Pan lactal',100,500.00),
      ('A0002','Yerba Mate',100,750.00),
      ('A0003','Leche Larga Vida',100,300.00),
      ('A0004','Gaseosa 2L',100,250.00),
      ('A0005','Queso Untable',100,125.00),
      ('B0001','Detergente',100,150.00),
      ('B0002','Jabon en polvo',100,800.00),
      ('B0003','Desodorante de ambiente',100,100.00),
      ('B0004','Suavizante para ropa',100,390.00),
      ('B0005','Trapo de piso',100,150.00);








