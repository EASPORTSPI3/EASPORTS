create datatabase easports;

create table Fornecedor(
id_fornecedor integer primary key autoincrement, 
nome varchar(100) not null, 
telefone varchar(10), 
cnpj  varchar(18) not null, 
razao_social varchar(50) not null, 
id_endereco integer not null,  
foreign key(id_endereco) references Endereco(id_endereco));
		
create table Endereco(
id_endereco integer primary key autoincrement, 
logradouro varchar(50) not null, 
numero integer not null, 
cep varchar(9) not null, 
bairro varchar(30), 
cidade varchar(2) not null, 
estado varchar(2) not null, 
pais varchar(20) not null);

create table Unidade(
id_unidade integer primary key autoincrement,
nome varchar(50) not null,
id_endereco integer not null,
telefone varchar(10),
foreign key(id_endereco) references Endereco(id_endereco));

create table Produto(
id_produto integer primary key autoincrement,
nome varchar(50) not null,
imagem varchar(50),
codigo varchar(5) not null,
valor_venda Double not null,
valor_custo Double not null,
id_fornecedor integer not null,
id_categoria integer not null,
quantidade integer not null,
foreign key(id_fornecedor) references Fornecedor(id_fornecedor),
foreign key(id_categoria) references Categoria(id_categoria));

create table Funcionario(
id_funcionario integer primary key autoincrement,
nome varchar(100) not null,
telefone varchar(10),
cpf varchar(14) not null,
data_nasc Date not null,
id_endereco integer not null,
ctps varchar(30) not null,
id_cargo integer not null,
id_departamento varchar(20) not null,
foreign key(id_endereco) references Endereco(id_endereco),
foreign key(id_cargo) references Cargo(id_cargo),
foreign key(id_departamento) references Departamento(id_departamento));

create table Cliente_PF(
id_cliente_pf integer  primary key autoincrement,
nome varchar(100) not null,
telefone varchar(10),
cpf varchar(14) not null,
data_nascimento Date not null,
id_endereco integer not null,
foreign key(id_endereco) references Endereco(id_endereco));

create table Cliente_PJ(
id_cliente_pj integer  primary key autoincrement,
nome varchar(100) not null,
telefone varchar(10),
cnpj varchar(18) not null,
razao_social varchar(50) not null,
id_endereco integer not null,
foreign key(id_endereco) references Endereco(id_endereco));

create table Estoque(
id_estoque integer primary key autoincrement, 
id_prod integer not null, 
nome_prod varchar(50) not null, 
id_categoria integer not null, 
quantidade integer not null, 
foreign key(id_prod) references Produto(id_produto)
foreign key(id_categoria) references Categoria(id_categoria));

create table Categoria(
id_categoria integer primary key autoincrement,
categoria varchar(20) not null);

create table Cargo(
id_cargo integer primary key autoincrement,
cargo varchar(20) not null);

create table Departamento(
id_departamento integer primary key autoincrement,
departamento varchar(20) not null);

