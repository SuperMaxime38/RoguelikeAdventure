package fr.poutrecosmique.roguelike.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.poutrecosmique.roguelike.RoguelikeAdventure;
import fr.poutrecosmique.roguelike.entities.Mob;
import fr.poutrecosmique.roguelike.entities.player.MobPlayer;
import fr.poutrecosmique.roguelike.items.armor.noob_set.NoobHelmet;
import fr.poutrecosmique.roguelike.items.melee.NoobSword;

public class JoinListener implements Listener{
	
	private static RoguelikeAdventure main;
	
	public JoinListener(RoguelikeAdventure main) {
		JoinListener.main = main;
	}
	

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		MobPlayer player = new MobPlayer(p);
		
		NoobSword sword = new NoobSword();
		NoobHelmet helmet = new NoobHelmet();

		int slot = p.getInventory().firstEmpty();
		if(slot != -1) {
			p.getInventory().setItem(slot, sword.getItem());
			player.setItem(slot, sword);
		}
		slot = p.getInventory().firstEmpty();
		if(slot != -1) {
			p.getInventory().setItem(slot, helmet.getItem());
			player.setItem(slot, helmet);
		}
		
		p.updateInventory();
		main.entityHandler.addPlayer(player);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Mob player = main.entityHandler.getPlayer(p);
		List<Mob> toRemove = new ArrayList<Mob>();
		toRemove.add(player);
		main.entityHandler.players.removeAll(toRemove);
	}

}
