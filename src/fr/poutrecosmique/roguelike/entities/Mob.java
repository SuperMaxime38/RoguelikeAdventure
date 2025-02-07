package fr.poutrecosmique.roguelike.entities;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;

public class Mob {
	
	public LivingEntity entity;
	
	public int default_health;
	public int max_health;
	public int health;
	
	
	
	public Mob(LivingEntity entity) {
		this.entity = entity;
		this.default_health = (int) entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
		this.max_health = this.default_health;
		this.health = this.default_health;
	}
	
	public void setDefaultHealth(int health) {
		this.default_health = health;
		if(this.default_health > this.max_health) {
			this.max_health = this.default_health;
		}
	}
	
	public void setMaxHealth(int health) {
		this.max_health = health;
	}
}
