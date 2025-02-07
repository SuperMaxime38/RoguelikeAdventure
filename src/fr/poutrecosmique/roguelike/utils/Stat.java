package fr.poutrecosmique.roguelike.utils;

import java.util.HashMap;
import java.util.List;

public class Stat {
	
	public static final int DAMAGE = 0;
	public static final int ATTACK = 1;
	public static final int CRITICAL_CHANCE = 2;
	public static final int CRITICAL_DAMAGE = 3;
	public static final int HEALTH = 4;
	public static final int DEFENSE = 5;
	public static final int SPEED = 6;
	public static final int SOLARIS = 7;
	
	HashMap<Integer, Integer> stats = new HashMap<Integer, Integer>(); // <stat, value>
	
	public Stat() {
		init();
	}
	
	public Stat(HashMap<Integer, Integer> stats) {
		this.stats = stats;
		
	}
	
	public Stat(List<Pair> stats) {
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
		stats.put(DAMAGE, 0);
		stats.put(ATTACK, 0);
		stats.put(CRITICAL_CHANCE, 0);
		stats.put(CRITICAL_DAMAGE, 0);
		stats.put(HEALTH, 0);
		stats.put(DEFENSE, 0);
		stats.put(SPEED, 0);
		stats.put(SOLARIS, 0);
	}
}
