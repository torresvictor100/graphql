-- Criação de um banco de dados e de um usuário MySQL com permissões específicas

-- Crie o banco de dados (se ainda não existir)
CREATE DATABASE IF NOT EXISTS my_database;

-- Crie o usuário e conceda permissões
CREATE USER IF NOT EXISTS 'my_user'@'%' IDENTIFIED BY 'my_password';
GRANT ALL PRIVILEGES ON my_database.* TO 'my_user'@'%';
FLUSH PRIVILEGES;
