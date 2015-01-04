package de.nebur97.git.gw2api.rarity;

import java.awt.Color;

/**
 * An enum of possible rarities.<br>
 * Contains:<br>
 * <li>{@link #JUNK}<br> <li>{@link #BASIC}<br> <li>{@link #FINE}<br> <li>
 * {@link #MASTERWORK}<br> <li>{@link #RARE}<br> <li>{@link #EXOTIC}<br> <li>
 * {@link #ASCENDED}<br> <li>{@link #LEGENDARY}
 * 
 * @author NeBuR97
 **/
public enum Rarity
{
    /** The Junk rarity. Color:188,170,170 **/
    JUNK(new Color(188, 170, 170)),

    /** The Basic rarity. Color:0,0,0 **/
    BASIC(new Color(0, 0, 0)),

    /** The Fine rarity. Color:122,164,218 **/
    FINE(new Color(122, 164, 218)),

    /** The Masterwork rarity. Color:26,147,6 **/
    MASTERWORK(new Color(26, 147, 6)),

    /** The Rare rarity. Color:252,208,11 **/
    RARE(new Color(252, 208, 11)),

    /** The Exotic rarity. Color:255,164,5 **/
    EXOTIC(new Color(255, 164, 5)),

    /** The Ascended rarity. Color:251,62,141 **/
    ASCENDED(new Color(251, 62, 141)),

    /** The Legendary rarity. Color:76,19,157 **/
    LEGENDARY(new Color(76, 19, 157));
    private final Color col;

    /** Enum contructor. **/
    Rarity(Color col)
    {
	this.col = col;
    }

    /**
     * Returns the associated color.
     * 
     * @return Color
     **/
    public Color color()
    {
	return col;
    }
}
