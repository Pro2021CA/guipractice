package me.Pro2021CA.guipractice;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static me.Pro2021CA.guipractice.guicommand.guis;

public class playerscommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p){
            Inventory inventory = Bukkit.createInventory(null, 54, "online players");
            List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
            for (int i = 0; i < players.size(); i++){
                ItemStack item = new ItemStack(Material.PLAYER_HEAD);
                ItemMeta meta = item.getItemMeta();
                meta.setItemName(players.get(i).getName());
                item.setItemMeta(meta);
                inventory.setItem(i, item);
            }
            guis.put(p.getUniqueId(), "players");
            p.openInventory(inventory);
        }
        return true;
    }
}
