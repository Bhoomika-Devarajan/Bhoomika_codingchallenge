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
	PlayerRepo repo;

	@Override
	public Player createplayer(PlayerDTO dto) {
		   Player pl=new Player();
		    pl.setPlayerid(dto.getPlayerid());
	        pl.setPlayername(dto.getPlayername());
	        pl.setJerseyno(dto.getJerseyno());
	        pl.setRole(dto.getRole());
	        pl.setTotalmatches(dto.getTotalmatches());
	        pl.setTeamname(dto.getTeamname());
	        pl.setCountry(dto.getCountry());
	        pl.setDescription(dto.getDescription());
	        return repo.save(pl);
		
	}

	@Override
	public Player updateplayer(Long id, PlayerDTO dto) {
		Player pla=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Player not found"));
		 //pla.setPlayerid(dto.getPlayerid());
	        pla.setPlayername(dto.getPlayername());
	        pla.setJerseyno(dto.getJerseyno());
	        pla.setRole(dto.getRole());
	        pla.setTotalmatches(dto.getTotalmatches());
	        pla.setTeamname(dto.getTeamname());
	        pla.setCountry(dto.getCountry());
	        pla.setDescription(dto.getDescription());
	        return repo.save(pla);
		
	}

	@Override
	public PlayerDTO getplayer(Long id) {
		 Player p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found"));

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
	public List<PlayerDTO> getallplayer() {
		
		 List<Player> players = repo.findAll();
		    List<PlayerDTO> dtoList = new ArrayList<>();

		    for (Player p : players) {

		        PlayerDTO dto = new PlayerDTO();

		        dto.setPlayerid(p.getPlayerid());
		        dto.setPlayername(p.getPlayername());
		        dto.setJerseyno(p.getJerseyno());
		        dto.setRole(p.getRole());
		        dto.setTotalmatches(p.getTotalmatches());
		        dto.setTeamname(p.getTeamname());
		        dto.setCountry(p.getCountry());
		        dto.setDescription(p.getDescription());

		        dtoList.add(dto);
		    }

		    return dtoList;
		
		
	}

	@Override
	public void deleteplayer(Long id) {
		 Player p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found"));

	        repo.delete(p);
		
	}

}
