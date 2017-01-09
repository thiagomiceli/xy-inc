Zup's Coding Test 
Thiago Miceli - thiagomiceli@gmail.com  

O problema proposto envolve um modelo Entity–attribute–value model (EAV).
Para a solução do problema proposto foi utilizado o MongoDB, um banco NoSql, 
já que bancos relacionais não são a melhor opção para a implementação de modelos EAV.

O Spring Boot foi escolhido para ser utilizado na implementação do backend por oferecer várias facilidades ao desenvolvedor,
acelerando o desenvolvimento da solução.

O Pojo Model armazena os metadados do Modelo criado pelo usuário.
O Pojo Instance armazena os valores definidos nos metadados do Modelo criado pelo usuário

Foram criados dois Jersey Resources um para lidar com as instâncias de Model e outro para as instâncias de Instance.

***Instruções*** 

Para executar os testes automatizados utilize o comando 'mvn test'

Para executar os testes automatizados utilize o comando 'spring-boot:run (Use Postman ou o comando 'curl' para 
enviar requisições aos resources rest)


Exemplos:

Models 
=======
Get all Models
Get
http://localhost:8080/models/

Get one Model (id deve ser alterado para um id válido)
Get
http://localhost:8080/models/5873856466abb908419740d7

Insert one Model
Post
http://localhost:8080/models/
body
 {
    "name": "teste",
    "attributes": 
      {
        "sku": "string",
        "price": "decimal",
        "quantity": "integer"
      }
    
  }
  
Update one Model(id deve ser alterado para um id válido)
Put
http://localhost:8080/models/5873856466abb908419740d7
body
 {
    "name": "teste",
    "attributes": 
      {
        "newSku": "string",
        "newPrice": "decimal",
        "newQuantity": "integer"
      }
    
  }

  
Delete one Model (id deve ser alterado para um id válido)
Delete
http://localhost:8080/models/5873856466abb908419740d7


Instances
==========
Get all instances of a model
Get
http://localhost:8080/modelName/ (http://localhost:8080/product/)

Get one Instance (id deve ser alterado para um id válido)
Get
http://localhost:8080/modelName/instanceId  (http://localhost:8080/product/5873856466abb908419740d7)

Insert one Instance
Post
http://localhost:8080/modelName/ (http://localhost:8080/product/)
body
   {
    "modelName": "Product",
    "attributes": {
      "price": "120000,00",
      "category": "Decoração",
      "name": "Vaso Colorido2",
      "description": "Vaso colorido de ceramica222."
    }
    
  }
  
Update one Model(id deve ser alterado para um id válido)
Put
http://localhost:8080/modelName/instanceId (http://localhost:8080/produto/587254375f870b0bff5d955f)
body
 
  {
    "modelName": "Product",
    "attributes": {
      "price": "120000,00",
      "category": "Decoração",
      "name": "Vaso Colorido2",
      "description": "Vaso colorido de ceramica222."
    }
    
  }
    
  }

  
Delete one Model (id deve ser alterado para um id válido)
Delete
http://localhost:8080/modelName/instanceId (http://localhost:8080/produto/587254375f870b0bff5d955f)






