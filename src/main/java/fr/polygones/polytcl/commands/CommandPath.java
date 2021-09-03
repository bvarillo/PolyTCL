package fr.polygones.polytcl.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandPath<T> implements CommandExecutor{

    private T[][] map;

    public CommandPath(T[][] m){
        map = m;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (args.length < 2){
            sender.sendMessage("Not enough arguments !");
            return false;
        }
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            // System.out.println("x :" + x + ", y :" + y);
            sender.sendMessage(map[x][y].toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            sender.sendMessage(args[0] + " or " + args[1] + " is not a valid station number ! Please use numbers between " + 0 + " and " + map.length);
            return false;
        } catch (NumberFormatException e){
            sender.sendMessage(args[0] + " or " + args[1] + " is not a valid number !");
            return false;
        }
        return true;
    }
}
