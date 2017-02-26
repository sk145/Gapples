package me.sk145.gapples;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Spencer on 1/16/2017.
 */

@SuppressWarnings("deprecation")
public class Main extends JavaPlugin{

    public ShapedRecipe goldenApple = new ShapedRecipe(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));

    @Override
    public void onEnable(){
        this.saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new CraftingListener(this), this);
        this.getCommand("gapples").setExecutor(new Commands(this));

        getLogger().info(getDescription().getName() + " has been enabled!");

        setupRecipe();

    }

    public void onDisable()
    {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public void setupRecipe() {
        goldenApple.shape("xxx", "xyx", "xxx");
        goldenApple.setIngredient('x', Material.GOLD_BLOCK);
        goldenApple.setIngredient('y', Material.APPLE);
        this.getServer().addRecipe(goldenApple);
    }

    public boolean checkBoolean(String directory) {
        return getConfig().getBoolean(directory);
    }
}
