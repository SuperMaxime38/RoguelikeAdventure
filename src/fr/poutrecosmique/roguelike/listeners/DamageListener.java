package fr.poutrecosmique.roguelike.listeners;

import java.util.Random;

import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import fr.poutrecosmique.roguelike.RoguelikeAdventure;
import fr.poutrecosmique.roguelike.entities.EntityStats;
import fr.poutrecosmique.roguelike.entities.Mob;
import fr.poutrecosmique.roguelike.items.ItemObject;
import fr.poutrecosmique.roguelike.utils.Stat;

public class DamageListener implements Listener {
	
	private static RoguelikeAdventure main;
	

	
	ItemObject hand, helmet, chestplate, leggings, boots;
	ItemStack handStack, helmetStack, chestplateStack, leggingsStack, bootsStack;
	
	Random rdm;
	
	public DamageListener(RoguelikeAdventure main) {
		DamageListener.main = main;
		hand = new ItemObject();
		helmet = new ItemObject();
		chestplate = new ItemObject();
		leggings = new ItemObject();
		boots = new ItemObject();
		rdm = new Random();
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		e.setCancelled(true);
		
		// Put some conditions to calculate the damages for differents events
		
		
	}
	
	@EventHandler
	public void entityDamage(EntityDamageByEntityEvent e) {
		e.setCancelled(true);
		
		Entity damager = e.getDamager();
		Entity entity = e.getEntity();
		
		if(!(entity instanceof Player)) return;
		

		Mob damaged;
		if(entity instanceof Player) {
			damaged = main.entityHandler.getPlayer((Player)entity);
		} else {
			damaged = main.entityHandler.getEntity(entity);
		}
		
		if(damaged == null) {
			return;
		}

		
		
		Mob mob;
		if(damager instanceof Player) {
			mob = main.entityHandler.getPlayer((Player)damager);
			int slot = ((Player)damager).getInventory().first((ItemStack) ((HumanEntity) damager).getInventory().getItemInMainHand());
			System.out.println("Hand slot : " + slot);
			if(slot != -1) {
				hand = mob.getItem(slot);
			} else {
				hand = new ItemObject();
			}
		} else {
			mob = main.entityHandler.getEntity(damager);
			hand = mob.getItem(0);
		}
		if(mob == null) {
			return;
		}
		
		
		//init equipment
		getEquipment(mob);
		
		// CALCULATE DAMAGES
		int damage = calculateDamage(mob);
		
		// Once damage is calculated, we calculate what damages the entity takes
		
		//init equipment
		getEquipment(damaged);
		
		int defense = calculateDefense(damaged);
		
		int final_damage = damage / (1 + (defense / 100));
		boolean isDead = mob.damage(final_damage);
		
		//Handle death here
		if(isDead) {
			mob.entity.sendMessage("You died");
			mob.getStats().setStat(EntityStats.HEALTH, mob.getStats().getStat(EntityStats.MAX_HEALTH));
		}
		
		
	}
	
	private void getEquipment(Mob mob) {

		helmetStack = mob.entity.getEquipment().getHelmet();
		chestplateStack = mob.entity.getEquipment().getChestplate();
		leggingsStack = mob.entity.getEquipment().getLeggings();
		bootsStack = mob.entity.getEquipment().getBoots();
		
		if(helmetStack != null) {
			helmet = mob.getItem(39);
		}
		
		if(chestplateStack != null) {
			chestplate = mob.getItem(38);
		}
		
		if(leggingsStack != null) {
			leggings = mob.getItem(37);
		}
		
		if(bootsStack != null) {
			boots = mob.getItem(36);
		}
	}
	
	private int calculateDamage(Mob mob) {

		System.out.println(hand.getName() + " damage: " + hand.getStats().getStat(Stat.DAMAGE));
		int base_damage = hand.getStats().getStat(Stat.DAMAGE);
		
		int attack = mob.getStats().getStat(EntityStats.ATTACK);
		attack += helmet.getStats().getStat(Stat.ATTACK);
		attack += chestplate.getStats().getStat(Stat.ATTACK);
		attack += leggings.getStats().getStat(Stat.ATTACK);
		attack += boots.getStats().getStat(Stat.ATTACK);
		
		int criticalChance = mob.getStats().getStat(EntityStats.CRITICAL_CHANCE);
		criticalChance += helmet.getStats().getStat(Stat.CRITICAL_CHANCE);
		criticalChance += chestplate.getStats().getStat(Stat.CRITICAL_CHANCE);
		criticalChance += leggings.getStats().getStat(Stat.CRITICAL_CHANCE);
		criticalChance += boots.getStats().getStat(Stat.CRITICAL_CHANCE);
		
		int criticalDamage = mob.getStats().getStat(EntityStats.CRITICAL_DAMAGE);
		criticalDamage += helmet.getStats().getStat(Stat.CRITICAL_DAMAGE);
		criticalDamage += chestplate.getStats().getStat(Stat.CRITICAL_DAMAGE);
		criticalDamage += leggings.getStats().getStat(Stat.CRITICAL_DAMAGE);
		criticalDamage += boots.getStats().getStat(Stat.CRITICAL_DAMAGE);
		
		int damage = base_damage + (attack/100);
		
		if(rdm.nextInt(100) < criticalChance) {
			damage *= (1+criticalDamage/100);
		}
		
		return damage;
	}
	
	private int calculateDefense(Mob mob) {
		int base_defense = mob.getStats().getStat(EntityStats.DEFENSE);
		
		int defense = base_defense
				+ helmet.getStats().getStat(Stat.DEFENSE)
				+ chestplate.getStats().getStat(Stat.DEFENSE)
				+ leggings.getStats().getStat(Stat.DEFENSE)
				+ boots.getStats().getStat(Stat.DEFENSE)
				+ hand.getStats().getStat(Stat.DEFENSE);
		
		return defense;
				
	}
}
