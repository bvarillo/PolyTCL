package fr.polygones.polytcl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import fr.polygones.polytcl.commands.CommandHelloPoly;
import fr.polygones.polytcl.commands.CommandTcl;
import fr.polygones.polytcl.utils.CsvParser;



public class Main extends JavaPlugin
{
    private FileConfiguration config = getConfig();
    private String path = getDataFolder().toPath() + File.separator;

    @Override
    public void onEnable(){
        
        config.addDefault("mapFile","map.csv");
        config.addDefault("separator", ",");
        config.addDefault("namesFile","names.csv");
        config.options().copyDefaults(true);
        saveConfig();


        getCommand("helloPoly").setExecutor(new CommandHelloPoly());


        getLogger().fine("mapFile : "+config.getString("mapFile"));
        getLogger().fine("separator : "+config.getString("separator"));

        Integer[][] map = null;
        String mapPath = path + config.getString("mapFile");
        try {
            map = CsvParser.parseIntergerMatrix(mapPath, config.getString("separator"));
            getLogger().fine(Arrays.deepToString(map));

            if(map.length != map[0].length){
                getLogger().severe("The given map is not a valid (square) map !\nThe /tcl command will not be enabled.");
                map = null;
            } else {
                getLogger().info("Map loaded with " + map.length + " stations");
            }
        } catch (IOException e){
            getLogger().severe("Pb reading map in file : " + mapPath);
            map = null;
        }


        String namesPath = path + config.getString("namesFile");

        Map<String, Integer> names=null;
        try {
            names = CsvParser.parseStringIntegerMap(namesPath);
        } catch (IOException e) {
            getLogger().severe("Pb reading names' file, using station' names will not be possible");
        }
        getCommand("tcl").setExecutor(new CommandTcl(map, names));
        
    }

    @Override
    public void onDisable(){
        System.out.println("Goodbye from fr.polygones.polytcl");
    }
}
