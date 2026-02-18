
# Spring Boot SPRING_APPLICATION_JSON Demo

## What This Shows

This project demonstrates how Spring Boot configuration can be overridden at runtime using the `SPRING_APPLICATION_JSON` environment variable instead of modifying `application.yml`.

The application defines default values in YAML, while Docker Compose injects JSON configuration that overrides those defaults.

---

## Default Configuration

`src/main/resources/application.yml`

```yaml
server:
  port: 8080

app:
  message: from-yaml
````

---

## Application Behavior

The application reads a property:

```java
@Value("${app.message:default}")
private String message;
```

Response:

```
Message = <value>
```

---

## Build

```bash
./gradlew bootJar
```

---

## Docker Compose

```yaml
services:
  app:
    build: .
    ports:
      - "8085:8085"
    environment:
      SPRING_APPLICATION_JSON: >
        {
          "server": { "port": 8085 },
          "app": { "message": "from-json" }
        }
```

---

## Run

```bash
docker compose up --build
```

Open:

```
http://localhost:8085
```

Expected:

```
Message = from-json
```

---

## Key Point

Spring Boot merges configuration sources at startup.
Environment variables (including `SPRING_APPLICATION_JSON`) override values from `application.yml`.


