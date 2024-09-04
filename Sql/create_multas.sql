CREATE SEQUENCE SEQ_MULTAS
START WITH 1
INCREMENT BY 1;

CREATE TABLE MULTAS (
  id NUMBER(4) PRIMARY KEY,
  id_carro NUMBER(4) REFERENCES CARROS(id),
  data DATE NOT NULL,
  valor NUMBER(10, 2) NOT NULL,
  descricao VARCHAR2(255),
  paga CHAR(1) DEFAULT 'N' CHECK (paga IN ('S', 'N'))
);
