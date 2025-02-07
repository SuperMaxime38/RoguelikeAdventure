package fr.poutrecosmique.roguelike.items;

import fr.poutrecosmique.roguelike.utils.Stat;

public class ItemEffect {

	public final int IDLE = 0;
	public final int ON_USE = 1;
	public final int EQUIP = 2;
	public final int ON_DAMAGE = 3;
	
	public ItemEffectIdentifier effect;
	public int effectType;
	public Stat stats;

	public ItemEffect(ItemEffectIdentifier effect, int effectType, Stat stats) {
		this.effect = effect;
		this.effectType = effectType;
		this.stats = stats;
	}
	
	public ItemEffect(ItemEffectIdentifier effect, int effectType) {
		this.effect = effect;
	}
}
