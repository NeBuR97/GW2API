package de.nebur97.git.gw2api.type;

/**
 * Possible item types.<br>
 * Names should be pretty self explanatory.<br>
 * Constants:<br>
 * <li>{@link #ARMOR} <li>{@link #BACK} <li>{@link #BAG} <li>{@link #CONSUMABLE}
 * <li>{@link #CONTAINER} <li>{@link #CRAFTINGMATERIAL} <li>{@link #GATHERING}
 * <li>{@link #GIZMO} <li>{@link #MINIPET} <li>{@link #TOOL} <li>{@link #TRAIT}
 * <li>{@link #TRINKET} <li>{@link #TROPHY} <li>{@link #UPGRADECOMPONENT} <li>
 * {@link #WEAPON}
 * 
 * @author NeBuR97
 * 
 **/
public enum Type
{

    /**
     * Armor.
     * 
     * @see de.nebur97.git.gw2api.type.armor.ARMOR ARMOR(enumeration)
     * @see de.nebur97.git.gw2api.item.Armor Armor(Item implementation)
     **/
    ARMOR,

    /**
     * Back items.
     * 
     * @see de.nebur97.git.gw2api.item.Back Back
     */
    BACK,

    /**
     * Inventory bags.
     * 
     * @see de.nebur97.git.gw2api.item.Bag Bag
     */
    BAG,

    /**
     * Consumables.
     * 
     * @see de.nebur97.git.gw2api.type.consumable.CONSUMABLE
     * Consumable(enumeration)
     * @see de.nebur97.git.gw2api.item.Consumable Consumable(Item
     * implementation)
     */
    CONSUMABLE,

    /**
     * Container.
     * 
     * @see de.nebur97.git.gw2api.item.Container Container
     */
    CONTAINER,

    /**
     * Crafting material.
     * 
     * @see de.nebur97.git.gw2api.item.CraftingMaterial CraftingMaterial
     */
    CRAFTINGMATERIAL,

    /**
     * Gathering tools.
     * 
     * @see de.nebur97.git.gw2api.item.Gathering Gathering
     */
    GATHERING,

    /**
     * Gizmos.
     * 
     * @see de.nebur97.git.gw2api.item.Gizmo Gizmo
     */
    GIZMO,

    /**
     * Miniatures.
     * 
     * @see de.nebur97.git.gw2api.item.MiniPet MiniPet
     */
    MINIPET,

    /**
     * Salvage kits.
     * 
     * @see de.nebur97.git.gw2api.item.Tool Tool
     */
    TOOL,

    /**
     * Trait guides.
     * 
     * @see de.nebur97.git.gw2api.item.Trait Trait
     */
    TRAIT,

    /**
     * Trinkets.
     * 
     * @see de.nebur97.git.gw2api.type.trinket.TRINKET Trinket(enum)
     * @see de.nebur97.git.gw2api.item.Trinket Trinket(Item impl)
     */
    TRINKET,

    /**
     * Trophies.
     * 
     * @see de.nebur97.git.gw2api.item.Trophy Trophy
     */
    TROPHY,

    /**
     * Upgrade components.
     * 
     * @see de.nebur97.git.gw2api.item.UpgradeComponent UpgradeComponent
     */
    UPGRADECOMPONENT,

    /**
     * Weapons.
     * 
     * @see de.nebur97.git.gw2api.type.weapon.WEAPON Weapon(enum)
     * @see de.nebur97.git.gw2api.item.Weapon Weapon(Item impl)
     */
    WEAPON;
}
