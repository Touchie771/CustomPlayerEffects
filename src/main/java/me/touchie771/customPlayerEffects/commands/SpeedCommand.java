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

@dev.rollczi.litecommands.annotations.command.Command(name = "setspeed")
@Permission("customplayereffects.speed")
public record SpeedCommand() implements Command {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Speed Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    @Override
    public Inventory getMenu() {
        Inventory speedMenu = Bukkit.createInventory(null, MENU_SIZE, MENU_TITLE);

        ItemStack slowSpeed = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta slowSpeedMeta = slowSpeed.getItemMeta();
        slowSpeedMeta.displayName(Component.text("Slow Walk Speed", NamedTextColor.GREEN, TextDecoration.BOLD));
        slowSpeedMeta.lore(List.of(
                Component.text("Set walk speed to 0.1", NamedTextColor.GRAY)
        ));
        slowSpeed.setItemMeta(slowSpeedMeta);
        speedMenu.setItem(11, slowSpeed);

        ItemStack normalSpeed = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta normalSpeedMeta = normalSpeed.getItemMeta();
        normalSpeedMeta.displayName(Component.text("Normal Walk Speed", NamedTextColor.YELLOW, TextDecoration.BOLD));
        normalSpeedMeta.lore(List.of(
                Component.text("Set walk speed to 0.2 (default)", NamedTextColor.GRAY)
        ));
        normalSpeed.setItemMeta(normalSpeedMeta);
        speedMenu.setItem(12, normalSpeed);

        ItemStack fastSpeed = new ItemStack(Material.GOLDEN_BOOTS, 1);
        ItemMeta fastSpeedMeta = fastSpeed.getItemMeta();
        fastSpeedMeta.displayName(Component.text("Fast Walk Speed", NamedTextColor.GOLD, TextDecoration.BOLD));
        fastSpeedMeta.lore(List.of(
                Component.text("Set walk speed to 0.3", NamedTextColor.GRAY)
        ));
        fastSpeed.setItemMeta(fastSpeedMeta);
        speedMenu.setItem(13, fastSpeed);

        ItemStack veryFastSpeed = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta veryFastSpeedMeta = veryFastSpeed.getItemMeta();
        veryFastSpeedMeta.displayName(Component.text("Very Fast Walk Speed", NamedTextColor.AQUA, TextDecoration.BOLD));
        veryFastSpeedMeta.lore(List.of(
                Component.text("Set walk speed to 0.4", NamedTextColor.GRAY)
        ));
        veryFastSpeed.setItemMeta(veryFastSpeedMeta);
        speedMenu.setItem(14, veryFastSpeed);

        ItemStack ultraFastSpeed = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta ultraFastSpeedMeta = ultraFastSpeed.getItemMeta();
        ultraFastSpeedMeta.displayName(Component.text("Ultra Fast Walk Speed", NamedTextColor.DARK_RED, TextDecoration.BOLD));
        ultraFastSpeedMeta.lore(List.of(
                Component.text("Set walk speed to 0.5", NamedTextColor.GRAY)
        ));
        ultraFastSpeed.setItemMeta(ultraFastSpeedMeta);
        speedMenu.setItem(15, ultraFastSpeed);

        ItemStack resetSpeed = new ItemStack(Material.BARRIER, 1);
        ItemMeta resetSpeedMeta = resetSpeed.getItemMeta();
        resetSpeedMeta.displayName(Component.text("Reset Speed", NamedTextColor.RED, TextDecoration.BOLD));
        resetSpeedMeta.lore(List.of(
                Component.text("Reset walk speed to default", NamedTextColor.GRAY)
        ));
        resetSpeed.setItemMeta(resetSpeedMeta);
        speedMenu.setItem(22, resetSpeed);

        fillMenu(speedMenu);
        return speedMenu;
    }

    @Execute
    public void speed(@Context Player player) {
        player.openInventory(getMenu());
    }
}