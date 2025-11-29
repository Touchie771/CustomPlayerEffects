package me.touchie771.customPlayerEffects.listeners;

import me.touchie771.customPlayerEffects.commands.PotionCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class PotionMenuListener implements Listener {

    private static final int INFINITE_DURATION = 999999;
    private static final int EFFECT_AMPLIFIER = 0;

    @EventHandler
    public void onPotionSet(@NotNull InventoryClickEvent event) {
        if (!event.getView().title().equals(PotionCommand.MENU_TITLE)) {
            return;
        }

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {
            case 10 -> applyEffect(player, PotionEffectType.SPEED, "Speed");
            case 11 -> applyEffect(player, PotionEffectType.JUMP_BOOST, "Jump Boost");
            case 12 -> applyEffect(player, PotionEffectType.NIGHT_VISION, "Night Vision");
            case 13 -> applyEffect(player, PotionEffectType.WATER_BREATHING, "Water Breathing");
            case 14 -> applyEffect(player, PotionEffectType.FIRE_RESISTANCE, "Fire Resistance");
            case 15 -> applyEffect(player, PotionEffectType.REGENERATION, "Regeneration");
            case 16 -> applyEffect(player, PotionEffectType.STRENGTH, "Strength");
            case 19 -> applyEffect(player, PotionEffectType.HASTE, "Haste");
            case 20 -> applyEffect(player, PotionEffectType.RESISTANCE, "Resistance");
            case 21 -> applyEffect(player, PotionEffectType.ABSORPTION, "Absorption");
            case 22 -> applyEffect(player, PotionEffectType.SATURATION, "Saturation");
            case 23 -> applyEffect(player, PotionEffectType.SLOW_FALLING, "Slow Falling");
            case 24 -> applyEffect(player, PotionEffectType.LUCK, "Luck");
            case 25 -> applyEffect(player, PotionEffectType.GLOWING, "Glowing");
            case 40 -> {
                player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));
                event.getInventory().close();
                player.sendMessage(Component.text("All potion effects have been cleared!", NamedTextColor.GREEN));
            }
        }
    }

    private void applyEffect(Player player, PotionEffectType effectType, String effectName) {
        PotionEffect effect = new PotionEffect(effectType, INFINITE_DURATION, EFFECT_AMPLIFIER, false, false, true);
        player.addPotionEffect(effect);
        player.sendMessage(Component.text(effectName + " effect has been applied!", NamedTextColor.GREEN));
    }
}