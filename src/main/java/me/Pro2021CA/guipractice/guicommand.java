package me.Pro2021CA.guipractice;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.DoubleChest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

public class guicommand implements CommandExecutor {
    public static final HashMap<UUID, String> guis = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p) {
            Inventory inventory = Bukkit.createInventory(null, 9, "practice thing");
            inventory.setItem(0, new ItemStack(Material.DIAMOND));
            ItemStack itemStack = new ItemStack(Material.GRASS_BLOCK);
            inventory.setItem(8, itemStack);
            //itemStack.getItemMeta().setItemName("Go survival mode"); not working
            guis.put(p.getUniqueId(), "gui");
            p.openInventory(inventory);
        }
        return true;
    }
}
