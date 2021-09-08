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

import fr.polygones.polytcl.commands.CommandHelloPoly;
import fr.polygones.polytcl.commands.CommandTcl;
import fr.polygones.polytcl.utils.CsvParser;



public class Main extends JavaPlugin
{
    private FileConfiguration config = getConfig();

    @Override
    public void onEnable(){
        
        config.addDefault("mapFile","map.csv");
        config.addDefault("separator", ",");
        config.options().copyDefaults(true);
        saveConfig();


        getCommand("helloPoly").setExecutor(new CommandHelloPoly());


        getLogger().fine("mapFile : "+config.getString("mapFile"));
        getLogger().fine("separator : "+config.getString("separator"));

        Integer[][] map = null;
        String mapPath = getDataFolder().toPath() + File.separator + config.getString("mapFile");
        try {
            map = CsvParser.parseIntergerMatrix(mapPath, config.getString("separator"));
            getLogger().fine(Arrays.deepToString(map));

            if(map.length != map[0].length){
                getLogger().severe("The given map is not a valid (square) map !\nThe /tcl command will not be enabled.");
                getCommand("tcl").setExecutor(new CommandTcl(null));
            } else {
                getLogger().info("Map loaded with " + map.length + " stations");
                getCommand("tcl").setExecutor(new CommandTcl(map));
            }
        } catch (IOException e){
            getLogger().severe("Pb reading map in file : " + mapPath);
            getCommand("tcl").setExecutor(new CommandTcl(null));
        }

        
    }

    @Override
    public void onDisable(){
        System.out.println("Goodbye from fr.polygones.polytcl");
    }
}
