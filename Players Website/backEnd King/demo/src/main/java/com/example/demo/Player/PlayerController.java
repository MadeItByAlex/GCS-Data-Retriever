package com.example.demo.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("api/data")
    public ResponseEntity<List<Player>> getPlayers(
        @RequestParam(value = "name", required = false)String name,
        @RequestParam(value = "status", required = false) String status,
        @RequestParam(value = "sortField", required = false) String sortField,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "200") int size) {

        List<Player> players = playerService.fetchData();
        // Aplicar filtros según los parámetros
        if (name != null && !name.isEmpty()) {
            players = playerService.filterByName(players, name);
        }

        if (status != null && !status.isEmpty()) {
            players = playerService.filterByStatus(players, status);
        }

        // Aplicar ordenación si se proporciona
        if (sortField != null && !sortField.isEmpty()) {
            players = playerService.sortBy(players, sortField);
        }

        // Aplicar paginación
        players = playerService.paginate(players, page, size);

        // Devolver la lista filtrada, ordenada y paginada
        return ResponseEntity.ok(players);


    }
}



