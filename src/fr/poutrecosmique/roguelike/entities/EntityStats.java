package fr.poutrecosmique.roguelike.entities;

import java.util.HashMap;
import java.util.List;

import fr.poutrecosmique.roguelike.utils.Pair;

public class EntityStats {

	public static final int HEALTH = 0;
	public static final int DEFAULT_HEALTH = 1;
	public static final int MAX_HEALTH = 2;
	
	public static final int ATTACK = 3;
	public static final int DEFAULT_ATTACK = 4;

	public static final int CRITICAL_CHANCE = 5;
	public static final int DEFAULT_CRITICAL_CHANCE = 6;
	
	public static final int CRITICAL_DAMAGE = 7;
	public static final int DEFAULT_CRITICAL_DAMAGE = 8;
	
	public static final int DEFENSE = 9;
	public static final int DEFAULT_DEFENSE = 10;
	
	public static final int SPEED = 11;
	public static final int DEFAULT_SPEED = 12;
	
	public static final int SOLARIS = 13;
	public static final int DEFAULT_SOLARIS = 14;
	public static final int MAX_SOLARIS = 15;
	
	HashMap<Integer, Integer> stats = new HashMap<Integer, Integer>(); // <stat, value>
	
	public EntityStats() {
		init();
	}
	
	public EntityStats(HashMap<Integer, Integer> stats) {
		this.stats = stats;
		
	}
	
	public EntityStats(List<Pair> stats) {
		init();
		for(Pair stat : stats) {
			this.stats.put((Integer) stat.a, (Integer) stat.b);
		}
	}
	
	public void setStat(int stat, int value) {
		stats.put(stat, value);
	}
	
	public int getStat(int stat) {
		return stats.get(stat);
	}
	
	private void init() {
		stats.put(HEALTH, 100);
		stats.put(DEFAULT_HEALTH, 100);
		stats.put(MAX_HEALTH, 100);
		
		stats.put(ATTACK, 1);
		stats.put(DEFAULT_ATTACK, 1);
		
		stats.put(CRITICAL_CHANCE, 25);
		stats.put(DEFAULT_CRITICAL_CHANCE, 25);
		
		stats.put(CRITICAL_DAMAGE, 10);
		stats.put(DEFAULT_CRITICAL_DAMAGE, 10);
		
		stats.put(DEFENSE, 0);
		stats.put(DEFAULT_DEFENSE, 0);
		
		stats.put(SPEED, 100);
		stats.put(DEFAULT_SPEED, 100);
		
		stats.put(SOLARIS, 50);
		stats.put(DEFAULT_SOLARIS, 50);
	}
}
