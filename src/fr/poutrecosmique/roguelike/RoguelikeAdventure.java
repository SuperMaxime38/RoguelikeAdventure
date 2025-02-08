package fr.poutrecosmique.roguelike;

import org.bukkit.plugin.java.JavaPlugin;

import fr.poutrecosmique.roguelike.entities.EntityHandler;
import fr.poutrecosmique.roguelike.listeners.DamageListener;
import fr.poutrecosmique.roguelike.listeners.FoodListener;
import fr.poutrecosmique.roguelike.listeners.JoinListener;


public class RoguelikeAdventure extends JavaPlugin{
	
	public EntityHandler entityHandler = new EntityHandler();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		getServer().getPluginManager().registerEvents(new DamageListener(this), this);
		getServer().getPluginManager().registerEvents(new FoodListener(), this);
		System.out.println("[Roguelike Adventure] Enabled");
	}
	@Override
	public void onDisable() {
		System.out.println("[Roguelike Adventure] Disabled");
	}
}
