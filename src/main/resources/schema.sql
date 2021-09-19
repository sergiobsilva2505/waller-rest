
CREATE TABLE IF NOT EXISTS transacoes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    preco DECIMAL(10,2),
    quantidade INTEGER,
    ticker VARCHAR(255),
    tipo_transacao VARCHAR(255)
);