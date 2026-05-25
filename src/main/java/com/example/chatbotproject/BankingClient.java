package com.example.chatbotproject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BankingClient {

    private final RestTemplate restTemplate = new RestTemplate();

    // URL du backend eBanking
    private final String BANKING_URL = "http://localhost:8085";

    // Liste des clients
    public List getCustomers() {
        return restTemplate.getForObject(
                BANKING_URL + "/customers",
                List.class
        );
    }

    // Chercher clients
    public List searchCustomers(String keyword) {
        return restTemplate.getForObject(
                BANKING_URL + "/customers/search?keyword=" + keyword,
                List.class
        );
    }

    // Client par ID
    public Object getCustomerById(Long id) {
        return restTemplate.getForObject(
                BANKING_URL + "/customers/" + id,
                Object.class
        );
    }

    // Liste des comptes
    public List getAccounts() {
        return restTemplate.getForObject(
                BANKING_URL + "/accounts",
                List.class
        );
    }

    // Compte par ID
    public Object getAccountById(String accountId) {
        return restTemplate.getForObject(
                BANKING_URL + "/accounts/" + accountId,
                Object.class
        );
    }

    // Historique opérations
    public List getAccountOperations(String accountId) {
        return restTemplate.getForObject(
                BANKING_URL + "/accounts/" + accountId + "/operations",
                List.class
        );
    }
}