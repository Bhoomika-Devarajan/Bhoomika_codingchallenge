package com.example.hexaware.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hexaware.dto.PlayerDTO;
import com.example.hexaware.entity.Player;
import com.example.hexaware.exception.ResourceNotFoundException;
import com.example.hexaware.repository.PlayerRepo;

@Service
public class PlayerImpl implements IPlayer {

    @Autowired
    private PlayerRepo repo;

   
    private Player mapToEntity(PlayerDTO dto) {
        Player pl = new Player();
        pl.setPlayerid(dto.getPlayerid());
        pl.setPlayername(dto.getPlayername());
        pl.setJerseyno(dto.getJerseyno());
        pl.setRole(dto.getRole());
        pl.setTotalmatches(dto.getTotalmatches());
        pl.setTeamname(dto.getTeamname());
        pl.setCountry(dto.getCountry());
        pl.setDescription(dto.getDescription());
        return pl;
    }

    
    private PlayerDTO mapToDTO(Player p) {
        PlayerDTO dto = new PlayerDTO();
        dto.setPlayerid(p.getPlayerid());
        dto.setPlayername(p.getPlayername());
        dto.setJerseyno(p.getJerseyno());
        dto.setRole(p.getRole());
        dto.setTotalmatches(p.getTotalmatches());
        dto.setTeamname(p.getTeamname());
        dto.setCountry(p.getCountry());
        dto.setDescription(p.getDescription());
        return dto;
    }

    
    @Override
    public Player createplayer(PlayerDTO dto) {
        Player player = mapToEntity(dto);
        return repo.save(player);
    }

    
    @Override
    public Player updateplayer(Long id, PlayerDTO dto) {
        Player existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found"));

        existing.setPlayername(dto.getPlayername());
        existing.setJerseyno(dto.getJerseyno());
        existing.setRole(dto.getRole());
        existing.setTotalmatches(dto.getTotalmatches());
        existing.setTeamname(dto.getTeamname());
        existing.setCountry(dto.getCountry());
        existing.setDescription(dto.getDescription());

        return repo.save(existing);
    }

    
    @Override
    public PlayerDTO getplayer(Long id) {
        Player player = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found"));

        return mapToDTO(player);
    }

    
    @Override
    public List<PlayerDTO> getallplayer() {
        List<Player> players = repo.findAll();
        List<PlayerDTO> dtoList = new ArrayList<>();

        for (Player p : players) {
            dtoList.add(mapToDTO(p));
        }

        return dtoList;
    }

    
    @Override
    public void deleteplayer(Long id) {
        Player player = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found"));

        repo.delete(player);
    }
}