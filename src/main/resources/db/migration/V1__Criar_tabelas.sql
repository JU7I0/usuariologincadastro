-- Tabela de usuários
CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE,
    email VARCHAR(255) UNIQUE,
    nome VARCHAR(100),
    senha_hash VARCHAR(255),
    ativo BOOLEAN DEFAULT true,
    data_criacao TIMESTAMP,
    role VARCHAR(255)
);
