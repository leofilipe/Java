PT-BR///////////////////
API bara busca automática de endereço no Brasil em formato JSON a partir de um CEP e consutla ao webservice em https://viacep.com.br

SRC:
- com.github.java.cep_api.model.Address: POJO com estrutura equivalente ao JSON retornado pelo webservice adotado.
- com.github.java.cep_api.control.AddressControllerGeneric: controlador abstrato para consulta ao webservice e retrono dos dados em formato String (JSON) e Address (POJO)
- com.github.java.cep_api.control.gson.AddressController: implementação de AddressControllerGeneric com a biblioteca GSON para uso de JSON em Java
- com.github.java.cep_api.control.jackson.AddressController: implementação de AddressControllerGeneric com a biblioteca Jackson para uso de JSON em Java

TESTES:
- com.github.java.cep_api.control.gson.AddressControllerTest: teste unitario para a classe com.github.java.cep_api.control.gson.AddressController
- com.github.java.cep_api.control.jackson.AddressControllerTest: teste unitario para a classe com.github.java.cep_api.control.jackson.AddressController
- com.github.java.cep_api.control.AllControllersTests: suite de testes unitario para as classes de controle da API

BIBLIOTECAS E PLUGINS:
- JUnit 5; GSon 2.8.9; Jackson 2.14.2; Maven 3.2.

ENG-US//////////////////
API for automatic address search in Brazil in JSON format from a ZIP code and querying the web service at https://viacep.com.br

SRC:
- com.github.java.cep_api.model.Address: POJO of equivalent structure to the JSON returned by the adopted web service.
- com.github.java.cep_api.control.AddressControllerGeneric: abstract controller for querying the web service and returning data in String (JSON) and Address (POJO) formats.
- com.github.java.cep_api.control.gson.AddressController: implementation of AddressControllerGeneric with the GSON library for using JSON in Java.
- com.github.java.cep_api.control.jackson.AddressController: implementation of AddressControllerGeneric with the Jackson library for using JSON in Java.

TESTS:
- com.github.java.cep_api.control.gson.AddressControllerTest: unit test for the class com.github.java.cep_api.control.gson.AddressController.
- com.github.java.cep_api.control.jackson.AddressControllerTest: unit test for the class com.github.java.cep_api.control.jackson.AddressController.
- com.github.java.cep_api.control.AllControllersTests: unit test suite for the API control classes.

LIBRARIES AND PLUGINS:
- JUnit 5; GSon 2.8.9; Jackson 2.14.2; Maven 3.2.
