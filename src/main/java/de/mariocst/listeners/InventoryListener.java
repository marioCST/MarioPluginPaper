package de.mariocst.listeners;

import de.mariocst.MarioMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class InventoryListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (MarioMain.getInstance().invTroll.isEmpty()) return;

        for (Player ignored : MarioMain.getInstance().invTroll) {
            if (event.getClickedInventory() == player.getInventory()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (MarioMain.getInstance().invTroll.isEmpty()) return;

        for (Player ignored : MarioMain.getInstance().invTroll) {
            event.setCancelled(true);
            event.getItemDrop().remove();
        }
    }
}
