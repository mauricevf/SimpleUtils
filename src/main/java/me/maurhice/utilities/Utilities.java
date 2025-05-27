package me.maurhice.utilities;

import me.maurhice.utilities.utils.utils;
import org.bukkit.BanEntry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class Utilities extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("StaffMenu")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("SimpleUtils.Staff") || player.isOp()){
                    Inventory Staff = Bukkit.createInventory(player, 63, ChatColor.LIGHT_PURPLE + "Staff Menu");

                    ItemStack StaffInfo = new ItemStack(Material.SKULL_ITEM,1,(short) 3);
                    ItemStack Vanish = new ItemStack(Material.GHAST_TEAR);
                    ItemStack Craft = new ItemStack(Material.WORKBENCH);
                    ItemStack Flymode = new ItemStack(Material.FEATHER);
                    ItemStack EnderChest = new ItemStack(Material.ENDER_CHEST);
                    ItemStack Creator = new ItemStack(Material.RECORD_3);
                    ItemStack Vul3 = new ItemStack(Material.AIR);
                    ItemStack Vul = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                    ItemStack Vul1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemStack Vul2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                    ItemMeta Fly_meta = Flymode.getItemMeta();
                    Fly_meta.setDisplayName(ChatColor.DARK_PURPLE + "Fly");
                    Fly_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    ArrayList<String> Fly_lore = new ArrayList<>();
                    Fly_lore.add(ChatColor.LIGHT_PURPLE + "Turn on Flight");
                    Fly_meta.setLore(Fly_lore);
                    Flymode.setItemMeta(Fly_meta);

                    ItemMeta Vanish_meta = Vanish.getItemMeta();
                    Vanish_meta.setDisplayName(ChatColor.DARK_PURPLE + "Vanish");
                    Vanish_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    ArrayList<String> Vanish_lore = new ArrayList<>();
                    Vanish_lore.add(ChatColor.LIGHT_PURPLE + "Turn on Vanish");
                    Vanish_meta.setLore(Vanish_lore);
                    Vanish.setItemMeta(Vanish_meta);

                    ItemMeta Craft_Meta = Craft.getItemMeta();
                    Craft_Meta.setDisplayName(ChatColor.DARK_PURPLE + "Crafting Table");
                    Craft_Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    ArrayList<String> Craft_lore = new ArrayList<>();
                    Craft_lore.add(ChatColor.LIGHT_PURPLE + "Open workbench");
                    Craft_Meta.setLore(Craft_lore);
                    Craft.setItemMeta(Craft_Meta);

                    ItemMeta EC_Meta = EnderChest.getItemMeta();
                    EC_Meta.setDisplayName(ChatColor.DARK_PURPLE + "Trash Can");
                    EC_Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    ArrayList<String> ec_lore = new ArrayList<>();
                    ec_lore.add(ChatColor.LIGHT_PURPLE + "Open your trashcan");
                    EC_Meta.setLore(ec_lore);
                    EnderChest.setItemMeta(EC_Meta);

                    ItemMeta Creator_Meta = Creator.getItemMeta();
                    Creator_Meta.setDisplayName(utils.chat("&3Plugin made by: &bMaurijst and Kuro"));
                    Creator_Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    Creator.setItemMeta(Creator_Meta);

                    SkullMeta Staff_meta = (SkullMeta) StaffInfo.getItemMeta();
                    Staff_meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString(String.valueOf(player.getUniqueId()))));
                    Staff_meta.setDisplayName(ChatColor.DARK_PURPLE + "Player info:");
                    ArrayList<String> Staff_lore = new ArrayList<String>();
                    Staff_lore.add(utils.chat("&dName:&f" + " " + player.getName()));
                    Staff_lore.add(utils.chat("&dHealth:&f" + " " + player.getHealth()));
                    Staff_lore.add(utils.chat("&dWorld:&f" + " " + player.getWorld().getName()));
                    Staff_meta.setLore(Staff_lore);
                    StaffInfo.setItemMeta(Staff_meta);

                    ItemStack[] staff_items = {Vul,Vul,Vul,Vul1,Vul2,Vul1,Vul,Vul,Vul,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vanish, Vul3, Vul3, Craft, Vul3, Vul3,Flymode,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,EnderChest,Vul3,Vul3,Creator,Vul3,Vul3, StaffInfo, Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3,Vul3, Vul3, Vul,Vul,Vul,Vul1,Vul2,Vul1,Vul,Vul,Vul};
                    Staff.setContents(staff_items);
                    player.openInventory(Staff);
                }

                    }


                }


        return false;
            }

        }







