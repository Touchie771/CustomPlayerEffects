package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import me.touchie771.minecraftGUI.api.Menu;
import me.touchie771.minecraftGUI.api.SlotItem;
import me.touchie771.customPlayerEffects.utils.MenuUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
            new SlotItem(
                Component.text("Hearts", NamedTextColor.RED, TextDecoration.BOLD),
                10,
                Material.RED_DYE,
                1
            ),
            new SlotItem(
                Component.text("Flames", NamedTextColor.GOLD, TextDecoration.BOLD),
                11,
                Material.BLAZE_POWDER,
                1
            ),
            new SlotItem(
                Component.text("Enchantment", NamedTextColor.AQUA, TextDecoration.BOLD),
                12,
                Material.ENCHANTED_BOOK,
                1
            ),
            new SlotItem(
                Component.text("Sparkles", NamedTextColor.YELLOW, TextDecoration.BOLD),
                13,
                Material.GLOWSTONE_DUST,
                1
            ),
            new SlotItem(
                Component.text("Smoke", NamedTextColor.DARK_GRAY, TextDecoration.BOLD),
                14,
                Material.COAL,
                1
            ),
            new SlotItem(
                Component.text("Portal", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD),
                15,
                Material.ENDER_PEARL,
                1
            ),
            new SlotItem(
                Component.text("Musical Notes", NamedTextColor.GREEN, TextDecoration.BOLD),
                16,
                Material.NOTE_BLOCK,
                1
            ),
            new SlotItem(
                Component.text("Happy Villager", NamedTextColor.GREEN, TextDecoration.BOLD),
                19,
                Material.EMERALD,
                1
            ),
            new SlotItem(
                Component.text("Cloud", NamedTextColor.WHITE, TextDecoration.BOLD),
                20,
                Material.WHITE_WOOL,
                1
            ),
            new SlotItem(
                Component.text("Water Drip", NamedTextColor.BLUE, TextDecoration.BOLD),
                21,
                Material.WATER_BUCKET,
                1
            ),
            new SlotItem(
                Component.text("Lava Drip", NamedTextColor.GOLD, TextDecoration.BOLD),
                22,
                Material.LAVA_BUCKET,
                1
            ),
            new SlotItem(
                Component.text("Totem", NamedTextColor.GOLD, TextDecoration.BOLD),
                23,
                Material.TOTEM_OF_UNDYING,
                1
            ),
            new SlotItem(
                Component.text("Snowflake", NamedTextColor.WHITE, TextDecoration.BOLD),
                24,
                Material.SNOWBALL,
                1
            ),
            new SlotItem(
                Component.text("End Rod", NamedTextColor.WHITE, TextDecoration.BOLD),
                25,
                Material.END_ROD,
                1
            ),
            new SlotItem(
                Component.text("Soul", NamedTextColor.AQUA, TextDecoration.BOLD),
                28,
                Material.SOUL_SAND,
                1
            ),
            new SlotItem(
                Component.text("Clear Particles", NamedTextColor.RED, TextDecoration.BOLD),
                40,
                Material.BARRIER,
                1
            )
        );

        List<SlotItem> fillerItems = MenuUtils.createFillerItems(
            MENU_SIZE,
            10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 40
        );

        List<SlotItem> allItems = new ArrayList<>();
        allItems.addAll(items);
        allItems.addAll(fillerItems);

        return Menu.newBuilder()
            .plugin(plugin)
            .size(MENU_SIZE)
            .title(MENU_TITLE)
            .items(allItems.toArray(new SlotItem[0]))
            .build();
    }

    @Execute
    public void particle(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}