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

import java.util.List;

@dev.rollczi.litecommands.annotations.command.Command(name = "setfly")
@Permission("customplayereffects.fly")
public record FlyCommand() implements Command {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Fly Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    @Override
    public Inventory getMenu() {
        Inventory flyMenu = Bukkit.createInventory(null, MENU_SIZE, MENU_TITLE);

        ItemStack toggleFly = new ItemStack(Material.ELYTRA, 1);
        ItemMeta toggleFlyMeta = toggleFly.getItemMeta();
        toggleFlyMeta.displayName(Component.text("Toggle Flight", NamedTextColor.AQUA, TextDecoration.BOLD));
        toggleFlyMeta.lore(List.of(
                Component.text("Enable or disable flight", NamedTextColor.GRAY)
        ));
        toggleFly.setItemMeta(toggleFlyMeta);
        flyMenu.setItem(13, toggleFly);

        ItemStack slowSpeed = new ItemStack(Material.FEATHER, 1);
        ItemMeta slowSpeedMeta = slowSpeed.getItemMeta();
        slowSpeedMeta.displayName(Component.text("Slow Fly Speed", NamedTextColor.GREEN, TextDecoration.BOLD));
        slowSpeedMeta.lore(List.of(
                Component.text("Set fly speed to 0.05", NamedTextColor.GRAY)
        ));
        slowSpeed.setItemMeta(slowSpeedMeta);
        flyMenu.setItem(11, slowSpeed);

        ItemStack normalSpeed = new ItemStack(Material.WIND_CHARGE, 1);
        ItemMeta normalSpeedMeta = normalSpeed.getItemMeta();
        normalSpeedMeta.displayName(Component.text("Normal Fly Speed", NamedTextColor.YELLOW, TextDecoration.BOLD));
        normalSpeedMeta.lore(List.of(
                Component.text("Set fly speed to 0.1 (default)", NamedTextColor.GRAY)
        ));
        normalSpeed.setItemMeta(normalSpeedMeta);
        flyMenu.setItem(12, normalSpeed);

        ItemStack fastSpeed = new ItemStack(Material.FIREWORK_ROCKET, 1);
        ItemMeta fastSpeedMeta = fastSpeed.getItemMeta();
        fastSpeedMeta.displayName(Component.text("Fast Fly Speed", NamedTextColor.GOLD, TextDecoration.BOLD));
        fastSpeedMeta.lore(List.of(
                Component.text("Set fly speed to 0.2", NamedTextColor.GRAY)
        ));
        fastSpeed.setItemMeta(fastSpeedMeta);
        flyMenu.setItem(14, fastSpeed);

        ItemStack veryFastSpeed = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta veryFastSpeedMeta = veryFastSpeed.getItemMeta();
        veryFastSpeedMeta.displayName(Component.text("Very Fast Fly Speed", NamedTextColor.RED, TextDecoration.BOLD));
        veryFastSpeedMeta.lore(List.of(
                Component.text("Set fly speed to 0.3", NamedTextColor.GRAY)
        ));
        veryFastSpeed.setItemMeta(veryFastSpeedMeta);
        flyMenu.setItem(15, veryFastSpeed);

        ItemStack resetFly = new ItemStack(Material.BARRIER, 1);
        ItemMeta resetFlyMeta = resetFly.getItemMeta();
        resetFlyMeta.displayName(Component.text("Reset Flight", NamedTextColor.RED, TextDecoration.BOLD));
        resetFlyMeta.lore(List.of(
                Component.text("Disable flight and reset speed", NamedTextColor.GRAY)
        ));
        resetFly.setItemMeta(resetFlyMeta);
        flyMenu.setItem(22, resetFly);

        fillMenu(flyMenu);
        return flyMenu;
    }

    @Execute
    public void fly(@Context Player player) {
        player.openInventory(getMenu());
    }
}