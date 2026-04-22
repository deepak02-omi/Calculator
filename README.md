# Calculator Spring Boot API

This is a small calculator Web API built with Spring Boot and Spring Web.

## Run locally

```powershell
mvn spring-boot:run
```

The API starts on port `8080`.

## API

Health check:

```powershell
curl http://localhost:8080/health
```

Calculate with query parameters:

```powershell
curl "http://localhost:8080/calculate?firstNumber=10&operator=%2B&secondNumber=5"
```

Calculate with JSON:

```powershell
curl -X POST http://localhost:8080/calculate `
  -H "Content-Type: application/json" `
  -d "{\"firstNumber\":10,\"operator\":\"+\",\"secondNumber\":5}"
```

Response:

```json
{"firstNumber":10.0,"operator":"+","secondNumber":5.0,"result":15.0}
```

Supported operators:

- `+` or `add`
- `-` or `subtract`
- `*` or `multiply`
- `/` or `divide`

When using `+` in a URL query string, encode it as `%2B`.

## Build JAR

```powershell
mvn package
java -jar target/calculator-app-1.0-SNAPSHOT.jar
```

## Docker

Build the JAR and image:

```powershell
mvn package
docker build -t calculator-app .
```

Run the API:

```powershell
docker run -p 8080:8080 calculator-app
```

Test it:

```powershell
curl "http://localhost:8080/calculate?firstNumber=10&operator=%2B&secondNumber=5"
```
