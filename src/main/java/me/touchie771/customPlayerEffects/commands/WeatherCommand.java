package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import me.touchie771.minecraftGUI.api.Menu;
import me.touchie771.minecraftGUI.api.SlotItem;
import me.touchie771.customPlayerEffects.utils.MenuUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
            new SlotItem(
                Component.text("Clear Weather", NamedTextColor.AQUA, TextDecoration.BOLD),
                12,
                Material.SUNFLOWER,
                1
            ),
            new SlotItem(
                Component.text("Rain Weather", NamedTextColor.AQUA, TextDecoration.BOLD),
                13,
                Material.WATER_BUCKET,
                1
            ),
            new SlotItem(
                Component.text("Thunder Weather", NamedTextColor.DARK_BLUE, TextDecoration.BOLD),
                14,
                Material.LIGHTNING_ROD,
                1
            ),
            new SlotItem(
                Component.text("Reset Weather", NamedTextColor.RED, TextDecoration.BOLD),
                22,
                Material.BARRIER,
                1
            )
        );

        List<SlotItem> fillerItems = MenuUtils.createFillerItems(
            MENU_SIZE,
            12, 13, 14, 22
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
    public void setWeather(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}