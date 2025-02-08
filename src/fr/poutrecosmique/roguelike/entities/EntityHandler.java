package fr.poutrecosmique.roguelike.entities;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class EntityHandler {

	public List<Mob> players;
	public List<Mob> entities;
	
	public EntityHandler() {
		players = new ArrayList<Mob>();
		entities = new ArrayList<Mob>();
	}
	
	public void addPlayer(Mob player) {
		players.add(player);
	}
	
	public void removePlayer(Mob player) {
		players.remove(player);
	}
	
	public void removePlayer(Player p) {
		for(Mob player : players) {
			if(player.entity.equals(p)) {
				players.remove(player);
			}
		}
	}
	
	public void addEntity(Mob entity) {
		entities.add(entity);
	}
	
	public void removeEntity(Mob entity) {
		entities.remove(entity);
	}
	
	public void removeEntity(Entity e) {
		for(Mob entity : entities) {
			if(entity.entity.equals(e)) {
				players.remove(entity);
			}
		}
	}
	
	public Mob getPlayer(Player p) {
		for(Mob player : players) {
			if(player.entity.equals(p)) {
				return player;
			}
		}
		return null;
	}
	
	public Mob getEntity(Entity e) {
		for(Mob entity : entities) {
			if(entity.entity.equals(e)) {
				return entity;
			}
		}
		return null;
	}
}
