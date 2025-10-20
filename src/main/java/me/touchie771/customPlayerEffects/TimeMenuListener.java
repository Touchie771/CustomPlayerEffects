package me.touchie771.customPlayerEffects;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public record TimeMenuListener() implements Listener {

    @EventHandler
    public void onTimeSet(@NotNull InventoryClickEvent event) {
        if (!event.getView().title().equals(TimeCommand.MENU_TITLE)) {
            return;
        }

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {
            case 11 -> {
                player.setPlayerTime(1000, false);
                event.getInventory().close();
                player.sendMessage(Component.text("Your time has been set to day!", NamedTextColor.GREEN));
            }
            case 12 -> {
                player.setPlayerTime(6000, false);
                event.getInventory().close();
                player.sendMessage(Component.text("Your time has been set to noon!", NamedTextColor.GREEN));
            }
            case 13 -> {
                player.resetPlayerTime();
                event.getInventory().close();
                player.sendMessage(Component.text("Your time has been reset!", NamedTextColor.GREEN));
            }
            case 14 -> {
                player.setPlayerTime(13000, false);
                event.getInventory().close();
                player.sendMessage(Component.text("Your time has been set to night!", NamedTextColor.GREEN));
            }
            case 15 -> {
                player.setPlayerTime(18000, false);
                event.getInventory().close();
                player.sendMessage(Component.text("Your time has been set to midnight!", NamedTextColor.GREEN));
            }
        }
    }
}