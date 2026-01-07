package me.Pro2021CA.guipractice;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static me.Pro2021CA.guipractice.guicommand.guis;

public class clickevent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if ("gui" == guis.get(e.getWhoClicked().getUniqueId())){
            e.setCancelled(true);
            if (e.getSlot() == 0){
                e.getWhoClicked().getWorld().spawnEntity(e.getWhoClicked().getLocation(), EntityType.LIGHTNING_BOLT);
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage("WHO DARES TAKE MY DIAMOND");
            }
            else if (e.getSlot() == 8){
                e.getWhoClicked().setGameMode(GameMode.SURVIVAL);
            }
        }else if ("players" == guis.get(e.getWhoClicked().getUniqueId())){
            e.setCancelled(true);
        }
    }
}
