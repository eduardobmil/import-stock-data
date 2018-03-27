CREATE TABLE cotacao (
	id int NOT NULL AUTO_INCREMENT primary key,
	ativo varchar(10),
	dt_cotacao DATETIME NOT null,
	abertura double NOT NULL,
	alta double NOT NULL,
	baixa double NOT NULL,
	fechamento double NOT NULL,
	volume double NOT NULL,
	ifr2 double NOT NULL,
	alvo double NULL
	
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;


create unique index idxCotacaoAtivo on cotacao(ativo, dt_cotacao);

CREATE TABLE operacao (
	id int NOT NULL AUTO_INCREMENT primary key,
	tp_operacao varchar(10) not null,
	entrada DATETIME NOT null,
	saida DATETIME null,
	ativo varchar(10) NOT NULL,
	quantidade int NOT NULL,
	valor_entrada double NOT NULL,
	valor_saida double NULL,
	stop_loss double NOT NULL,
	alvo double NOT NULL,
	ifr2 double NOT NULL,
	variacao double NULL
	
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8;