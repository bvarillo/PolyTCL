package fr.polygones.polytcl.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHelloPoly implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        sender.sendMessage("Hello " + sender.getName() + " from PolyGones' testspigot plugin");
        return true;
    }
}
