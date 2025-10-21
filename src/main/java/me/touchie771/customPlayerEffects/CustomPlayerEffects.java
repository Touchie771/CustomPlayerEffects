package me.touchie771.customPlayerEffects;

import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import me.touchie771.customPlayerEffects.commands.FlyCommand;
import me.touchie771.customPlayerEffects.commands.PotionCommand;
import me.touchie771.customPlayerEffects.commands.SpeedCommand;
import me.touchie771.customPlayerEffects.commands.TimeCommand;
import me.touchie771.customPlayerEffects.commands.WeatherCommand;
import me.touchie771.customPlayerEffects.listeners.FlyMenuListener;
import me.touchie771.customPlayerEffects.listeners.PotionMenuListener;
import me.touchie771.customPlayerEffects.listeners.SpeedMenuListener;
import me.touchie771.customPlayerEffects.listeners.TimeMenuListener;
import me.touchie771.customPlayerEffects.listeners.WeatherMenuListener;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomPlayerEffects extends JavaPlugin {

    private LiteCommands<CommandSender> liteCommands;

    @Override
    public void onEnable() {
        // Register event listeners
        this.getServer().getPluginManager().registerEvents(new WeatherMenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new TimeMenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new FlyMenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new SpeedMenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new PotionMenuListener(), this);

        // Setup LiteCommands
        this.liteCommands = LiteBukkitFactory.builder()
                .commands(
                        new WeatherCommand(),
                        new TimeCommand(),
                        new FlyCommand(),
                        new SpeedCommand(),
                        new PotionCommand()
                )
                .build();

        this.getLogger().info("CustomPlayerEffects has been enabled!");
    }

    @Override
    public void onDisable() {
        // Unregister LiteCommands
        if (this.liteCommands != null) {
            this.liteCommands.unregister();
        }

        this.getLogger().info("CustomPlayerEffects has been disabled!");
    }
}