package fr.poutrecosmique.roguelike.entities;

import java.util.HashMap;

import org.bukkit.entity.LivingEntity;

import fr.poutrecosmique.roguelike.items.ItemObject;

public class Mob {
	
	public LivingEntity entity;
	
	EntityStats stats;
	
	public HashMap<Integer, ItemObject> items = new HashMap<Integer, ItemObject>(); // associe un item slot à un item
	
	
	public Mob(LivingEntity entity) {
		this.entity = entity;
		
		this.stats = new EntityStats();
	}
	
	public void setDefaultHealth(int health) {
		this.stats.setStat(EntityStats.DEFAULT_HEALTH, health);
		if(this.stats.getStat(EntityStats.DEFAULT_HEALTH) > this.stats.getStat(EntityStats.MAX_HEALTH)) {
			this.stats.setStat(EntityStats.MAX_HEALTH, this.stats.getStat(EntityStats.DEFAULT_HEALTH));
		}
	}
	
	public ItemObject getItem(int slot) {
		System.out.println(items.toString());
		if(items.containsKey(slot)) return items.get(slot);
		return new ItemObject();
	}
	
	public void setItem(int slot, ItemObject item) {
		items.put(slot, item);
	}
	
	public void setStats(EntityStats stats) {
		this.stats = stats;
	}
	
	//Getters
	public EntityStats getStats() {
		return this.stats;
	}
	
	//Custom getters

	public int getEffectiveDamage(ItemObject item) {
		return 0;
	}
	
	// Functions
	
	public void regen() {
		int value = (this.stats.getStat(EntityStats.MAX_HEALTH)/100 + 2);
		this.stats.addHealth(value);
	}
	
	public boolean damage(int value) {
		return this.stats.removeHealth(value);
	}
	
}
