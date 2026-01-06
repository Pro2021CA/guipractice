package me.Pro2021CA.guipractice;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

import static me.Pro2021CA.guipractice.guicommand.guis;

public class openevent implements Listener {
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e){
        guis.put(e.getPlayer().getUniqueId(), e.getInventory());
    }
}
