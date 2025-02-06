package fr.poutrecosmique.roguelike;

import org.bukkit.plugin.java.JavaPlugin;

import fr.poutrecosmique.roguelike.listeners.JoinListener;


public class RoguelikeAdventure extends JavaPlugin{

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		System.out.println("[Roguelike Adventure] Enabled");
	}
	@Override
	public void onDisable() {
		System.out.println("[Roguelike Adventure] Disabled");
	}
}
