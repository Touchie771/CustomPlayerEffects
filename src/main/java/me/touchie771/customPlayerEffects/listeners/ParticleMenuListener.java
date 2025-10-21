package me.touchie771.customPlayerEffects.listeners;

import me.touchie771.customPlayerEffects.commands.ParticleCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public record ParticleMenuListener() implements Listener {

    private static final Map<UUID, Particle> ACTIVE_PARTICLES = new ConcurrentHashMap<>();

    public static Map<UUID, Particle> getActiveParticles() {
        return ACTIVE_PARTICLES;
    }

    @EventHandler
    public void onParticleSet(@NotNull InventoryClickEvent event) {
        if (!event.getView().title().equals(ParticleCommand.MENU_TITLE)) {
            return;
        }

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {
            case 10 -> setParticle(player, Particle.HEART, "Hearts");
            case 11 -> setParticle(player, Particle.FLAME, "Flames");
            case 12 -> setParticle(player, Particle.ENCHANT, "Enchantment");
            case 13 -> setParticle(player, Particle.CRIT, "Sparkles");
            case 14 -> setParticle(player, Particle.SMOKE, "Smoke");
            case 15 -> setParticle(player, Particle.PORTAL, "Portal");
            case 16 -> setParticle(player, Particle.NOTE, "Musical Notes");
            case 19 -> setParticle(player, Particle.HAPPY_VILLAGER, "Happy Villager");
            case 20 -> setParticle(player, Particle.CLOUD, "Cloud");
            case 21 -> setParticle(player, Particle.DRIPPING_WATER, "Water Drip");
            case 22 -> setParticle(player, Particle.DRIPPING_LAVA, "Lava Drip");
            case 23 -> setParticle(player, Particle.TOTEM_OF_UNDYING, "Totem");
            case 24 -> setParticle(player, Particle.SNOWFLAKE, "Snowflake");
            case 25 -> setParticle(player, Particle.END_ROD, "End Rod");
            case 28 -> setParticle(player, Particle.SOUL, "Soul");
            case 40 -> {
                ACTIVE_PARTICLES.remove(player.getUniqueId());
                event.getInventory().close();
                player.sendMessage(Component.text("Particle effects have been cleared!", NamedTextColor.GREEN));
            }
        }
    }

    private void setParticle(Player player, Particle particle, String particleName) {
        ACTIVE_PARTICLES.put(player.getUniqueId(), particle);
        player.sendMessage(Component.text(particleName + " particle effect has been enabled!", NamedTextColor.GREEN));
    }
}