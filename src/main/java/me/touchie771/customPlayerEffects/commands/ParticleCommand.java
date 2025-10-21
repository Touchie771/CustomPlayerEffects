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

@dev.rollczi.litecommands.annotations.command.Command(name = "setparticle")
@Permission("customplayereffects.particle")
public record ParticleCommand() implements Command {

    public static final @NotNull TextComponent MENU_TITLE = Component.text("Particle Effects Menu", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
    public static final int MENU_SIZE = 45;

    @Override
    public Inventory getMenu() {
        Inventory particleMenu = Bukkit.createInventory(null, MENU_SIZE, MENU_TITLE);

        ItemStack hearts = new ItemStack(Material.RED_DYE, 1);
        ItemMeta heartsMeta = hearts.getItemMeta();
        heartsMeta.displayName(Component.text("Hearts", NamedTextColor.RED, TextDecoration.BOLD));
        heartsMeta.lore(List.of(
                Component.text("Red heart particles", NamedTextColor.GRAY)
        ));
        hearts.setItemMeta(heartsMeta);
        particleMenu.setItem(10, hearts);

        ItemStack flames = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta flamesMeta = flames.getItemMeta();
        flamesMeta.displayName(Component.text("Flames", NamedTextColor.GOLD, TextDecoration.BOLD));
        flamesMeta.lore(List.of(
                Component.text("Fire particle trail", NamedTextColor.GRAY)
        ));
        flames.setItemMeta(flamesMeta);
        particleMenu.setItem(11, flames);

        ItemStack enchant = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta enchantMeta = enchant.getItemMeta();
        enchantMeta.displayName(Component.text("Enchantment", NamedTextColor.AQUA, TextDecoration.BOLD));
        enchantMeta.lore(List.of(
                Component.text("Enchantment table glyphs", NamedTextColor.GRAY)
        ));
        enchant.setItemMeta(enchantMeta);
        particleMenu.setItem(12, enchant);

        ItemStack sparkles = new ItemStack(Material.GLOWSTONE_DUST, 1);
        ItemMeta sparklesMeta = sparkles.getItemMeta();
        sparklesMeta.displayName(Component.text("Sparkles", NamedTextColor.YELLOW, TextDecoration.BOLD));
        sparklesMeta.lore(List.of(
                Component.text("Golden sparkle particles", NamedTextColor.GRAY)
        ));
        sparkles.setItemMeta(sparklesMeta);
        particleMenu.setItem(13, sparkles);

        ItemStack smoke = new ItemStack(Material.COAL, 1);
        ItemMeta smokeMeta = smoke.getItemMeta();
        smokeMeta.displayName(Component.text("Smoke", NamedTextColor.DARK_GRAY, TextDecoration.BOLD));
        smokeMeta.lore(List.of(
                Component.text("Dark smoke trail", NamedTextColor.GRAY)
        ));
        smoke.setItemMeta(smokeMeta);
        particleMenu.setItem(14, smoke);

        ItemStack portal = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta portalMeta = portal.getItemMeta();
        portalMeta.displayName(Component.text("Portal", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD));
        portalMeta.lore(List.of(
                Component.text("Portal particles", NamedTextColor.GRAY)
        ));
        portal.setItemMeta(portalMeta);
        particleMenu.setItem(15, portal);

        ItemStack notes = new ItemStack(Material.NOTE_BLOCK, 1);
        ItemMeta notesMeta = notes.getItemMeta();
        notesMeta.displayName(Component.text("Musical Notes", NamedTextColor.GREEN, TextDecoration.BOLD));
        notesMeta.lore(List.of(
                Component.text("Colorful music notes", NamedTextColor.GRAY)
        ));
        notes.setItemMeta(notesMeta);
        particleMenu.setItem(16, notes);

        ItemStack villagerHappy = new ItemStack(Material.EMERALD, 1);
        ItemMeta villagerHappyMeta = villagerHappy.getItemMeta();
        villagerHappyMeta.displayName(Component.text("Happy Villager", NamedTextColor.GREEN, TextDecoration.BOLD));
        villagerHappyMeta.lore(List.of(
                Component.text("Green happy particles", NamedTextColor.GRAY)
        ));
        villagerHappy.setItemMeta(villagerHappyMeta);
        particleMenu.setItem(19, villagerHappy);

        ItemStack cloud = new ItemStack(Material.WHITE_WOOL, 1);
        ItemMeta cloudMeta = cloud.getItemMeta();
        cloudMeta.displayName(Component.text("Cloud", NamedTextColor.WHITE, TextDecoration.BOLD));
        cloudMeta.lore(List.of(
                Component.text("White cloud puffs", NamedTextColor.GRAY)
        ));
        cloud.setItemMeta(cloudMeta);
        particleMenu.setItem(20, cloud);

        ItemStack drip = new ItemStack(Material.WATER_BUCKET, 1);
        ItemMeta dripMeta = drip.getItemMeta();
        dripMeta.displayName(Component.text("Water Drip", NamedTextColor.BLUE, TextDecoration.BOLD));
        dripMeta.lore(List.of(
                Component.text("Dripping water particles", NamedTextColor.GRAY)
        ));
        drip.setItemMeta(dripMeta);
        particleMenu.setItem(21, drip);

        ItemStack lava = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta lavaMeta = lava.getItemMeta();
        lavaMeta.displayName(Component.text("Lava Drip", NamedTextColor.GOLD, TextDecoration.BOLD));
        lavaMeta.lore(List.of(
                Component.text("Dripping lava particles", NamedTextColor.GRAY)
        ));
        lava.setItemMeta(lavaMeta);
        particleMenu.setItem(22, lava);

        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        ItemMeta totemMeta = totem.getItemMeta();
        totemMeta.displayName(Component.text("Totem", NamedTextColor.GOLD, TextDecoration.BOLD));
        totemMeta.lore(List.of(
                Component.text("Totem activation particles", NamedTextColor.GRAY)
        ));
        totem.setItemMeta(totemMeta);
        particleMenu.setItem(23, totem);

        ItemStack snowflake = new ItemStack(Material.SNOWBALL, 1);
        ItemMeta snowflakeMeta = snowflake.getItemMeta();
        snowflakeMeta.displayName(Component.text("Snowflake", NamedTextColor.WHITE, TextDecoration.BOLD));
        snowflakeMeta.lore(List.of(
                Component.text("Falling snowflake particles", NamedTextColor.GRAY)
        ));
        snowflake.setItemMeta(snowflakeMeta);
        particleMenu.setItem(24, snowflake);

        ItemStack endRod = new ItemStack(Material.END_ROD, 1);
        ItemMeta endRodMeta = endRod.getItemMeta();
        endRodMeta.displayName(Component.text("End Rod", NamedTextColor.WHITE, TextDecoration.BOLD));
        endRodMeta.lore(List.of(
                Component.text("White end rod particles", NamedTextColor.GRAY)
        ));
        endRod.setItemMeta(endRodMeta);
        particleMenu.setItem(25, endRod);

        ItemStack soul = new ItemStack(Material.SOUL_SAND, 1);
        ItemMeta soulMeta = soul.getItemMeta();
        soulMeta.displayName(Component.text("Soul", NamedTextColor.AQUA, TextDecoration.BOLD));
        soulMeta.lore(List.of(
                Component.text("Soul fire particles", NamedTextColor.GRAY)
        ));
        soul.setItemMeta(soulMeta);
        particleMenu.setItem(28, soul);

        ItemStack clearParticles = new ItemStack(Material.BARRIER, 1);
        ItemMeta clearParticlesMeta = clearParticles.getItemMeta();
        clearParticlesMeta.displayName(Component.text("Clear Particles", NamedTextColor.RED, TextDecoration.BOLD));
        clearParticlesMeta.lore(List.of(
                Component.text("Remove all particle effects", NamedTextColor.GRAY)
        ));
        clearParticles.setItemMeta(clearParticlesMeta);
        particleMenu.setItem(40, clearParticles);

        fillMenu(particleMenu);
        return particleMenu;
    }

    @Execute
    public void particle(@Context Player player) {
        player.openInventory(getMenu());
    }
}