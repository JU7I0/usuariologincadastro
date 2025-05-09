-- Tabela de usuários
CREATE TABLE usuario (
    id BIGINT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE,
    email VARCHAR(255) UNIQUE,
    nome VARCHAR(100),
    senha_hash VARCHAR(255),
    ativo BOOLEAN DEFAULT true,
    data_criacao TIMESTAMP
);

-- Tabela de carteiras
CREATE TABLE carteira (
    id BIGINT PRIMARY KEY,
    usuario_id BIGINT REFERENCES usuario(id),
    saldo DECIMAL(19,4) CHECK (saldo >= 0),
    limite_diario DECIMAL(19,4)
);

-- Tabela de transações (Event Sourcing)
CREATE TABLE transacao (
    id BIGINT PRIMARY KEY,
    tipo VARCHAR(50),
    valor DECIMAL(19,4),
    origem_id BIGINT,
    destino_id BIGINT,
    status VARCHAR(20),
    data_criacao TIMESTAMP
);

-- Índices importantes
CREATE INDEX idx_transacao_origem ON transacao(origem_id);
CREATE INDEX idx_transacao_destino ON transacao(destino_id);
CREATE INDEX idx_transacao_data ON transacao(data_criacao);