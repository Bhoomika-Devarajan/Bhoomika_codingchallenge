package com.example.hexaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexaware.dto.PlayerDTO;
import com.example.hexaware.entity.Player;
import com.example.hexaware.service.IPlayer;
import com.example.hexaware.service.PlayerImpl;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
	@Autowired
	IPlayer service;
	@PostMapping("/add")
	public Player add(@RequestBody PlayerDTO dto)
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
	 public Player update(@PathVariable Long id,@RequestBody PlayerDTO dto)
	 {
		 return service.updateplayer(id, dto);
	 }
	 @DeleteMapping("/{id}")
	    public String deletePlayer(@PathVariable Long id) {

	        service.deleteplayer(id);

	        return "Player deleted successfully";
	    }
	

}
