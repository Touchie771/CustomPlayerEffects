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

@dev.rollczi.litecommands.annotations.command.Command(name = "settime")
@Permission("customplayereffects.time")
public class TimeCommand {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Time Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    private final Plugin plugin;
    private Menu menu;

    public TimeCommand(Plugin plugin) {
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
            SlotItem.builder(11)
                .itemName(Component.text("Day", NamedTextColor.GOLD, TextDecoration.BOLD))
                .material(Material.SUNFLOWER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets time to 1000 (daytime)", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(12)
                .itemName(Component.text("Noon", NamedTextColor.YELLOW, TextDecoration.BOLD))
                .material(Material.DAYLIGHT_DETECTOR)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets time to 6000 (noon)", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(13)
                .itemName(Component.text("Reset Time", NamedTextColor.RED, TextDecoration.BOLD))
                .material(Material.BARRIER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Resets to natural time flow", NamedTextColor.GRAY),
                    Component.text("Click to reset", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(14)
                .itemName(Component.text("Night", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD))
                .material(Material.ENDER_EYE)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets time to 13000 (night)", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(15)
                .itemName(Component.text("Midnight", NamedTextColor.DARK_GRAY, TextDecoration.BOLD))
                .material(Material.OBSIDIAN)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets time to 18000 (midnight)", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build()
        );

        // Use the new fill capability instead of manual filler items
        return Menu.newBuilder()
            .plugin(plugin)
            .size(MENU_SIZE)
            .title(MENU_TITLE)
            .items(items.toArray(new SlotItem[0]))
            .fillExcept(Material.GRAY_STAINED_GLASS_PANE, 11, 12, 13, 14, 15)
            .build();
    }

    @Execute
    public void setTime(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}