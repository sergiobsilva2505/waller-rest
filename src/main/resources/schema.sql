
CREATE TABLE  IF NOT EXISTS usuarios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    login VARCHAR(30),
    senha VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS transacoes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    preco DECIMAL(10,2),
    quantidade INTEGER,
    ticker VARCHAR(255),
    tipo_transacao VARCHAR(255),
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
