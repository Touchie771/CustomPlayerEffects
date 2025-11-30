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

@dev.rollczi.litecommands.annotations.command.Command(name = "setspeed")
@Permission("customplayereffects.speed")
public class SpeedCommand {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Speed Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    private final Plugin plugin;
    private Menu menu;

    public SpeedCommand(Plugin plugin) {
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
                .itemName(Component.text("Slow Walk Speed", NamedTextColor.GREEN, TextDecoration.BOLD))
                .material(Material.LEATHER_BOOTS)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets walk speed to 0.5x", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(12)
                .itemName(Component.text("Normal Walk Speed", NamedTextColor.YELLOW, TextDecoration.BOLD))
                .material(Material.CHAINMAIL_BOOTS)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets walk speed to 1.0x (default)", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(13)
                .itemName(Component.text("Fast Walk Speed", NamedTextColor.GOLD, TextDecoration.BOLD))
                .material(Material.GOLDEN_BOOTS)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets walk speed to 1.5x", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(14)
                .itemName(Component.text("Very Fast Walk Speed", NamedTextColor.AQUA, TextDecoration.BOLD))
                .material(Material.DIAMOND_BOOTS)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets walk speed to 2.0x", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(15)
                .itemName(Component.text("Ultra Fast Walk Speed", NamedTextColor.DARK_RED, TextDecoration.BOLD))
                .material(Material.NETHERITE_BOOTS)
                .quantity(1)
                .lore(List.of(
                    Component.text("Sets walk speed to 3.0x", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(22)
                .itemName(Component.text("Reset Speed", NamedTextColor.RED, TextDecoration.BOLD))
                .material(Material.BARRIER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Resets to default walk speed", NamedTextColor.GRAY),
                    Component.text("Click to reset", NamedTextColor.DARK_GRAY)
                ))
                .build()
        );

        // Use the new fill capability instead of manual filler items
        return Menu.newBuilder()
            .plugin(plugin)
            .size(MENU_SIZE)
            .title(MENU_TITLE)
            .items(items.toArray(new SlotItem[0]))
            .fillExcept(Material.GRAY_STAINED_GLASS_PANE, 11, 12, 13, 14, 15, 22)
            .build();
    }

    @Execute
    public void speed(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}