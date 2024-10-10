CREATE TABLE tarefas (
	id integer GENERATED ALWAYS AS IDENTITY (
		START WITH 1
		INCREMENT BY 1
	),
	titulo varchar(100) NOT NULL,
	completa char(1) NOT NULL,
	data_criacao DATE NOT NULL,
	data_limite DATE,
	
	PRIMARY KEY (id)
);

ALTER TABLE TAREFAS 
ADD CONSTRAINT check_completa_is_valid
CHECK (completa IN ('S', 'N'));

-- Criar uma tabela simples com o IDENTITY e uma constraint check em algum campo

INSERT INTO TAREFAS (titulo,completa,DATA_CRIACAO,DATA_LIMITE)
VALUES('Separar roupas','N', SYSDATE,TO_DATE('2024-10-10', 'YYYY-MM-DD'));

DROP TABLE TAREFAS;
