CREATE SEQUENCE seq_product_sku
START WITH 10000
INCREMENT BY 1;

SELECT seq_product_sku.nextval FROM dual

DROP TABLE product

CREATE TABLE product (
    id integer GENERATED ALWAYS AS IDENTITY (
        START WITH 1
        INCREMENT BY 10 -- 1, 11, 21, 31, 
    ),
    product_name varchar(100) NOT NULL,
    sku integer DEFAULT seq_product_sku.nextval NOT NULL UNIQUE,
    creation_date DATE NOT NULL,
    expiration_date DATE,
    
    PRIMARY KEY (id)
);


ALTER TABLE product
ADD CONSTRAINT check_expiration_date 
CHECK (expiration_date > creation_date);


INSERT INTO product
	( product_name, creation_date )
VALUES	
	( 'Mostarda', SYSDATE )
