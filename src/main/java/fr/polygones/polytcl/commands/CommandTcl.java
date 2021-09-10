package fr.polygones.polytcl.commands;

import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandTcl<T> implements CommandExecutor{

    private T[][] map;
    private Map<String,Integer> names;

    public CommandTcl(T[][] m, Map<String,Integer> n){
        map = m;
        names = n;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (map == null){
            sender.sendMessage("The PolyTCL extension was not loaded correctly, this command is not activated");
            return true;
        }
        if (args.length < 2){
            sender.sendMessage("Not enough arguments !");
            return false;
        }
        try {
            int x = Integer.parseInt(args[0])-1;
            int y = Integer.parseInt(args[1])-1;
            sender.sendMessage(map[x][y].toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            sender.sendMessage(args[0] + " or " + args[1] + " is not a valid station number ! Please use numbers between " + 1 + " and " + map.length);
            return false;
        } catch (NumberFormatException e){
            if(names == null){
                sender.sendMessage("Using stations names is not enable, please use nembers !");
                return false;
            }
            try{
                int x = names.get(args[0])-1;
                int y = names.get(args[1])-1;
                sender.sendMessage(map[x][y].toString());
            }catch(NullPointerException ex){
                sender.sendMessage(args[0] + " or " + args[1] + " is not a valid station name !");
                return false;
            }
        }
        return true;
    }
}
