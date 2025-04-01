# Spring AI Demo Application

This is a Spring Boot application that demonstrates integration with AI capabilities using Spring AI and Ollama.

## Prerequisites

- Java 21
- Maven 3.9+
- Ollama installed locally with the `deepseek-r1` model

## Features

- Simple chat completion endpoint
- Streaming chat completion endpoint
- Image analysis with chat completion

## API Endpoints

### Chat Completion
```http
GET /chat?message=your_message_here
```
Returns a single response from the AI model.

### Streaming Chat
```http
GET /stream-chat?message=your_message_here
```
Returns a stream of tokens from the AI model response.

### Image Analysis
```http
POST /chat-with-image
```
Multipart form data:
- `message`: Text prompt about the image
- `image`: Image file to analyze (PNG format)

## Configuration

The application uses the following configuration in `application.properties`:

```properties
spring.application.name=spring-ai
spring.ai.ollama.chat.model=deepseek-r1:latest
```

## Building the Application

```bash
./mvnw clean install
```

## Running the Application

```bash
./mvnw spring-boot:run
```

## Technologies Used

- Spring Boot 3.4.4
- Spring AI 1.0.0-M6
- Spring Webflux (for streaming responses)
- Ollama AI Model

## License

This project is open source and available under the [Apache License 2.0](LICENSE).