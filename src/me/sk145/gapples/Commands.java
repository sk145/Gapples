package me.sk145.gapples;

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

        Player p = (Player) sender;

        if (label.equalsIgnoreCase("gapples")) {
            if (!(p instanceof Player)) {
                sender.sendMessage("Gapples - By sk145");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("Gapples - By sk145");
                p.sendMessage("/gapples admin");
                p.sendMessage("/gapples craft");
                return true;
            } else {
                if (args[0].equalsIgnoreCase("craft")) {
                    if (plugin.checkBoolean("developerMode")) {
                        p.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 8));
                        p.getInventory().addItem(new ItemStack(Material.APPLE));
                        p.getInventory().addItem(new ItemStack(Material.WORKBENCH, 1));
                        p.openWorkbench(p.getLocation(), true);
                        return true;
                    } else {
                        p.sendMessage("Developer mode is not enabled!");
                        return true;
                    }
                }
                if (args[0].equalsIgnoreCase("admin")) {
                    if (plugin.checkBoolean("adminMode")) {
                        plugin.menu.show(p);
                        return true;
                    } else {
                        p.sendMessage("Admin mode is not enabled!");
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
