package de.nebur97.git.gw2api.item.gametypes;

/**
 * The possible gametypes. <li>{@link #ACTIVITY} <li>{@link #DUNGEON} <li>
 * {@link #PVE} <li>{@link #PVP} <li>{@link #PVPLOBBY} <li>{@link #WVW}
 * 
 * @author NeBuR97
 * 
 */
public enum GameType
{
    /**
     * Usable in activities.<br>
     * <i>An activity is a mini-game designed to fit in with the local area.</i><br>
     * For more info, see the <a
     * href="http://wiki.guildwars2.com/wiki/Activity">wiki article</a>
     */
    ACTIVITY,
    
    /**
     * Usable in dungeons.
     */
    DUNGEON,
    
    /**
     * Usable in general PvE
     */
    PVE,
    
    /**
     * Usable in PvP
     */
    PVP,
    
    /**
     * Usable in the Heart of the Mists
     */
    PVPLOBBY,
    
    /**
     * Usable in World vs. World
     */
    WVW;
}
