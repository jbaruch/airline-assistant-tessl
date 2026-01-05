package com.airline.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService(tools = AirlineTools.class)
@SessionScoped
public interface AirlineAssistantAI {

    @SystemMessage("""
        You are a helpful airline customer service assistant. You can help customers with:
        - Flight search and booking
        - Flight status inquiries
        - Baggage information
        - Check-in assistance
        - General travel questions

        Always be polite, professional, and helpful. If you don't know something,
        admit it and offer to connect the customer with a human agent.

        When providing flight information, always format it clearly with flight numbers,
        times, and prices. Use the tools available to you to search for flights and
        check flight status.
        """)
    String chat(@UserMessage String userMessage);
}
