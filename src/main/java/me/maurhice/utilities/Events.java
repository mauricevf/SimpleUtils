package me.maurhice.utilities;

import me.maurhice.utilities.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.EnderChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Events implements Listener {
    private ArrayList<Player> vanished = new ArrayList<Player>();

    @EventHandler
    public void Click(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Staff Menu")) {

            switch (e.getCurrentItem().getType()) {
                case FEATHER:
                    if (player.isOp()) {
                        if (player.getAllowFlight() == false) {
                            player.setAllowFlight(true);
                            e.getCurrentItem().setType(Material.DIRT);
                            player.sendMessage(utils.chat("&aFlight has been Enabled"));
                        } else {
                            player.setAllowFlight(false);
                            e.getCurrentItem().setType(Material.FEATHER);
                            player.sendMessage(utils.chat("&cFlight has been disabled"));
                        }
                        player.closeInventory();
                    }
                    break;
                case GHAST_TEAR:
                    if (!vanished.contains(player)) {
                        for(Player online:Bukkit.getOnlinePlayers()){
                                online.hidePlayer(player);
                                player.sendMessage(utils.chat("&aJe bent in vanish gegaan!"));
                                vanished.add(player);
                                e.getCurrentItem().setType(Material.ENDER_PEARL);
                                player.updateInventory();

                        }

                    } else if(vanished.contains(player)) {
                        for(Player online:Bukkit.getOnlinePlayers()){
                            online.showPlayer(player);
                            player.sendMessage(utils.chat("&bJe bent uit vanish gegaan!"));
                            e.getCurrentItem().setType(Material.GHAST_TEAR);
                            vanished.remove(player);
                            player.updateInventory();
                        }
                    }
                    player.closeInventory();
                    break;
                case WORKBENCH:
                    Inventory Crafting = Bukkit.createInventory(player, InventoryType.WORKBENCH, ChatColor.BLUE + "Crafting Table");
                    player.openInventory(Crafting);
                    break;

                case ENDER_CHEST:
                    Inventory EC = Bukkit.createInventory(player, InventoryType.ENDER_CHEST, ChatColor.BLUE + "Prullenbak");
                    player.openInventory(EC);
                    break;






            }
           e.setCancelled(true);
        }

    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        for (Player player : vanished) {
            e.getPlayer().hidePlayer(player);
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        vanished.remove(e.getPlayer());
        }
    }



