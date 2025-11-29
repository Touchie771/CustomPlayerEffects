package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import me.touchie771.minecraftGUI.api.Menu;
import me.touchie771.minecraftGUI.api.SlotItem;
import me.touchie771.customPlayerEffects.utils.MenuUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
            new SlotItem(
                Component.text("Speed", NamedTextColor.AQUA, TextDecoration.BOLD),
                10,
                Material.SUGAR,
                1
            ),
            new SlotItem(
                Component.text("Jump Boost", NamedTextColor.GREEN, TextDecoration.BOLD),
                11,
                Material.RABBIT_FOOT,
                1
            ),
            new SlotItem(
                Component.text("Night Vision", NamedTextColor.BLUE, TextDecoration.BOLD),
                12,
                Material.GOLDEN_CARROT,
                1
            ),
            new SlotItem(
                Component.text("Water Breathing", NamedTextColor.AQUA, TextDecoration.BOLD),
                13,
                Material.PUFFERFISH,
                1
            ),
            new SlotItem(
                Component.text("Fire Resistance", NamedTextColor.GOLD, TextDecoration.BOLD),
                14,
                Material.MAGMA_CREAM,
                1
            ),
            new SlotItem(
                Component.text("Regeneration", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD),
                15,
                Material.GHAST_TEAR,
                1
            ),
            new SlotItem(
                Component.text("Strength", NamedTextColor.RED, TextDecoration.BOLD),
                16,
                Material.BLAZE_POWDER,
                1
            ),
            new SlotItem(
                Component.text("Haste", NamedTextColor.YELLOW, TextDecoration.BOLD),
                19,
                Material.REDSTONE,
                1
            ),
            new SlotItem(
                Component.text("Resistance", NamedTextColor.DARK_GRAY, TextDecoration.BOLD),
                20,
                Material.IRON_INGOT,
                1
            ),
            new SlotItem(
                Component.text("Absorption", NamedTextColor.GOLD, TextDecoration.BOLD),
                21,
                Material.GOLDEN_APPLE,
                1
            ),
            new SlotItem(
                Component.text("Saturation", NamedTextColor.DARK_RED, TextDecoration.BOLD),
                22,
                Material.COOKED_BEEF,
                1
            ),
            new SlotItem(
                Component.text("Slow Falling", NamedTextColor.WHITE, TextDecoration.BOLD),
                23,
                Material.PHANTOM_MEMBRANE,
                1
            ),
            new SlotItem(
                Component.text("Luck", NamedTextColor.GREEN, TextDecoration.BOLD),
                24,
                Material.EMERALD,
                1
            ),
            new SlotItem(
                Component.text("Glowing", NamedTextColor.YELLOW, TextDecoration.BOLD),
                25,
                Material.GLOWSTONE_DUST,
                1
            ),
            new SlotItem(
                Component.text("Clear All Effects", NamedTextColor.RED, TextDecoration.BOLD),
                40,
                Material.BARRIER,
                1
            )
        );

        List<SlotItem> fillerItems = MenuUtils.createFillerItems(
            MENU_SIZE,
            10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 40
        );

        List<SlotItem> allItems = new ArrayList<>();
        allItems.addAll(items);
        allItems.addAll(fillerItems);

        return Menu.newBuilder()
            .plugin(plugin)
            .size(MENU_SIZE)
            .title(MENU_TITLE)
            .items(allItems.toArray(new SlotItem[0]))
            .build();
    }

    @Execute
    public void potion(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}