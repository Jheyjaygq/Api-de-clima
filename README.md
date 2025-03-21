# API de Clima - Spring Boot

## Sobre o Projeto
Esta API, desenvolvida em **Spring Boot**, permite buscar dados meteorológicos em tempo real utilizando a **OpenWeatherAPI**. 

A API recebe o nome de uma cidade e retorna informações detalhadas sobre o clima, como temperatura, umidade, vento e condições climáticas. O projeto segue a arquitetura **MVC** e utiliza o **RestTemplate** para realizar requisições à API externa.

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Web**
- **Maven**

## Endpoints

### Obter Clima Atual por Cidade
**GET** `/clima/{cidade}`

#### Exemplo de Requisição
```http
GET http://localhost:8080/clima/Riodejaneiro
```

### Configuração da API Key
Para utilizar a API da OpenWeather, você precisará de uma chave de API. Crie uma conta em [OpenWeather](https://openweathermap.org/) e obtenha sua chave.

Adicione sua chave no `application.properties`:
```properties
spring.application.name=api-clima
server.port=8080
openweathermap.api.key=sua chave da api
```

