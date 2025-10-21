package me.touchie771.customPlayerEffects.listeners;

import me.touchie771.customPlayerEffects.commands.FlyCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public record FlyMenuListener() implements Listener {

    @EventHandler
    public void onFlySet(@NotNull InventoryClickEvent event) {
        if (!event.getView().title().equals(FlyCommand.MENU_TITLE)) {
            return;
        }

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {
            case 11 -> {
                player.setFlySpeed(0.05f);
                player.sendMessage(Component.text("Your fly speed has been set to slow!", NamedTextColor.GREEN));
            }
            case 12 -> {
                player.setFlySpeed(0.1f);
                player.sendMessage(Component.text("Your fly speed has been set to normal!", NamedTextColor.GREEN));
            }
            case 13 -> {
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage(Component.text("Flight has been disabled!", NamedTextColor.RED));
                } else {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage(Component.text("Flight has been enabled!", NamedTextColor.GREEN));
                }
                event.getInventory().close();
            }
            case 14 -> {
                player.setFlySpeed(0.2f);
                player.sendMessage(Component.text("Your fly speed has been set to fast!", NamedTextColor.GREEN));
            }
            case 15 -> {
                player.setFlySpeed(0.3f);
                player.sendMessage(Component.text("Your fly speed has been set to very fast!", NamedTextColor.GREEN));
            }
            case 22 -> {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.setFlySpeed(0.1f);
                event.getInventory().close();
                player.sendMessage(Component.text("Flight has been reset!", NamedTextColor.GREEN));
            }
        }
    }
}