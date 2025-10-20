package me.touchie771.customPlayerEffects.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface Command {

    Inventory getMenu();

    default ItemStack getFillerItem() {
        ItemStack fillerItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta fillerItemMeta = fillerItem.getItemMeta();
        fillerItemMeta.displayName(Component.empty());
        fillerItem.setItemMeta(fillerItemMeta);
        return fillerItem;
    }

    default void fillMenu(Inventory menu) {
        for (int i = 0; i < menu.getSize(); i++) {
            if (menu.getItem(i) == null) {
                menu.setItem(i, getFillerItem());
            }
        }
    }
}