package fr.endide.hardcore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class hcListener implements Listener {
    private final HardCore plugin;
    public hcListener(HardCore plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerDeath(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if(plugin.players.contains(player)){
            for (Material bannedItem : plugin.bannedItems) {
                if (item.getType().equals(bannedItem)) {
                    player.sendMessage(ChatColor.RED + "Sale monstre, tuez des animaux pour les manger, RAPELLE-TOI tu est VEGAN");
                    player.setHealth(0);
                }
            }
        }
    }

}

