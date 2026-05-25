package com.example.chatbotproject.tools;

import com.example.chatbotproject.BankingClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class BankingTools {

    private final BankingClient bankingClient;

    public BankingTools(BankingClient bankingClient) {
        this.bankingClient = bankingClient;
    }

    @Tool(description = "Retourne la liste des clients")
    public Object getCustomers() {
        return bankingClient.getCustomers();
    }

    @Tool(description = "Chercher un client par mot clé")
    public Object searchCustomers(String keyword) {
        return bankingClient.searchCustomers(keyword);
    }

    @Tool(description = "Retourne un client par ID")
    public Object getCustomerById(Long id) {
        return bankingClient.getCustomerById(id);
    }

    @Tool(description = "Retourne la liste des comptes")
    public Object getAccounts() {
        return bankingClient.getAccounts();
    }

    @Tool(description = "Retourne un compte par ID")
    public Object getAccountById(String accountId) {
        return bankingClient.getAccountById(accountId);
    }

    @Tool(description = "Retourne les opérations d'un compte")
    public Object getAccountOperations(String accountId) {
        return bankingClient.getAccountOperations(accountId);
    }
}