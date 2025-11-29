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

@dev.rollczi.litecommands.annotations.command.Command(name = "setspeed")
@Permission("customplayereffects.speed")
public class SpeedCommand {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Speed Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    private final Plugin plugin;
    private Menu menu;

    public SpeedCommand(Plugin plugin) {
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
                Component.text("Slow Walk Speed", NamedTextColor.GREEN, TextDecoration.BOLD),
                11,
                Material.LEATHER_BOOTS,
                1
            ),
            new SlotItem(
                Component.text("Normal Walk Speed", NamedTextColor.YELLOW, TextDecoration.BOLD),
                12,
                Material.CHAINMAIL_BOOTS,
                1
            ),
            new SlotItem(
                Component.text("Fast Walk Speed", NamedTextColor.GOLD, TextDecoration.BOLD),
                13,
                Material.GOLDEN_BOOTS,
                1
            ),
            new SlotItem(
                Component.text("Very Fast Walk Speed", NamedTextColor.AQUA, TextDecoration.BOLD),
                14,
                Material.DIAMOND_BOOTS,
                1
            ),
            new SlotItem(
                Component.text("Ultra Fast Walk Speed", NamedTextColor.DARK_RED, TextDecoration.BOLD),
                15,
                Material.NETHERITE_BOOTS,
                1
            ),
            new SlotItem(
                Component.text("Reset Speed", NamedTextColor.RED, TextDecoration.BOLD),
                22,
                Material.BARRIER,
                1
            )
        );

        List<SlotItem> fillerItems = MenuUtils.createFillerItems(
            MENU_SIZE,
            11, 12, 13, 14, 15, 22
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
    public void speed(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}