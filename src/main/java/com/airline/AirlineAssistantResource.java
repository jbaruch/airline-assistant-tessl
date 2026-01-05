package com.airline;

import com.airline.model.ChatRequest;
import com.airline.model.ChatResponse;
import com.airline.service.AirlineAssistantAI;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("/api/assistant")
public class AirlineAssistantResource {

    @Inject
    AirlineAssistantAI airlineAssistant;

    @POST
    @Path("/chat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ChatResponse chat(ChatRequest request) {
        String response = airlineAssistant.chat(request.message());
        return new ChatResponse(response, request.sessionId());
    }
}
