package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import me.touchie771.minecraftGUI.api.Menu;
import me.touchie771.minecraftGUI.api.SlotItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@dev.rollczi.litecommands.annotations.command.Command(name = "setpotion")
@Permission("customplayereffects.potion")
public class PotionCommand {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Potion Effects Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 45;

    private final Plugin plugin;
    private Menu menu;

    public PotionCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    public Menu getMenu() {
        if (menu == null) {
            menu = createMenu();
        }
        return menu;
    }

    private Menu createMenu() {
        List<SlotItem> items = List.of(
            SlotItem.builder(10)
                .itemName(Component.text("Speed", NamedTextColor.AQUA, TextDecoration.BOLD))
                .material(Material.SUGAR)
                .quantity(1)
                .lore(List.of(
                    Component.text("Increases movement speed", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(11)
                .itemName(Component.text("Jump Boost", NamedTextColor.GREEN, TextDecoration.BOLD))
                .material(Material.RABBIT_FOOT)
                .quantity(1)
                .lore(List.of(
                    Component.text("Increases jump height", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(12)
                .itemName(Component.text("Night Vision", NamedTextColor.BLUE, TextDecoration.BOLD))
                .material(Material.GOLDEN_CARROT)
                .quantity(1)
                .lore(List.of(
                    Component.text("See in the dark", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(13)
                .itemName(Component.text("Water Breathing", NamedTextColor.AQUA, TextDecoration.BOLD))
                .material(Material.PUFFERFISH)
                .quantity(1)
                .lore(List.of(
                    Component.text("Breathe underwater", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(14)
                .itemName(Component.text("Fire Resistance", NamedTextColor.GOLD, TextDecoration.BOLD))
                .material(Material.MAGMA_CREAM)
                .quantity(1)
                .lore(List.of(
                    Component.text("Immunity to fire damage", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(15)
                .itemName(Component.text("Regeneration", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD))
                .material(Material.GHAST_TEAR)
                .quantity(1)
                .lore(List.of(
                    Component.text("Regenerates health over time", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(16)
                .itemName(Component.text("Strength", NamedTextColor.RED, TextDecoration.BOLD))
                .material(Material.BLAZE_POWDER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Increases melee damage", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(19)
                .itemName(Component.text("Haste", NamedTextColor.YELLOW, TextDecoration.BOLD))
                .material(Material.REDSTONE)
                .quantity(1)
                .lore(List.of(
                    Component.text("Increases mining/attack speed", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(20)
                .itemName(Component.text("Resistance", NamedTextColor.DARK_GRAY, TextDecoration.BOLD))
                .material(Material.IRON_INGOT)
                .quantity(1)
                .lore(List.of(
                    Component.text("Reduces incoming damage", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(21)
                .itemName(Component.text("Absorption", NamedTextColor.GOLD, TextDecoration.BOLD))
                .material(Material.GOLDEN_APPLE)
                .quantity(1)
                .lore(List.of(
                    Component.text("Adds extra health hearts", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(22)
                .itemName(Component.text("Saturation", NamedTextColor.DARK_RED, TextDecoration.BOLD))
                .material(Material.COOKED_BEEF)
                .quantity(1)
                .lore(List.of(
                    Component.text("Restores hunger and saturation", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(23)
                .itemName(Component.text("Slow Falling", NamedTextColor.WHITE, TextDecoration.BOLD))
                .material(Material.PHANTOM_MEMBRANE)
                .quantity(1)
                .lore(List.of(
                    Component.text("Fall slowly without damage", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(24)
                .itemName(Component.text("Luck", NamedTextColor.GREEN, TextDecoration.BOLD))
                .material(Material.EMERALD)
                .quantity(1)
                .lore(List.of(
                    Component.text("Improves loot chances", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(25)
                .itemName(Component.text("Glowing", NamedTextColor.YELLOW, TextDecoration.BOLD))
                .material(Material.GLOWSTONE_DUST)
                .quantity(1)
                .lore(List.of(
                    Component.text("Makes player outline visible", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(40)
                .itemName(Component.text("Clear All Effects", NamedTextColor.RED, TextDecoration.BOLD))
                .material(Material.BARRIER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Removes all active effects", NamedTextColor.GRAY),
                    Component.text("Click to clear", NamedTextColor.DARK_GRAY)
                ))
                .build()
        );

        // Use the new fill capability instead of manual filler items
        return Menu.newBuilder()
            .plugin(plugin)
            .size(MENU_SIZE)
            .title(MENU_TITLE)
            .items(items.toArray(new SlotItem[0]))
            .fillExcept(Material.GRAY_STAINED_GLASS_PANE, 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 40)
            .build();
    }

    @Execute
    public void potion(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}