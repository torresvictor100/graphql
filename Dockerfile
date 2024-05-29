# Use a imagem base do MySQL
FROM mysql:latest

# Defina variáveis de ambiente
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=my_database
ENV MYSQL_USER=my_user
ENV MYSQL_PASSWORD=my_password

# Copie o script de inicialização para o diretório de inicialização do MySQL
COPY init-db.sql /docker-entrypoint-initdb.d/

# Exponha a porta 3306
EXPOSE 3306
