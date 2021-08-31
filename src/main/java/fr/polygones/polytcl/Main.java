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
        this.getCommand("helloPoly").setExecutor(new CommandHelloPoly());

        config.addDefault("mapPath","");
        config.options().copyDefaults(true);
        saveConfig();
        getLogger().info("mapPath : "+config.getString("mapPath"));
        try {
            Integer[][] map = CsvParser.parseIntergerMatrix(config.getString("mapPath"), "\t");
            System.out.println(map[0][0]);
        } catch (IOException e){
            getLogger().severe("Pb reading file");
        }
        getLogger().info("fr.polygones.testspigot loaded");
    }

    @Override
    public void onDisable(){
        System.out.println("Goodbye from polygones.testspigot");
    }
}
