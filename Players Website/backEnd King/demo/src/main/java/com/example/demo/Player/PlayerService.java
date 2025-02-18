package com.example.demo.Player;

import com.google.api.Page;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final RestTemplate restTemplate;

    public PlayerService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Player> fetchData(){
        String url = "https://storage.googleapis.com/king-airnd-recruitment-sandbox-data/data.json";
        ResponseEntity<PlayerResponse> response = restTemplate.getForEntity(url,PlayerResponse.class);
        return response.getBody() != null ? response.getBody().getOutput() : List.of();
    }


    public List<Player> filterByName(List<Player> players, String name){
        return players.stream()
                .filter(player -> player.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> filterByStatus (List<Player> players ,String status){
        return players.stream()
                .filter(player -> player.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public List<Player> sortBy(List<Player> players, String sortField) {
        switch (sortField) {
            case "name":
                players.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
                break;
            case "createdOn":
                players.sort((p1, p2) -> p1.getCreatedOn().compareTo(p2.getCreatedOn()));
                break;
            default:
                players.sort((p1, p2) -> p1.getId().compareTo(p2.getId()));
        }
        return players;
    }

    public List<Player> paginate(List<Player> players, int page, int size) {
        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, players.size());
        if (fromIndex > players.size()) {
            return List.of(); // Si el índice está fuera de los límites, devuelve una lista vacía
        }
        return players.subList(fromIndex, toIndex);
    }
}


