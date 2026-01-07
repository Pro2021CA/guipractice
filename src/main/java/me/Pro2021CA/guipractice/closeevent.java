package me.Pro2021CA.guipractice;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import static me.Pro2021CA.guipractice.guicommand.guis;

public class closeevent implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        if (guis.get(e.getPlayer().getUniqueId()) != null) {
            guis.remove(e.getPlayer().getUniqueId());
        }
    }
}
