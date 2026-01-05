# Airline Assistant Architecture

## Overview
This is an AI-powered airline customer service assistant built with Quarkus and langchain4j.

## Components

### 1. REST API
- **AirlineAssistantResource**: Main REST endpoint at `/api/assistant/chat`
- Accepts chat messages and returns AI-generated responses
- Supports session management through sessionId

### 2. AI Service (langchain4j)
- **AirlineAssistantAI**: Session-scoped AI service interface
- Integrates with OpenAI GPT-4
- Uses AI tools for flight operations

### 3. AI Tools
- **AirlineTools**: Provides functions the AI can call:
  - `searchFlights`: Search for flights between cities
  - `getFlightStatus`: Get real-time flight status
  - `getBaggageInfo`: Retrieve baggage allowance information

### 4. Domain Services
- **FlightService**: Business logic for flight operations
- Currently uses mock data (to be replaced with real database)

### 5. Models
- **Flight**: Flight information record
- **ChatRequest**: Incoming chat message
- **ChatResponse**: AI response with session tracking

## Context Management

### Current Implementation
- Uses langchain4j's `@SessionScoped` annotation for conversation context
- Each session maintains its own conversation history
- Session ID is managed by the client and passed in requests

### Tessl Integration
Tessl is configured via MCP (Model Context Protocol) for:
- Dependency documentation and discovery
- Architecture documentation (this file)
- AI-assisted development workflows

### Future Enhancements
- Persistent conversation storage
- User profile integration
- Advanced context retrieval with RAG (Retrieval-Augmented Generation)
- Integration with Tessl tiles for domain-specific knowledge

## Configuration
See `application.properties` for:
- OpenAI API configuration
- Langchain4j model settings
- CORS settings for web clients
