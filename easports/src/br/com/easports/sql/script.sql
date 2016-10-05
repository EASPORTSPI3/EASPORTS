create datatabase easports;

create table Fornecedor(
id_fornecedor integer auto increment, 
nome varchar(100) not null, 
telefone varchar(10), 
cnpj  varchar(18) not null, 
razao_social varchar(50) not null, 
id_endereco integer not null, 
primary key(cnpj), 
foreign key(id_endereco) references Endereco(id_endereco));
		
create table Endereco(
id_endereco integer auto increment, 
logradouro varchar(50) not null, 
numero integer not null, 
cep varchar(9) not null, 
bairro varchar(30), 
cidade varchar(2) not null, 
estado varchar(2) not null, 
pais varchar(20) not null, 
primary key(id_endereco));

create table Unidade(
id_unidade integer auto increment,
nome varchar(50) not null,
id_endereco integer not null,
telefone varchar(10),
primary key(id_unidade),
foreign key(id_endereco) references Endereco(id_endereco));

create table Produto(
id_produto integer auto increment,
nome varchar(50) not null,
modelo varchar(50),
codigo varchar(10) not null,
valor_venda Double not null,
valor_custo Double not null,
id_fornecedor integer not null,
id_categoria integer not null,
primary key(id_produto),
foreign key(id_fornecedor) references Fornecedor(id_fornecedor),
foreign key(id_categoria) references Categoria(id_categoria));

create table Funcionario(
id_funcionario integer auto increment,
nome varchar(100) not null,
telefone varchar(10),
cpf varchar(14) not null,
data_nasc Date not null,
id_endereco integer not null,
ctps varchar(30) not null,
id_cargo integer not null,
id_departamento varchar(20) not null,
primary key(id_funcionario),
foreign key(id_endereco) references Endereco(id_endereco),
foreign key(id_cargo) references Cargo(id_cargo),
foreign key(id_departamento) references Departamento(id_departamento));

create table Cliente_PF(
id_cliente_pf integer auto increment,
nome varchar(100) not null,
telefone varchar(10),
cpf varchar(14) not null,
data_nascimento Date not null,
id_endereco integer not null,
primary key(id_cliente_pf),
foreign key(id_endereco) references Endereco(id_endereco));

create table Cliente_PJ(
id_cliente_pj integer auto increment,
nome varchar(100) not null,
telefone varchar(10),
cnpj varchar(18) not null,
razao_social varchar(50) not null,
id_endereco integer not null,
primary key(id_cliente_pj) foreign key(id_endereco) references Endereco(id_endereco));

create table Categoria(
id_categoria integer auto increment,
categoria varchar(20) not null,
primary key(id_categoria));

create table Cargo(
id_cargo integer auto_increment,
cargo varchar(20) not null,
primary key(id_cargo));

create table Departamento(
id_departamento integer auto increment,
departamento varchar(20) not null,
primary key(id_departamento));
