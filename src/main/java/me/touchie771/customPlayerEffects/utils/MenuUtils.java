package me.touchie771.customPlayerEffects.utils;

import me.touchie771.minecraftGUI.api.SlotItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for menu operations
 */
public class MenuUtils {
    
    /**
     * Creates filler items for empty menu slots
     * @param menuSize The total size of the menu
     * @param occupiedSlots The slots that are already occupied
     * @return List of filler SlotItems
     */
    public static List<SlotItem> createFillerItems(int menuSize, int... occupiedSlots) {
        List<SlotItem> fillerItems = new ArrayList<>();
        
        for (int slot = 0; slot < menuSize; slot++) {
            boolean isOccupied = false;
            for (int occupied : occupiedSlots) {
                if (slot == occupied) {
                    isOccupied = true;
                    break;
                }
            }
            
            if (!isOccupied) {
                fillerItems.add(new SlotItem(
                    Component.empty(),
                    slot,
                    Material.GRAY_STAINED_GLASS_PANE,
                    1
                ));
            }
        }
        
        return fillerItems;
    }
}
