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

@dev.rollczi.litecommands.annotations.command.Command(name = "setfly")
@Permission("customplayereffects.fly")
public class FlyCommand {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Fly Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 27;

    private final Plugin plugin;
    private Menu menu;

    public FlyCommand(Plugin plugin) {
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
                Component.text("Toggle Flight", NamedTextColor.AQUA, TextDecoration.BOLD),
                13,
                Material.ELYTRA,
                1
            ),
            new SlotItem(
                Component.text("Slow Fly Speed", NamedTextColor.GREEN, TextDecoration.BOLD),
                11,
                Material.FEATHER,
                1
            ),
            new SlotItem(
                Component.text("Normal Fly Speed", NamedTextColor.YELLOW, TextDecoration.BOLD),
                12,
                Material.WIND_CHARGE,
                1
            ),
            new SlotItem(
                Component.text("Fast Fly Speed", NamedTextColor.GOLD, TextDecoration.BOLD),
                14,
                Material.FIREWORK_ROCKET,
                1
            ),
            new SlotItem(
                Component.text("Very Fast Fly Speed", NamedTextColor.RED, TextDecoration.BOLD),
                15,
                Material.BLAZE_POWDER,
                1
            ),
            new SlotItem(
                Component.text("Reset Flight", NamedTextColor.RED, TextDecoration.BOLD),
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
    public void fly(@Context Player player) {
        player.openInventory(getMenu().getInventory());
    }
}