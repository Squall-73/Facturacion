CREATE TABLE IF NOT EXISTS clients(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(75),
    lastname varchar(75),
    docNumber varchar(11) NOT NULL UNIQUE,
    PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS invoice(
    id int NOT NULL AUTO_INCREMENT,
    client_id INT NOT NULL,
    created_at DATETIME,
    total double,
    PRIMARY KEY (id),
    CONSTRAINT fk_id_client_tbl	FOREIGN KEY(client_id) REFERENCES clients(id)
	);



CREATE TABLE IF NOT EXISTS products(
    id int NOT NULL AUTO_INCREMENT,
    description varchar(150),
    code varchar(50),
    stock int,
    price double,
    PRIMARY KEY (id)
    );



CREATE TABLE IF NOT EXISTS invoice_details(
    invoice_details_id int NOT NULL AUTO_INCREMENT,
    invoice_id int NOT NULL,
    amount int,
    product_id int NOT NULL,
    price double,
    PRIMARY KEY (invoice_details_id),
    CONSTRAINT fk_id_product_tbl FOREIGN KEY(product_id) REFERENCES products(id),
    CONSTRAINT fk_id_invoice_tbl FOREIGN KEY(invoice_id) REFERENCES invoice(id)
    );




