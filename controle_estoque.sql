-- Criação da tabela de usuários (quem opera o sistema)
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Identificador único
    nome VARCHAR(100) NOT NULL,          -- Nome do usuário
    email VARCHAR(100) NOT NULL UNIQUE,  -- Email único para login
    senha VARCHAR(100) NOT NULL           -- Senha para autenticação
);

-- Criação da tabela de categorias dos produtos (ex: grãos, verduras, carnes)
CREATE TABLE categorias (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Identificador único
    nome VARCHAR(100) NOT NULL           -- Nome da categoria
);

-- Criação da tabela de produtos
CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Identificador único
    nome VARCHAR(100) NOT NULL,          -- Nome do produto
    quantidade INT NOT NULL DEFAULT 0,   -- Quantidade atual em estoque
    preco DECIMAL(10,2) NOT NULL,        -- Preço unitário do produto
    categoria_id INT,                    -- Categoria do produto (FK)
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)  -- Relação com categorias
);

-- Tabela para registrar entradas no estoque (ex: compras, reposição)
CREATE TABLE entradas (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Identificador único
    produto_id INT,                      -- Produto que entrou (FK)
    quantidade INT NOT NULL,             -- Quantidade adicionada
    usuario_id INT,                     -- Usuário que registrou (FK)
    data_entrada DATETIME DEFAULT CURRENT_TIMESTAMP, -- Data e hora da entrada
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela para registrar saídas do estoque (ex: vendas, uso)
CREATE TABLE saidas (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Identificador único
    produto_id INT,                      -- Produto que saiu (FK)
    quantidade INT NOT NULL,             -- Quantidade retirada
    usuario_id INT,                     -- Usuário que registrou (FK)
    data_saida DATETIME DEFAULT CURRENT_TIMESTAMP,  -- Data e hora da saída
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Histórico geral das movimentações de estoque (entrada e saída)
CREATE TABLE historico_movimentacoes (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Identificador único
    produto_id INT,                      -- Produto movimentado (FK)
    tipo_movimentacao ENUM('entrada', 'saida') NOT NULL, -- Tipo da movimentação
    quantidade INT NOT NULL,             -- Quantidade movimentada
    usuario_id INT,                     -- Usuário que fez o registro (FK)
    data_movimento DATETIME DEFAULT CURRENT_TIMESTAMP,   -- Data e hora da movimentação
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Inserção de usuários iniciais
INSERT INTO usuarios (nome, email, senha) VALUES 
('Admin', 'admin@email.com', 'admin123'),               -- Administrador
('Fulano Estoquista', 'fulano@email.com', 'fulano123'); -- Usuário Fulano

-- Inserção das categorias de produtos
INSERT INTO categorias (nome) VALUES ('Grãos'), ('Verduras'), ('Carnes');

-- Inserção dos produtos com quantidade, preço e categoria (ordem ajustada)
INSERT INTO produtos (nome, quantidade, preco, categoria_id)
VALUES 
('Arroz', 100, 20.00, 1),   -- Produto arroz na categoria grãos
('Feijão', 80, 25.00, 1),   -- Produto feijão na categoria grãos
('Carne', 50, 45.00, 3),    -- Produto carne na categoria carnes
('Frango', 60, 30.00, 3),   -- Produto frango na categoria carnes
('Salada', 40, 10.00, 2);   -- Produto salada na categoria verduras

-- Registro de entrada de 20 unidades de feijão feita pelo usuário Fulano
INSERT INTO entradas (produto_id, quantidade, usuario_id) VALUES (2, 20, 2);
UPDATE produtos SET quantidade = quantidade + 20 WHERE id = 2;
INSERT INTO historico_movimentacoes (produto_id, tipo_movimentacao, quantidade, usuario_id)
VALUES (2, 'entrada', 20, 2);

-- Registro de saída de 10 unidades de arroz feita pelo usuário Admin
INSERT INTO saidas (produto_id, quantidade, usuario_id) VALUES (1, 10, 1);
UPDATE produtos SET quantidade = quantidade - 10 WHERE id = 1;
INSERT INTO historico_movimentacoes (produto_id, tipo_movimentacao, quantidade, usuario_id)
VALUES (1, 'saida', 10, 1);

-- Consulta para visualizar o estoque atual com detalhes do produto e categoria
SELECT p.id, p.nome, p.quantidade, p.preco, c.nome AS categoria
FROM produtos p
JOIN categorias c ON p.categoria_id = c.id;

-- Consulta para visualizar o histórico de movimentações, ordenado do mais recente para o mais antigo
SELECT h.id, p.nome AS produto, h.tipo_movimentacao, h.quantidade, u.nome AS usuario, h.data_movimento
FROM historico_movimentacoes h
JOIN produtos p ON h.produto_id = p.id
JOIN usuarios u ON h.usuario_id = u.id
ORDER BY h.data_movimento DESC;
