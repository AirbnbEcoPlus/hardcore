package fr.endide.hardcore;

import fr.endide.hardcore.commands.hcCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class HardCore extends JavaPlugin {
    public List<Player> players = new ArrayList<Player>();
    public List<Material> bannedItems = new ArrayList<Material>();
    @Override
    public void onEnable() {
        System.out.println("HardCore est en train d'etre activer");
        saveDefaultConfig();
        getCommand("hc").setExecutor(new hcCommand(this));
        getServer().getPluginManager().registerEvents(new hcListener(this), this);
        addBannedItem();
    }
    @Override
    public void onDisable() {
        System.out.println("Merci d'avoir utilise le plugin HardCore");
    }
    public void addBannedItem(){
        bannedItems.add(Material.PORKCHOP);
        bannedItems.add(Material.BEEF);
        bannedItems.add(Material.CHICKEN);
        bannedItems.add(Material.MUTTON);
        bannedItems.add(Material.RABBIT);
        bannedItems.add(Material.COOKED_BEEF);
        bannedItems.add(Material.COOKED_CHICKEN);
        bannedItems.add(Material.COOKED_MUTTON);
        bannedItems.add(Material.COOKED_RABBIT);
        bannedItems.add(Material.COOKED_PORKCHOP);
        bannedItems.add(Material.RABBIT_STEW);
    }
}
