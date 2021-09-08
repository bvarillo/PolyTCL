package fr.polygones.polytcl.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandTcl<T> implements CommandExecutor{

    private T[][] map;

    public CommandTcl(T[][] m){
        map = m;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (map == null){
            sender.sendMessage("The PolyTcl extension was not loaded correctly, this command is not activated");
            return true;
        }
        if (args.length < 2){
            sender.sendMessage("Not enough arguments !");
            return false;
        }
        try {
            int x = Integer.parseInt(args[0])-1;
            int y = Integer.parseInt(args[1])-1;
            // System.out.println("x :" + x + ", y :" + y);
            sender.sendMessage(map[x][y].toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            sender.sendMessage(args[0] + " or " + args[1] + " is not a valid station number ! Please use numbers between " + 1 + " and " + map.length);
            return false;
        } catch (NumberFormatException e){
            sender.sendMessage(args[0] + " or " + args[1] + " is not a valid number !");
            return false;
        }
        return true;
    }
}
