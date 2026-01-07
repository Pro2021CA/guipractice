package me.Pro2021CA.guipractice;

import io.papermc.paper.event.player.AsyncChatCommandDecorateEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
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
                SkullMeta meta = (SkullMeta) item.getItemMeta();
                meta.setOwningPlayer(players.get(i));
                item.setItemMeta(meta);
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setItemName(players.get(i).getName());
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.YELLOW + "Click to Teleport");
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                inventory.setItem(i, item);
            }
            guis.put(p.getUniqueId(), "players");
            p.openInventory(inventory);
        }
        return true;
    }
}
