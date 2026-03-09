package com.example.hexaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.hexaware.dto.PlayerDTO;
import com.example.hexaware.entity.Player;
import com.example.hexaware.service.IPlayer;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    IPlayer service;

    @PostMapping("/add")
    public Player add(@Valid @RequestBody PlayerDTO dto)
    {
        return service.createplayer(dto);
    }

    @GetMapping("/get")
    public List<PlayerDTO> getAllPlayers()
    {
        return service.getallplayer();
    }

    @GetMapping("/get/{id}")
    public PlayerDTO getplayer(@PathVariable Long id)
    {
        return service.getplayer(id);
    }

    @PutMapping("/update/{id}")
    public Player update(@PathVariable Long id, @Valid @RequestBody PlayerDTO dto)
    {
        return service.updateplayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id)
    {
        service.deleteplayer(id);
        return "Player deleted successfully";
    }
}
