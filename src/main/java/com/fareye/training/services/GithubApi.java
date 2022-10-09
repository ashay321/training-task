package com.fareye.training.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GithubApi {
    @Autowired
    RestTemplate restTemplate;

    public String getUserAvatar(String username) {
        String avatarUrl = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String apiEndPoint = String.format("https://api.github.com/users/%2s", username);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    apiEndPoint, HttpMethod.GET, entity, String.class);

            JsonObject jsonObject = new JsonParser().parse(response.getBody()).getAsJsonObject();
            avatarUrl = jsonObject.get("avatar_url").getAsString();

        } catch (Exception e) {
            System.out.println("No user found");
        }

        return avatarUrl;
    }
}