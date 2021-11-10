package de.feelix.easycore.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to create CustomItems
 *
 * @author SaveFeelix
 * @version 1.0
 */
public final class ItemBuilder {

    /**
     * Reference to the ItemStack
     */
    private final ItemStack item;

    /**
     * Reference to the ItemMeta
     */
    private final ItemMeta meta;

    /**
     * Default Constructor to create a new ItemStack
     * @param material the Material
     */
    public ItemBuilder(Material material) {
        this(new ItemStack(material));
    }

    /**
     * Default Constructor to edit an existing ItemStack
     * @param item the ItemStack
     */
    public ItemBuilder(ItemStack item) {
        this(item, item.getAmount());
    }

    /**
     * Default Constructor to create an existing Item with an custom amount
     * @param item the ItemStack
     * @param amount the custom Amount
     */
    public ItemBuilder(ItemStack item, int amount) {
        this.item = item;
        this.item.setAmount(amount);
        this.meta = this.item.getItemMeta();
    }

    /**
     * Set a custom Displayname
     *
     * @param name the Displayname
     * @return the ItemBuilder
     */
    public ItemBuilder setDisplayName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    /**
     * Set a custom Lore
     *
     * @param lore the Lore
     * @return the ItemBuilder
     */
    public ItemBuilder setLore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    /**
     * Set a custom Amount
     *
     * @param amount the Amount
     * @return the ItemBuilder
     */
    public ItemBuilder setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    /**
     * <pre>
     * Add an Safe Enchantment
     * It will set the Level to 1
     * </pre>
     *
     * @param enchantment the Enchantment
     * @return the ItemBuilder
     */
    public ItemBuilder addSafeEnchantment(Enchantment enchantment) {
        return this.addSafeEnchantment(enchantment, 1);
    }

    /**
     * Add an Safe Enchantment
     *
     * @param enchantment the Enchantment
     * @param level       the Level
     * @return the ItemBuilder
     */
    public ItemBuilder addSafeEnchantment(Enchantment enchantment, int level) {
        item.addEnchantment(enchantment, level);
        return this;
    }

    /**
     * <pre>
     * Add many Safe Enchantments
     * It will set all Levels to 1
     * </pre>
     *
     * @param enchantments the Enchantments
     * @return the ItemBuilder
     */
    public ItemBuilder addSafeEnchantments(Enchantment... enchantments) {
        Map<Enchantment, Integer> enchantmentsMap = new HashMap<>();
        for (Enchantment enchantment : enchantments)
            enchantmentsMap.put(enchantment, 1);
        return this.addSafeEnchantments(enchantmentsMap);
    }

    /**
     * Add many Safe Enchantments
     *
     * @param enchantments a map which include an Enchantent and the level
     * @return the ItemBuilder
     */
    public ItemBuilder addSafeEnchantments(Map<Enchantment, Integer> enchantments) {
        item.addEnchantments(enchantments);
        return this;
    }

    /**
     * <pre>
     * Add an Unsafe Enchantment
     * It will set the Level to 1
     * </pre>
     *
     * @param enchantment the Enchantment
     * @return the ItemBuilder
     */
    public ItemBuilder addUnsafeEnchantment(Enchantment enchantment) {
        return this.addUnsafeEnchantment(enchantment, 1);
    }

    /**
     * Add an Unsafe Enchantment
     *
     * @param enchantment the Enchantment
     * @param level       the Level
     * @return the ItemBuilder
     */
    public ItemBuilder addUnsafeEnchantment(Enchantment enchantment, int level) {
        item.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    /**
     * <pre>
     * Add many Unsafe Enchantments
     * It will set all Levels to 1
     * </pre>
     *
     * @param enchantments the Enchantments
     * @return the ItemBuilder
     */
    public ItemBuilder addUnsafeEnchantments(List<Enchantment> enchantments) {
        Map<Enchantment, Integer> enchantmentsMap = new HashMap<>();
        for (Enchantment enchantment : enchantments)
            enchantmentsMap.put(enchantment, 1);
        return this.addUnsafeEnchantments(enchantmentsMap);
    }

    /**
     * Add many Unsafe Enchantments
     *
     * @param enchantments a Map which includes the Enchantments an the Levels
     * @return the ItemBuilder
     */
    public ItemBuilder addUnsafeEnchantments(Map<Enchantment, Integer> enchantments) {
        item.addUnsafeEnchantments(enchantments);
        return this;
    }

    /**
     * Remove one/many Safe/Unsafe Enchantments
     *
     * @param enchantments the Enchantments
     * @return the ItemBuilder
     */
    public ItemBuilder removeEnchantments(Enchantment... enchantments) {
        for (Enchantment enchantment : enchantments) {
            if (item.containsEnchantment(enchantment))
                item.removeEnchantment(enchantment);
        }
        return this;
    }

    /**
     * Add an ItemFlag to the Item
     *
     * @param flag the ItemFlag
     * @return the ItemBuilder
     */
    public ItemBuilder addItemFlag(ItemFlag flag) {
        return this.addItemFlags(flag);
    }

    /**
     * Add many ItemFlags to the Item
     *
     * @param flags the ItemFlags
     * @return the ItemBuilder
     */
    public ItemBuilder addItemFlags(ItemFlag... flags) {
        meta.addItemFlags(flags);
        return this;
    }

    /**
     * Remove the ItemFlags from the Item
     *
     * @param itemFlags the ItemFlags
     * @return the ItemBuilder
     */
    public ItemBuilder removeItemFlags(@NotNull ItemFlag @NotNull ... itemFlags) {
        for (ItemFlag itemFlag : itemFlags) {
            if (meta.hasItemFlag(itemFlag))
                meta.removeItemFlags(itemFlag);
        }
        return this;
    }

    /**
     * Set the item unbreakable
     * @param unbreakable the Value
     * @return the ItemBuilder
     */
    public ItemBuilder setUnbreakable(boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        return this;
    }


    /**
     * Method to get the final ItemStack
     * @return the Item
     */
    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }
}
