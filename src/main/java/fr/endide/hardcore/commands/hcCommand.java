package fr.endide.hardcore.commands;

import fr.endide.hardcore.HardCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hcCommand implements CommandExecutor {
    HardCore plugin;
    public hcCommand(HardCore hardCore) {
        this.plugin = hardCore;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage(ChatColor.DARK_GREEN + "/hc on " + ChatColor.GRAY + "(Pour activer le mode de HardCore)");
            player.sendMessage(ChatColor.DARK_GREEN + "/hc off " + ChatColor.GRAY + "(Pour desactiver le mode de HardCore)");

        }else{
            if(args[0].equalsIgnoreCase("on")){
                if(plugin.players.contains(player)){
                    player.sendMessage(ChatColor.RED + "Vous avez deja activer le mode de HardCore");
                }else{
                    plugin.players.add(player);
                    player.sendMessage(ChatColor.GREEN + "Vous avez activer le mode de HardCore");
                }
            }else if(args[0].equalsIgnoreCase("off")){
                if(plugin.players.contains(player)){
                    plugin.players.remove(player);
                    player.sendMessage(ChatColor.GREEN + "Vous avez desactiver le mode de HardCore");
                }else{
                    player.sendMessage(ChatColor.RED + "Vous avez deja desactiver le mode de HardCore");
                }
            }
        }
        return false;
    }
}
