package fr.poutrecosmique.roguelike.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.poutrecosmique.roguelike.items.melee.NoobSword;

public class JoinListener implements Listener{
	
	@EventHandler
	public static void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		NoobSword sword = new NoobSword();
		
		p.getInventory().addItem(sword.getItem());
		System.out.println(p.getName() + " logged in and got his item: " + sword.getItem().getType());
	}

}
