package me.sk145.gapples;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;

/**
 * Created by Spencer on 1/19/2017.
 */
public class CraftingListener implements Listener{

    public static Main plugin;

   public CraftingListener(Main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void preCraft(PrepareItemCraftEvent e) // Triggered after placing ingredients.
    {
        HumanEntity p = e.getView().getPlayer();
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);

        if (p instanceof Player) {
            if (e.getRecipe().getResult().equals(gapple)) {

                if (!plugin.checkBoolean("globalGappleCrafting"))
                {
                    e.getInventory().setResult(null);
                    return;
                }
                if (plugin.checkBoolean("globalGappleCrafting"))
                {

                    if (!p.hasPermission("gapples.craft"))
                    {
                        if (plugin.checkBoolean("permissions.craftPermNeeded")) {
                            e.getInventory().setResult(null);
                            if (plugin.checkBoolean("permissions.useDefaultMsg")) {
                                p.sendMessage(ChatColor.DARK_RED + "You do not have permission to craft that item.");
                                return;
                            }
                            else {
                                p.sendMessage(noCraftPerm("p.getName()"));
                            }
                        }
                        else if (!plugin.checkBoolean("permissions.craftPermNeeded"))
                        {
                            return;
                        }
                    }
                }
            }
        }
    }

    public String noCraftPerm(String name) {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("permissions.customMsg").replaceAll("%player%", name));
    }
}
