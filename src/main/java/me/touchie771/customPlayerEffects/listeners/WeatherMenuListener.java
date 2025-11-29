package me.touchie771.customPlayerEffects.listeners;

import me.touchie771.customPlayerEffects.commands.WeatherCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class WeatherMenuListener implements Listener {

    @EventHandler
    public void onWeatherSet(@NotNull InventoryClickEvent event) {
        if (!event.getView().title().equals(WeatherCommand.MENU_TITLE)) {
            return;
        }

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {
            case 12 -> {
                player.setPlayerWeather(WeatherType.CLEAR);
                event.getInventory().close();
                player.sendMessage(Component.text("Your weather has been set to clear!", NamedTextColor.GREEN));
            }
            case 13 -> {
                player.setPlayerWeather(WeatherType.DOWNFALL);
                event.getInventory().close();
                player.sendMessage(Component.text("Your weather has been set to rain!", NamedTextColor.GREEN));
            }
            case 14 -> {
                player.setPlayerWeather(WeatherType.DOWNFALL);
                event.getInventory().close();
                player.sendMessage(Component.text("Your weather has been set to thunder!", NamedTextColor.GREEN));
            }
            case 22 -> {
                player.resetPlayerWeather();
                event.getInventory().close();
                player.sendMessage(Component.text("Your weather has been reset!", NamedTextColor.GREEN));
            }
        }
    }
}