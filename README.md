# Smart Email Assistant

A **Java Spring Boot application** that uses **OpenAI's API** to intelligently generate professional email replies. This tool analyzes incoming emails and creates contextually appropriate responses based on specified tone and content.

![Smart Email Assistant](https://github.com/user-attachments/assets/bf7d7b4e-22c6-42f5-a0bd-accaa0d45588)

## Features

✨ **Smart Email Generation** - Uses OpenAI to generate professional email replies  
🎯 **Tone Customization** - Specify the tone (formal, casual, friendly, etc.) for the reply  
⚡ **RESTful API** - Easy-to-use REST endpoint for email generation  
🚀 **Spring Boot** - Modern, production-ready Java framework  
🔧 **Maven Wrapper** - Build without installing Maven globally  

## Technology Stack

- **Java 21**
- **Spring Boot 3.5.9**
- **Spring AI 1.1.2** (OpenAI integration)
- **Lombok** (Boilerplate reduction)
- **Maven**

## Requirements

- **Java 21+** (or Java 17+ with older Spring Boot versions)
- **Git**
- **OpenAI API Key** (sign up at [openai.com](https://platform.openai.com))
- **(Optional) Docker** for containerization

## Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/Shivam-GitLab/Smart-Email-Assistant.git
cd Smart-Email-Assistant
```

### 2. Build the Project

```bash
# Linux / macOS
./mvnw clean package

# Windows
.\mvnw.cmd clean package
```

### 3. Configure OpenAI API Key

Create an `application.properties` file in `src/main/resources/`:

```properties
spring.ai.openai.api-key=YOUR_OPENAI_API_KEY
```

Or set as an environment variable:

```bash
export SPRING_AI_OPENAI_API_KEY=YOUR_OPENAI_API_KEY
```

### 4. Run the Application

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or run the packaged JAR
java -jar target/Smart-Email-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

### 5. Run Tests

```bash
./mvnw test
```

### 6. Run with Specific Profile

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## API Documentation

### Generate Email Reply

**Endpoint:** `POST /api/email/generate`

**Request Body:**
```json
{
  "emailContent": "Dear team, I wanted to check the status of the project...",
  "emailTone": "professional"
}
```

**Parameters:**
- `emailContent` (required): The original email content to reply to
- `emailTone` (optional): The tone for the reply (e.g., formal, casual, friendly, professional)

**Response:**
```json
"Dear [Sender], Thank you for your inquiry. I'm pleased to update you on the project status..."
```

**Example cURL:**
```bash
curl -X POST http://localhost:8080/api/email/generate \
  -H "Content-Type: application/json" \
  -d '{
    "emailContent": "Hi, can you provide an update on the project?",
    "emailTone": "professional"
  }'
```

## Project Structure

```
smart-email-assistant/
├── src/main/java/com/sm/smartEmail/
│   ├── SmartEmailApplication.java      # Main Spring Boot application class
│   ├── config/
│   │   └── ChatClientConfig.java       # Spring AI ChatClient configuration
│   ├── controller/
│   │   └── EmailGeneratorController.java # REST API endpoints
│   ├── entities/
│   │   └── EmailRequest.java           # Request DTO
│   └── service/
│       └── EmailGeneratorService.java  # Business logic for email generation
├── pom.xml                             # Maven configuration
├── mvnw / mvnw.cmd                     # Maven wrapper scripts
└── README.md                           # This file
```

## Configuration

### Environment Variables

| Variable | Description | Required |
|----------|-------------|----------|
| `SPRING_AI_OPENAI_API_KEY` | Your OpenAI API key | Yes |
| `SPRING_AI_OPENAI_MODEL` | OpenAI model (default: gpt-3.5-turbo) | No |
| `SERVER_PORT` | Server port (default: 8080) | No |

### Application Properties

Add to `src/main/resources/application.properties`:

```properties
spring.ai.openai.api-key=YOUR_KEY
spring.ai.openai.chat.model=gpt-4
server.port=8080
```

## How It Works

1. **User sends request** with email content and desired tone
2. **Service builds a prompt** including context and tone
3. **OpenAI API processes** the prompt and generates a reply
4. **Response is returned** to the user as plain text

## Example Usage

```java
// Request
{
  "emailContent": "Thanks for the meeting yesterday. Could you send me the slides?",
  "emailTone": "casual"
}

// Generated Response
"Hey! Of course, I'll send over those slides right away. Let me know if you need anything else!"
```

## Development

### Building the Project

```bash
./mvnw clean install
```

### Running Tests

```bash
./mvnw test
```

### Creating a Docker Image

```bash
./mvnw spring-boot:build-image
```

## Troubleshooting

### OpenAI API Key Not Found
- Ensure your API key is set in `application.properties` or as an environment variable
- Check that the key is valid on [OpenAI's platform](https://platform.openai.com/account/api-keys)

### Connection Refused
- Verify the application is running on port 8080
- Check firewall settings if accessing remotely

### Maven Build Fails
- Run `./mvnw clean` to clear cache
- Ensure Java 21 is installed: `java -version`

## Contributing

Contributions are welcome! Please feel free to:
- Report bugs via GitHub Issues
- Submit pull requests with improvements
- Suggest new features

## License

This project is open source and available under the MIT License.

## Author

**Shivam-GitLab** - [GitHub Profile](https://github.com/Shivam-GitLab)

## Support

For issues, questions, or suggestions:
- Open a [GitHub Issue](https://github.com/Shivam-GitLab/Smart-Email-Assistant/issues)
- Check existing documentation above

---

**Last Updated:** April 2026
