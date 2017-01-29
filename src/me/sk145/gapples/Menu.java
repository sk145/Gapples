package me.sk145.gapples;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Spencer on 1/22/2017.
 */
public class Menu implements Listener {

    public static Main plugin;

    String title = ChatColor.AQUA + "";
    String desc = ChatColor.GRAY + "";
    String on;
    String off;
    private Inventory inv;
    private ItemStack gr; //, pn, am, dm, np, exit;

    public Menu(Plugin p) {

        inv = Bukkit.getServer().createInventory(null, 9, "Gapples: Admin Menu");

        checkB("globalGappleCrafting");
        gr = new ItemStack(Material.WORKBENCH, 1);
        ItemMeta im = gr.getItemMeta();
        im.setDisplayName("Gapple Recipe");
        im.setLore(Arrays.asList("Toggle on and off the gapple recipe.", "", on, "", off, ""));
        gr.setItemMeta(im);

        /*gr = new ItemStack(Material.WORKBENCH, 1);
        ItemMeta im = gr.getItemMeta();
        im.setDisplayName(ChatColor.RED + "Permission ");
        im.setLore(Arrays.asList("Toggle on and off the permission to craft a gapple."));
        gr.setItemMeta(im);*/


        inv.setItem(0, gr);

        /*inv.setItem(2, pn);
        inv.setItem(3, np);

        inv.setItem(5, am);
        inv.setItem(6, dm);

        inv.setItem(8, exit);*/

        Bukkit.getServer().getPluginManager().registerEvents(this, p);
    }

    public void show(Player p) {
        p.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Gapple Recipe")) {
            if (e.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList("Toggle on and off the gapple recipe.", "", ChatColor.GREEN + "on", "", ChatColor.DARK_GRAY + "off", ""))) {

            }
            e.setCancelled(true);
        }
        /*if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Survival")) {
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Adventure")) {
            e.setCancelled(true);
            e.getWhoClicked().setGameMode(GameMode.ADVENTURE);
            e.getWhoClicked().closeInventory();
        }*/
    }

    public boolean checkB(String directory) {
        if (directory.equals("globalGappleCrafting")) {
            if (!plugin.getConfig().getBoolean("globalGappleCrafting")) {
                on = ChatColor.DARK_GRAY + "";
                off = ChatColor.RED + "";
            } else {
                on = ChatColor.GREEN + "";
                off = ChatColor.DARK_GRAY + "";
            }
        }
        return true;
    }

}
