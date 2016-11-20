
create datatabase easports;

/* 
 *  CRIAÇÃO DAS TABELAS
 */

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
id_estoque integer not null primary key autoincrement,
id_produto integer not null,
nome_prod varchar(50) not null,
quantidade integer not null,
foreign key(id_produto) references produto(id_produto),
foreign key(nome_prod) references produto(nome));

create table Pedido(
id_pedido integer primary key autoincrement,
id_cliente integer not null,
id_produto integer not null,
quantidade integer not null,
finalizado boolean default false,
foreign key(id_cliente) references cliente_pf(id_cliente),
foreign key(id_produto) references produto(id_produto));

create table Vendas(
id_vendas integer not null primary key autoincrement,
data_venda Date not null,
id_funcionario integer not null,
foreign key(id_funcionario) references funcionario(id_funcionario));

create table Categoria(
id_categoria integer primary key autoincrement,
categoria varchar(20) not null);

create table Cargo(
id_cargo integer primary key autoincrement,
cargo varchar(20) not null);

create table Departamento(
id_departamento integer primary key autoincrement,
departamento varchar(20) not null);

/* 
 *  INSERTS NO BANCO
 */ 

INSERT INTO `Cliente_PF` (id_cliente_pf,nome,telefone,cpf,data_nascimento,id_endereco) VALUES 
 (1,'Diego Fernandes','5428-3562','36278549683','23-07-1988',22),
 (2,'Caio Cruz da Silva','8547-6235','32548579654','18-05-1986',23),
 (3,'Arlindo Moraes Ramos','6215-3458','32154785692','26-08-1992',24),
 (4,'David Amancio das Neves','2654-3526','32451256298','28-06-1983',25),
 (5,'Edward de Carvalho','3524-1526','32541524785','11-02-1974',26),
 (6,'Elder Henrique Albuquerque','2415-8573','32654124578','09-11-1991',27),
 (7,'Jefferson Pereira de Jesus','3425-2514','32654857542','14-05-1988',28),
 (8,'Cesar Ribeiro Romão','3000-2458','32658745215','06-07-1967',29),
 (9,'Henrique Machado Souza','2475-6328','32547859652','12-03-1946',30),
 (10,'Guilherme Santos da Cruz','3214-5689','32541524526','08-02-1984',31),
 (11,'Amanda Pedras Vieira','2145-3625','52415785692','19-02-1992',32),
 (12,'Érica Antunes Aguiar','3215-6895','32654785214','03-09-1971',33),
 (13,'Laís Aparecida Domênico','6589-3529','32654785263','11-06-1973',34),
 (14,'Angélica Parras Beltrami','4785-2658','32541254126','30-07-1990',35),
 (15,'Giovana Janete Silveira','3215-7584','23599658745','04-08-1972',36),
 (16,'Andréa Figueiredo Luz','2154-8576','32655362485','08-10-1990',37),
 (17,'Ruhana Evangelista Silva','3265-7542','32564425185','11-07-1984',38),
 (18,'Fabiana Moreira Fagundes','7852-4158','32586933254','26-03-1989',39),
 (19,'Alana Maia de Figueiredo','3698-5214','52487542112','16-04-1984',40),
 (20,'Bruna Nestlerner Garcia','5425-3628','52684578516','19-08-1981',41);
 
 INSERT INTO `Endereco` (id_endereco,logradouro,numero,cep,bairro,cidade,estado,pais) VALUES 
 (19,'Rua do Araguaia',469,'24875-066','Parque do Álamo','Limeira','São Paulo','Brasil'),
 (20,'Avenida Barão de Limeira',2547,'36572-140','Jardim Caeiras','Cotia','Manaus','Brasil'),
 (21,'Avenida Anhanguera',1576,'04852-160','Santana','São Paulo','São Paulo','Brasil'),
 (22,'Av. Barão de Mauá',5762,'32145-062','Parque Vila Mundo','Teresina','Piauí','Brasil'),
 (23,'Rua Ulisses Aquiar',1034,'52468-057','Jardim Pinhais','João Pessoa','Paraíba','Brasil'),
 (24,'Rua Cândido Portinari',154,'21458-325','Torredo Portinari','Rio de Janeiro','Rio de Janeiro','Brasil'),
 (25,'Av. Anhaia Melo',352,'32451-256','Central','Porto Velho','Rondônia','Brasil'),
 (26,'Rua dos Alonsos',654,'52415-658','Jardim das Flores','Florianópolis','Santa Catarina','Brasil'),
 (27,'Rua Christian Alves',1425,'32254-245','Américo Brasiliense','Boa Vista','Roraima','Brasil'),
 (28,'Alameda dos Urutis',598,'25458-356','Gertrudes','Aracaju','Sergipe','Brasil'),
 (29,'Rua Yara Altures',124,'32547-001','Lônidas Juno','Palmas','Tocantins','Brasil'),
 (30,'Rua Hileia Amazônica',876,'24587-032','Parque Marília','Curitiba','Paraná','Brasil'),
 (31,'Rua Fabres Alunis',5483,'32154-068','Luso Brasileiro','Goiânia','Goiás','Brasil'),
 (32,'Rua Manores do Sol',1475,'24785-310','Maiorides Penteado','São Luís','Maranhão','Brasil'),
 (33,'Rua Olavo de Mesquita',245,'55478-320','Jardim Paulista','Fortaleza','Ceará','Brasil'),
 (34,'Rua Túllio Galvão',371,'03248-624','Parque das Árvores','Salvador','Bahia','Brasil'),
 (35,'Rua Abílio Diniz',946,'62458-014','Vila Alpina','Brasília','Distrito Federal','Brasil'),
 (36,'Av. Teotônio Vilela',21753,'32589-263','Libertos','Manaus','Amazonas','Brasil'),
 (37,'Rua Laércio Sena da Silva',248,'02456-032','Litânia Verde','Rio Branco','Acre','Brasil'),
 (38,'Rua Amélia das Rosas',323,'02459-035','Gualdino Alcântara','Macapá','Amapá','Brasil'),
 (39,'Rua Manuel Figueiroa',873,'02154-568','Dom Casmurro','São Paulo','São Paulo','Brasil'),
 (40,'Rua Jaboticabal',1028,'02459-352','Juquitibá','Vitória','Espírito Santo','Brasil'),
 (41,'Av. Florêncio Torres',836,'02458-089','Floresta Verde','São Paulo','São Paulo','Brasil');
 
 INSERT INTO `Fornecedor` (id_fornecedor,nome,telefone,cnpj,razao_social,id_endereco) VALUES 
 (4,'Adidas','7854-9685','41.356.759/0021-08','Adidas Commerce Ltda',19),
 (5,'Mizuno','2547-3625','54.358.842/0025-12','Mizuno Sports S/A',20),
 (6,'Nike','5421-8547','42.485.236/0027-16','Nike Industries S/A',21);
 
 INSERT INTO `Segmento` (id_segmento,segmento) VALUES 
 (1,'Equipamentos Esportivos'),
 (2,'Trajes Esportivos'),
 (3,'Acessórios Esportivos');
 
 INSERT INTO `Produto` (id_produto,nome,imagem,codigo,valor_venda,valor_custo,id_fornecedor,id_categoria,quantidade) VALUES 
 (9,'Tênis Nike Flex 2016 RN','e1f28e2b-57ff-4798-9efc-c6fe546b795f.jpg','TE001',289.9,210.0,6,4,18),
 (10,'Tênis Adidas Duramo 7','25d11aa5-d694-46e7-a74a-dc78ad0aa536.jpg','TE002',195.0,115.0,4,4,14),
 (11,'Tênis Mizuno Wave Creation 17','1cc6f2c5-fba2-4306-b734-d83579cef190.jpg','TE003',589.9,460.0,5,4,7),
 (12,'Tênis Nike Revolution 3','860043d1-9a3d-4ad5-b761-dc5cdb4b008a.jpg','TE004',240.0,189.0,6,4,13);
 
 INSERT INTO `Departamento` (id_departamento,departamento) VALUES 
 (1,'Gerência'),
 (2,'Vendas'),
 (3,'Tecnologia'),
 (4,'Produtos'),
 (5,'Diretoria');
 
 INSERT INTO `Categoria` (id_categoria,categoria) VALUES 
 (1,'Futebol'),
 (2,'Basquete'),
 (3,'Natação'),
 (4,'Fitness'),
 (5,'Vôlei'),
 (6,'Skate');
 
 INSERT INTO `Cargo` (id_cargo,cargo) VALUES 
 (1,'Vendedor'),
 (2,'Funcionário de TI'),
 (3,'Diretor'),
 (4,'Gerente'),
 (5,'Gerente de Produtos');
 
 /* 
 *  QUERIES ÚTEIS
 */
 
 drop table estoque;
 
 update cliente_pf set nome = "Diego Fernandes" where id_cliente = 1;
 
 update produto set nome = "Tênis Mizuno Wave Creation 17", imagem = "1cc6f2c5-fba2-4306-b734-d83579cef190.jpg", codigo = "TE003", valor_venda = 589.9, 
					valor_custo = 460.0, id_fornecedor = 5, id_categoria = 4, quantidade = 3 where id_produto = 11
 
 select * from produto where nome like '%nike%';