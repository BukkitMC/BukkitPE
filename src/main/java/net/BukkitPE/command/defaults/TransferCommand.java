package net.BukkitPE.command.defaults;

import net.BukkitPE.command.CommandSender;
import net.BukkitPE.lang.TranslationContainer;
import net.BukkitPE.Player;

public class TransferCommand extends VanillaCommand{
    public TransferCommand(String name) {
        super(name, "Transfer to another server", "/transfer <address> <port>");
        this.setPermission("BukkitPE.command.transfer");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", usageMessage));
            return true;
        }

        String address = args[0].toLowerCase();
        int port = Integer.parseInt(args[1]);

        Player player = sender.getServer().getPlayer(sender.getName());
        player.transfer(address, port);

        return true;
    }
}

