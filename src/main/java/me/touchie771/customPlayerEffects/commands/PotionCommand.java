package me.touchie771.customPlayerEffects.commands;

import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@dev.rollczi.litecommands.annotations.command.Command(name = "setpotion")
@Permission("customplayereffects.potion")
public record PotionCommand() implements Command {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Potion Effects Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 45;

    @Override
    public Inventory getMenu() {
        Inventory potionMenu = Bukkit.createInventory(null, MENU_SIZE, MENU_TITLE);

        ItemStack speed = new ItemStack(Material.SUGAR, 1);
        ItemMeta speedMeta = speed.getItemMeta();
        speedMeta.displayName(Component.text("Speed", NamedTextColor.AQUA, TextDecoration.BOLD));
        speedMeta.lore(List.of(
                Component.text("Increases movement speed", NamedTextColor.GRAY)
        ));
        speed.setItemMeta(speedMeta);
        potionMenu.setItem(10, speed);

        ItemStack jumpBoost = new ItemStack(Material.RABBIT_FOOT, 1);
        ItemMeta jumpBoostMeta = jumpBoost.getItemMeta();
        jumpBoostMeta.displayName(Component.text("Jump Boost", NamedTextColor.GREEN, TextDecoration.BOLD));
        jumpBoostMeta.lore(List.of(
                Component.text("Increases jump height", NamedTextColor.GRAY)
        ));
        jumpBoost.setItemMeta(jumpBoostMeta);
        potionMenu.setItem(11, jumpBoost);

        ItemStack nightVision = new ItemStack(Material.GOLDEN_CARROT, 1);
        ItemMeta nightVisionMeta = nightVision.getItemMeta();
        nightVisionMeta.displayName(Component.text("Night Vision", NamedTextColor.BLUE, TextDecoration.BOLD));
        nightVisionMeta.lore(List.of(
                Component.text("See clearly in the dark", NamedTextColor.GRAY)
        ));
        nightVision.setItemMeta(nightVisionMeta);
        potionMenu.setItem(12, nightVision);

        ItemStack waterBreathing = new ItemStack(Material.PUFFERFISH, 1);
        ItemMeta waterBreathingMeta = waterBreathing.getItemMeta();
        waterBreathingMeta.displayName(Component.text("Water Breathing", NamedTextColor.AQUA, TextDecoration.BOLD));
        waterBreathingMeta.lore(List.of(
                Component.text("Breathe underwater", NamedTextColor.GRAY)
        ));
        waterBreathing.setItemMeta(waterBreathingMeta);
        potionMenu.setItem(13, waterBreathing);

        ItemStack fireResistance = new ItemStack(Material.MAGMA_CREAM, 1);
        ItemMeta fireResistanceMeta = fireResistance.getItemMeta();
        fireResistanceMeta.displayName(Component.text("Fire Resistance", NamedTextColor.GOLD, TextDecoration.BOLD));
        fireResistanceMeta.lore(List.of(
                Component.text("Immunity to fire and lava", NamedTextColor.GRAY)
        ));
        fireResistance.setItemMeta(fireResistanceMeta);
        potionMenu.setItem(14, fireResistance);

        ItemStack regeneration = new ItemStack(Material.GHAST_TEAR, 1);
        ItemMeta regenerationMeta = regeneration.getItemMeta();
        regenerationMeta.displayName(Component.text("Regeneration", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD));
        regenerationMeta.lore(List.of(
                Component.text("Gradually restores health", NamedTextColor.GRAY)
        ));
        regeneration.setItemMeta(regenerationMeta);
        potionMenu.setItem(15, regeneration);

        ItemStack strength = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta strengthMeta = strength.getItemMeta();
        strengthMeta.displayName(Component.text("Strength", NamedTextColor.RED, TextDecoration.BOLD));
        strengthMeta.lore(List.of(
                Component.text("Increases melee damage", NamedTextColor.GRAY)
        ));
        strength.setItemMeta(strengthMeta);
        potionMenu.setItem(16, strength);

        ItemStack haste = new ItemStack(Material.REDSTONE, 1);
        ItemMeta hasteMeta = haste.getItemMeta();
        hasteMeta.displayName(Component.text("Haste", NamedTextColor.YELLOW, TextDecoration.BOLD));
        hasteMeta.lore(List.of(
                Component.text("Increases mining speed", NamedTextColor.GRAY)
        ));
        haste.setItemMeta(hasteMeta);
        potionMenu.setItem(19, haste);

        ItemStack resistance = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta resistanceMeta = resistance.getItemMeta();
        resistanceMeta.displayName(Component.text("Resistance", NamedTextColor.DARK_GRAY, TextDecoration.BOLD));
        resistanceMeta.lore(List.of(
                Component.text("Reduces incoming damage", NamedTextColor.GRAY)
        ));
        resistance.setItemMeta(resistanceMeta);
        potionMenu.setItem(20, resistance);

        ItemStack absorption = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta absorptionMeta = absorption.getItemMeta();
        absorptionMeta.displayName(Component.text("Absorption", NamedTextColor.GOLD, TextDecoration.BOLD));
        absorptionMeta.lore(List.of(
                Component.text("Adds extra hearts", NamedTextColor.GRAY)
        ));
        absorption.setItemMeta(absorptionMeta);
        potionMenu.setItem(21, absorption);

        ItemStack saturation = new ItemStack(Material.COOKED_BEEF, 1);
        ItemMeta saturationMeta = saturation.getItemMeta();
        saturationMeta.displayName(Component.text("Saturation", NamedTextColor.DARK_RED, TextDecoration.BOLD));
        saturationMeta.lore(List.of(
                Component.text("Restores hunger instantly", NamedTextColor.GRAY)
        ));
        saturation.setItemMeta(saturationMeta);
        potionMenu.setItem(22, saturation);

        ItemStack slowFalling = new ItemStack(Material.PHANTOM_MEMBRANE, 1);
        ItemMeta slowFallingMeta = slowFalling.getItemMeta();
        slowFallingMeta.displayName(Component.text("Slow Falling", NamedTextColor.WHITE, TextDecoration.BOLD));
        slowFallingMeta.lore(List.of(
                Component.text("Fall slowly and safely", NamedTextColor.GRAY)
        ));
        slowFalling.setItemMeta(slowFallingMeta);
        potionMenu.setItem(23, slowFalling);

        ItemStack luck = new ItemStack(Material.EMERALD, 1);
        ItemMeta luckMeta = luck.getItemMeta();
        luckMeta.displayName(Component.text("Luck", NamedTextColor.GREEN, TextDecoration.BOLD));
        luckMeta.lore(List.of(
                Component.text("Increases luck attribute", NamedTextColor.GRAY)
        ));
        luck.setItemMeta(luckMeta);
        potionMenu.setItem(24, luck);

        ItemStack glowing = new ItemStack(Material.GLOWSTONE_DUST, 1);
        ItemMeta glowingMeta = glowing.getItemMeta();
        glowingMeta.displayName(Component.text("Glowing", NamedTextColor.YELLOW, TextDecoration.BOLD));
        glowingMeta.lore(List.of(
                Component.text("Outline yourself with glow", NamedTextColor.GRAY)
        ));
        glowing.setItemMeta(glowingMeta);
        potionMenu.setItem(25, glowing);

        ItemStack clearEffects = new ItemStack(Material.BARRIER, 1);
        ItemMeta clearEffectsMeta = clearEffects.getItemMeta();
        clearEffectsMeta.displayName(Component.text("Clear All Effects", NamedTextColor.RED, TextDecoration.BOLD));
        clearEffectsMeta.lore(List.of(
                Component.text("Remove all active potion effects", NamedTextColor.GRAY)
        ));
        clearEffects.setItemMeta(clearEffectsMeta);
        potionMenu.setItem(40, clearEffects);

        fillMenu(potionMenu);
        return potionMenu;
    }

    @Execute
    public void potion(@Context Player player) {
        player.openInventory(getMenu());
    }
}