package de.nebur97.git.gw2api.recipe.flags;

/**
 * Recipe flags.
 * @author NeBuR97
 *
 */
public enum RecipeFlag
{
    /**
     * Indicates that a recipe automatically unlocks upon reaching the required discipline rating.
     */
    AUTOLEARNED,
    
    /**
     * Indicates that a recipe is unlocked by consuming a recipe sheet.
     */
    LEARNEDFROMITEM;
}
