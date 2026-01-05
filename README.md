# Airline Assistant

An AI-powered airline customer service assistant built with Quarkus, langchain4j, and Tessl.

## Features

- AI-powered chat interface using OpenAI GPT-4
- Flight search and booking assistance
- Real-time flight status information
- Baggage information queries
- Session-based conversation context
- RESTful API endpoints

## Tech Stack

- **Quarkus** - Supersonic Subatomic Java Framework
- **langchain4j** - AI/LLM integration framework
- **OpenAI GPT-4** - Language model for natural conversations
- **Tessl** - Context management and AI-assisted development
- **Jakarta REST** - RESTful web services

## Prerequisites

- JDK 21 or later
- Maven 3.9+
- OpenAI API key

## Configuration

Set your OpenAI API key as an environment variable:

```bash
export OPENAI_API_KEY=your-api-key-here
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

The application will start at <http://localhost:8080>

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Using the Application

### Web Interface

Open your browser and navigate to <http://localhost:8080> to access the minimalistic chat interface. You can:

- Ask about flights (e.g., "Find flights from JFK to LAX on 2025-01-15")
- Check flight status (e.g., "What's the status of flight AA100?")
- Get baggage information (e.g., "What's the baggage allowance for business class?")

### API Usage

### Chat with the Assistant

```bash
curl -X POST http://localhost:8080/api/assistant/chat \
  -H "Content-Type: application/json" \
  -d '{
    "message": "I need a flight from JFK to LAX tomorrow",
    "sessionId": "user-123"
  }'
```

### Example Queries

- "Search for flights from New York to Los Angeles on 2025-01-15"
- "What's the status of flight AA100?"
- "What's the baggage allowance for economy class?"

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/assistant-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- LangChain4j OpenAI ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): Provides the basic integration with LangChain4j

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
