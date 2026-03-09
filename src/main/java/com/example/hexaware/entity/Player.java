package com.example.hexaware.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long playerid;
private String playername;
private String jerseyno;
private String role;
private int totalmatches;
private String teamname;
private String country;
private String description;
public Player()
{
	
}
public Player(Long playerid, String playername, String jerseyno, String role, int totalmatches, String teamname,
		String country, String description) {
	super();
	this.playerid = playerid;
	this.playername = playername;
	this.jerseyno = jerseyno;
	this.role = role;
	this.totalmatches = totalmatches;
	this.teamname = teamname;
	this.country = country;
	this.description = description;
}
public Long getPlayerid() {
	return playerid;
}
public void setPlayerid(Long playerid) {
	this.playerid = playerid;
}
public String getPlayername() {
	return playername;
}
public void setPlayername(String playername) {
	this.playername = playername;
}
public String getJerseyno() {
	return jerseyno;
}
public void setJerseyno(String jerseyno) {
	this.jerseyno = jerseyno;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getTotalmatches() {
	return totalmatches;
}
public void setTotalmatches(int totalmatches) {
	this.totalmatches = totalmatches;
}
public String getTeamname() {
	return teamname;
}
public void setTeamname(String teamname) {
	this.teamname = teamname;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Player [playerid=" + playerid + ", playername=" + playername + ", jerseyno=" + jerseyno + ", role=" + role
			+ ", totalmatches=" + totalmatches + ", teamname=" + teamname + ", country=" + country + ", description="
			+ description + "]";
}



}
