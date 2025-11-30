package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import me.touchie771.minecraftGUI.api.Menu;
import me.touchie771.minecraftGUI.api.SlotItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@dev.rollczi.litecommands.annotations.command.Command(name = "setweather")
@Permission("customplayereffects.weather")
public class WeatherCommand {

    public static final @NotNull Component MENU_TITLE = Component.text("Weather Menu",
            NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    private final Plugin plugin;
    private Menu menu;

    public WeatherCommand(Plugin plugin) {
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
            SlotItem.builder(12)
                .itemName(Component.text("Clear Weather", NamedTextColor.AQUA, TextDecoration.BOLD))
                .material(Material.SUNFLOWER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Clears all weather", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(13)
                .itemName(Component.text("Rain Weather", NamedTextColor.AQUA, TextDecoration.BOLD))
                .material(Material.WATER_BUCKET)
                .quantity(1)
                .lore(List.of(
                    Component.text("Starts rain", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(14)
                .itemName(Component.text("Thunder Weather", NamedTextColor.DARK_BLUE, TextDecoration.BOLD))
                .material(Material.LIGHTNING_ROD)
                .quantity(1)
                .lore(List.of(
                    Component.text("Starts thunderstorm", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(22)
                .itemName(Component.text("Reset Weather", NamedTextColor.RED, TextDecoration.BOLD))
                .material(Material.BARRIER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Resets to natural weather", NamedTextColor.GRAY),
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
            .fillExcept(Material.GRAY_STAINED_GLASS_PANE, 12, 13, 14, 22)
            .build();
    }

    @Execute
    public void setWeather(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}