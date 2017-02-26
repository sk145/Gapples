package me.sk145.gapples;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Spencer on 1/19/2017.
 */
public class Commands implements CommandExecutor {

    public static Main plugin;

    public Commands(Main instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("gapples")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Gapples - by sk145 \n 'Gapples' commands cannot be used in console.");
                return true;
            }

            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage(ChatColor.GOLD + "Gapples - by sk145");
                p.sendMessage("/gapples craft");
                return true;
            } else {

                if (args[0].equalsIgnoreCase("craft")) {
                    if (plugin.checkBoolean("developerMode")) {
                        p.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 8));
                        p.getInventory().addItem(new ItemStack(Material.APPLE));
                        p.openWorkbench(p.getLocation(), true);
                        return true;
                    } else {
                        p.sendMessage(ChatColor.RED + "Developer mode is not enabled!");
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
