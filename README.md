# xy-inc | Pontos de Interesse por GPS

  Solução do desafio de pontos de interesse(POI) por GPS

  Programas e Linguagens Utilizados
  
    JAVA - IntelliJ
    SpringBoot
    MySQL
    API em RESTful JSON

    Problema

    A CoordinatesCompany é uma empresa especializada na produção de excelentes
receptores GPS (Global Positioning System). A diretoria está empenhada em lançar um
dispositivo inovador que promete auxiliar pessoas na localização de ponto de interesse
(POIs), e precisa muito de sua ajuda.
Você foi contratado para desenvolver a plataforma que fornecerá toda a inteligência ao
dispositivo

  Foi solicitado que o sistema tenha.

· Serviço para cadastrar pontos de interesse, com 3 atributos:
· Nome do POI
· Coordenada X (inteiro não negativo)
· Coordenada Y (inteiro não negativo)

· Serviço para listar todos os POIs cadastrados.

· Serviço para listar POIs por proximidade. Este serviço receberá uma coordenada X e uma
coordenada Y, especificando um ponto de referência, bem como uma distância máxima
(d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam
a uma distância menor ou igual a d-max a partir do ponto de referência.

As APIs deverão seguir o modelo RESTFul com formato JSON.

Usar a linguagem Java

Exemplo de Uso

Dado o ponto de referência (x=20, y=10) indicado pelo receptor GPS, e uma distância máxima de 10 metros, o serviço deve retornar os seguintes POIs:

Lanchonete
Joalheria
Pub
Supermercado

Endpoints

Cadastro

Para cadastrar um ponto de interesse [POST]| localhost:8080/points No body da requisição.

Campo  	  Tipo	           Descrição	    Obrigatório
name	  String	          Nome do POI	        Sim
x	int	  Coordenada   x do POI(não negativo)	  Sim
y	int	  Coordenada   y do POI(não negativo)	  Sim

Exemplo:

Requisição
[POST] localhost:8080/
 {
    "name": "Escola",
    "x": 2,
    "y": 4
}
Resposta
201 Created

Listar todos os POI e Proximidade

Foi criado processo onde caso o usuário passe informações de coordenadas será exibido os locais proximos
Caso não seja passado nenhum dado o mesmo vai exibir todos os pontos de interesse.

Requisição
[GET] localhost:8080/

Resposta
200 OK

 {
    "name": "Escola",
    "x": 2,
    "y": 4
}

Para executar o program será nescessario

Ter um Banco de daos com o nome pois_db e criar uma tabela com as informações solicitadas(coordenadaX, coordenadaY, nome) foi acrecenta o id nesse projeto para que fosse possivel efetuar a exclusão do dado solicitado
O Banco de dados tem que estar na porta 8080 para conseguir executar o mesmo.

    
