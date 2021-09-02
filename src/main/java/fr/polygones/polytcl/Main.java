package fr.polygones.polytcl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.print.event.PrintEvent;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import fr.polygones.polytcl.command.CommandHelloPoly;
import fr.polygones.polytcl.utils.CsvParser;

/**
 * Hello world!
 *
 */
public class Main extends JavaPlugin
{
    private FileConfiguration config = getConfig();

    @Override
    public void onEnable(){
        
        config.addDefault("mapPath","plugins/PolyTCL/map.csv");
        config.addDefault("separator", ",");
        config.options().copyDefaults(true);
        saveConfig();

        getLogger().info("mapPath : "+config.getString("mapPath"));
        getLogger().info("separator : "+config.getString("separator"));

        try {
            Integer[][] map = CsvParser.parseIntergerMatrix(config.getString("mapPath"), config.getString("separator"));
            getLogger().info(Arrays.deepToString(map));
        } catch (IOException e){
            getLogger().severe("Pb reading map");
        }

        this.getCommand("helloPoly").setExecutor(new CommandHelloPoly());
    }

    @Override
    public void onDisable(){
        System.out.println("Goodbye from polygones.testspigot");
    }
}
