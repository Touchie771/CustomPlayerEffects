package me.touchie771.customPlayerEffects.listeners;

import me.touchie771.customPlayerEffects.commands.SpeedCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class SpeedMenuListener implements Listener {

    @EventHandler
    public void onSpeedSet(@NotNull InventoryClickEvent event) {
        if (!event.getView().title().equals(SpeedCommand.MENU_TITLE)) {
            return;
        }

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {
            case 11 -> {
                player.setWalkSpeed(0.1f);
                event.getInventory().close();
                player.sendMessage(Component.text("Your walk speed has been set to slow!", NamedTextColor.GREEN));
            }
            case 12 -> {
                player.setWalkSpeed(0.2f);
                event.getInventory().close();
                player.sendMessage(Component.text("Your walk speed has been set to normal!", NamedTextColor.GREEN));
            }
            case 13 -> {
                player.setWalkSpeed(0.3f);
                event.getInventory().close();
                player.sendMessage(Component.text("Your walk speed has been set to fast!", NamedTextColor.GREEN));
            }
            case 14 -> {
                player.setWalkSpeed(0.4f);
                event.getInventory().close();
                player.sendMessage(Component.text("Your walk speed has been set to very fast!", NamedTextColor.GREEN));
            }
            case 15 -> {
                player.setWalkSpeed(0.5f);
                event.getInventory().close();
                player.sendMessage(Component.text("Your walk speed has been set to ultra fast!", NamedTextColor.GREEN));
            }
            case 22 -> {
                player.setWalkSpeed(0.2f);
                event.getInventory().close();
                player.sendMessage(Component.text("Your walk speed has been reset!", NamedTextColor.GREEN));
            }
        }
    }
}