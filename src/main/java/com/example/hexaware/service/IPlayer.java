package com.example.hexaware.service;

import com.example.hexaware.dto.PlayerDTO;
import com.example.hexaware.entity.Player;
import java.util.*;
public interface IPlayer {
	
	Player createplayer(PlayerDTO dto);
	Player updateplayer(Long id,PlayerDTO dto);
	PlayerDTO getplayer(Long id);
	List<PlayerDTO> getallplayer();
	void deleteplayer(Long id);

}
