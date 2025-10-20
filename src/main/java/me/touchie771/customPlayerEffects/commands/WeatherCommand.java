package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@dev.rollczi.litecommands.annotations.command.Command(name = "setweather")
@Permission("customplayereffects.weather")
public record WeatherCommand() implements Command {

    public static final @NotNull Component MENU_TITLE = Component.text("Weather Menu",
            NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    @Override
    public Inventory getMenu() {
        Inventory weatherMenu = Bukkit.createInventory(null, MENU_SIZE, MENU_TITLE);

        ItemStack clearWeather = new ItemStack(Material.SUNFLOWER, 1);
        ItemMeta clearWeatherMeta = clearWeather.getItemMeta();
        clearWeatherMeta.displayName(Component.text("Clear Weather", NamedTextColor.AQUA, TextDecoration.BOLD));
        clearWeather.setItemMeta(clearWeatherMeta);
        weatherMenu.setItem(12, clearWeather);

        ItemStack rainWeather = new ItemStack(Material.WATER_BUCKET, 1);
        ItemMeta rainWeatherMeta = rainWeather.getItemMeta();
        rainWeatherMeta.displayName(Component.text("Rain Weather", NamedTextColor.AQUA, TextDecoration.BOLD));
        rainWeather.setItemMeta(rainWeatherMeta);
        weatherMenu.setItem(13, rainWeather);

        ItemStack thunderWeather = new ItemStack(Material.LIGHTNING_ROD, 1);
        ItemMeta thunderWeatherMeta = thunderWeather.getItemMeta();
        thunderWeatherMeta.displayName(Component.text("Thunder Weather", NamedTextColor.DARK_BLUE, TextDecoration.BOLD));
        thunderWeather.setItemMeta(thunderWeatherMeta);
        weatherMenu.setItem(14, thunderWeather);

        ItemStack resetWeather = new ItemStack(Material.BARRIER, 1);
        ItemMeta resetWeatherMeta = resetWeather.getItemMeta();
        resetWeatherMeta.displayName(Component.text("Reset Weather", NamedTextColor.RED, TextDecoration.BOLD));
        resetWeather.setItemMeta(resetWeatherMeta);
        weatherMenu.setItem(22, resetWeather);

        fillMenu(weatherMenu);
        return weatherMenu;
    }

    @Execute
    public void setWeather(@Context Player player) {
        player.openInventory(getMenu());
    }
}