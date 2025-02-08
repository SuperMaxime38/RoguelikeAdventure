package fr.poutrecosmique.roguelike.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.poutrecosmique.roguelike.RoguelikeAdventure;
import fr.poutrecosmique.roguelike.entities.Mob;
import fr.poutrecosmique.roguelike.items.ItemObject;

public class DamageListener implements Listener {
	
	private static RoguelikeAdventure main;
	public DamageListener(RoguelikeAdventure main) {
		DamageListener.main = main;
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		e.setCancelled(true);
		Entity entity = e.getEntity();
		
		Mob mob;
		if(e.getEntity() instanceof Player) {
			mob = main.entityHandler.getPlayer((Player)entity);
		} else {
			mob = main.entityHandler.getEntity(entity);
		}
		if(mob == null) {
			return;
		}
		
		ItemObject hand, helmet, chetsplate, leggings, boots;
	}
}
