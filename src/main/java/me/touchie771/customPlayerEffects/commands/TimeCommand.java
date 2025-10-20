package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@dev.rollczi.litecommands.annotations.command.Command(name = "settime")
@Permission("customplayereffects.time")
public record TimeCommand() implements Command {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Time Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    @Override
    public Inventory getMenu() {
        Inventory timeMenu = Bukkit.createInventory(null, MENU_SIZE, MENU_TITLE);

        ItemStack dayTime = new ItemStack(Material.SUNFLOWER, 1);
        ItemMeta dayTimeMeta = dayTime.getItemMeta();
        dayTimeMeta.displayName(Component.text("Day", NamedTextColor.GOLD, TextDecoration.BOLD));
        dayTime.setItemMeta(dayTimeMeta);
        timeMenu.setItem(11, dayTime);

        ItemStack noonTime = new ItemStack(Material.DAYLIGHT_DETECTOR, 1);
        ItemMeta noonTimeMeta = noonTime.getItemMeta();
        noonTimeMeta.displayName(Component.text("Noon", NamedTextColor.YELLOW, TextDecoration.BOLD));
        noonTime.setItemMeta(noonTimeMeta);
        timeMenu.setItem(12, noonTime);

        ItemStack resetTime = new ItemStack(Material.BARRIER, 1);
        ItemMeta resetTimeMeta = resetTime.getItemMeta();
        resetTimeMeta.displayName(Component.text("Reset Time", NamedTextColor.RED, TextDecoration.BOLD));
        resetTime.setItemMeta(resetTimeMeta);
        timeMenu.setItem(13, resetTime);

        ItemStack nightTime = new ItemStack(Material.ENDER_EYE, 1);
        ItemMeta nightTimeMeta = nightTime.getItemMeta();
        nightTimeMeta.displayName(Component.text("Night", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD));
        nightTime.setItemMeta(nightTimeMeta);
        timeMenu.setItem(14, nightTime);

        ItemStack midnightTime = new ItemStack(Material.OBSIDIAN, 1);
        ItemMeta midnightTimeMeta = midnightTime.getItemMeta();
        midnightTimeMeta.displayName(Component.text("Midnight", NamedTextColor.DARK_GRAY, TextDecoration.BOLD));
        midnightTime.setItemMeta(midnightTimeMeta);
        timeMenu.setItem(15, midnightTime);

        fillMenu(timeMenu);
        return timeMenu;
    }

    @Execute
    public void setTime(@Context Player player) {
        player.openInventory(getMenu());
    }
}