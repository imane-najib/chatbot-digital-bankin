package com.example.chatbotproject.agents;

import com.example.chatbotproject.tools.BankingTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Component;

@Component
public class AIAgent {

    private final ChatClient chatClient;

    public AIAgent(ChatClient.Builder builder,
                   ChatMemory memory,
                   BankingTools bankingTools) {

        this.chatClient = builder
                .defaultSystem("""
                        Vous êtes un assistant bancaire intelligent connecté à un système réel.

                        RÈGLES IMPORTANTES :
                        - Vous devez utiliser les tools fournis pour toute donnée bancaire
                        - Ne jamais inventer de clients, comptes ou opérations
                        - Si une information existe dans les tools, utilisez-les obligatoirement
                        - Répondez de manière claire et professionnelle
                        """)
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(memory).build()
                )
                .defaultTools(bankingTools) // 🔥 IMPORTANT : active les tools
                .build();
    }

    public String ask(String query) {

        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}