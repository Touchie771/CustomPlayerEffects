package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import me.touchie771.minecraftGUI.api.Menu;
import me.touchie771.minecraftGUI.api.SlotItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@dev.rollczi.litecommands.annotations.command.Command(name = "setparticle")
@Permission("customplayereffects.particle")
public class ParticleCommand {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Particle Effects Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 45;

    private final Plugin plugin;
    private Menu menu;

    public ParticleCommand(Plugin plugin) {
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
            SlotItem.builder(10)
                .itemName(Component.text("Hearts", NamedTextColor.RED, TextDecoration.BOLD))
                .material(Material.RED_DYE)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays heart particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(11)
                .itemName(Component.text("Flames", NamedTextColor.GOLD, TextDecoration.BOLD))
                .material(Material.BLAZE_POWDER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays flame particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(12)
                .itemName(Component.text("Enchantment", NamedTextColor.AQUA, TextDecoration.BOLD))
                .material(Material.ENCHANTED_BOOK)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays enchantment particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(13)
                .itemName(Component.text("Sparkles", NamedTextColor.YELLOW, TextDecoration.BOLD))
                .material(Material.GLOWSTONE_DUST)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays sparkle particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(14)
                .itemName(Component.text("Smoke", NamedTextColor.DARK_GRAY, TextDecoration.BOLD))
                .material(Material.COAL)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays smoke particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(15)
                .itemName(Component.text("Portal", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD))
                .material(Material.ENDER_PEARL)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays portal particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(16)
                .itemName(Component.text("Musical Notes", NamedTextColor.GREEN, TextDecoration.BOLD))
                .material(Material.NOTE_BLOCK)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays musical note particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(19)
                .itemName(Component.text("Happy Villager", NamedTextColor.GREEN, TextDecoration.BOLD))
                .material(Material.EMERALD)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays happy villager particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(20)
                .itemName(Component.text("Cloud", NamedTextColor.WHITE, TextDecoration.BOLD))
                .material(Material.WHITE_WOOL)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays cloud particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(21)
                .itemName(Component.text("Water Drip", NamedTextColor.BLUE, TextDecoration.BOLD))
                .material(Material.WATER_BUCKET)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays water drip particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(22)
                .itemName(Component.text("Lava Drip", NamedTextColor.GOLD, TextDecoration.BOLD))
                .material(Material.LAVA_BUCKET)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays lava drip particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(23)
                .itemName(Component.text("Totem", NamedTextColor.GOLD, TextDecoration.BOLD))
                .material(Material.TOTEM_OF_UNDYING)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays totem particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(24)
                .itemName(Component.text("Snowflake", NamedTextColor.WHITE, TextDecoration.BOLD))
                .material(Material.SNOWBALL)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays snowflake particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(25)
                .itemName(Component.text("End Rod", NamedTextColor.WHITE, TextDecoration.BOLD))
                .material(Material.END_ROD)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays end rod particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(28)
                .itemName(Component.text("Soul", NamedTextColor.AQUA, TextDecoration.BOLD))
                .material(Material.SOUL_SAND)
                .quantity(1)
                .lore(List.of(
                    Component.text("Displays soul particles", NamedTextColor.GRAY),
                    Component.text("Click to apply", NamedTextColor.DARK_GRAY)
                ))
                .build(),
            SlotItem.builder(40)
                .itemName(Component.text("Clear Particles", NamedTextColor.RED, TextDecoration.BOLD))
                .material(Material.BARRIER)
                .quantity(1)
                .lore(List.of(
                    Component.text("Removes all particle effects", NamedTextColor.GRAY),
                    Component.text("Click to clear", NamedTextColor.DARK_GRAY)
                ))
                .build()
        );

        // Use the new fill capability instead of manual filler items
        return Menu.newBuilder()
            .plugin(plugin)
            .size(MENU_SIZE)
            .title(MENU_TITLE)
            .items(items.toArray(new SlotItem[0]))
            .fillExcept(Material.GRAY_STAINED_GLASS_PANE, 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 40)
            .build();
    }

    @Execute
    public void particle(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}