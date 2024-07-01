package com.ashkiano.custommodeldatamanager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;

public class SetCustomModelDataCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("custommodeldata.set")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /setcustommodeldata <data>");
            return true;
        }

        int customModelData;
        try {
            customModelData = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + "Invalid number.");
            return true;
        }

        ItemStack item = player.getInventory().getItemInMainHand();
        if (item == null) {
            player.sendMessage(ChatColor.RED + "You are not holding any item.");
            return true;
        }

        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            player.sendMessage(ChatColor.RED + "Item meta is null.");
            return true;
        }

        meta.setCustomModelData(customModelData);
        item.setItemMeta(meta);

        player.sendMessage(ChatColor.GREEN + "Custom model data set to " + customModelData + ".");
        return true;
    }
}