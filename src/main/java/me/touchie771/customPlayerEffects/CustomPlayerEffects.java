package me.touchie771.customPlayerEffects;

import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomPlayerEffects extends JavaPlugin {

    private LiteCommands<CommandSender> liteCommands;

    @Override
    public void onEnable() {
        // Register event listeners
        this.getServer().getPluginManager().registerEvents(new WeatherMenuListener(), this);
        this.getServer().getPluginManager().registerEvents(new TimeMenuListener(), this);

        // Setup LiteCommands
        this.liteCommands = LiteBukkitFactory.builder()
                .commands(
                        new WeatherCommand(),
                        new TimeCommand()
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