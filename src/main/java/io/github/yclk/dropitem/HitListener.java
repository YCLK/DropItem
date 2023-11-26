package io.github.yclk.dropitem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class HitListener implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            // 20%의 확률로 실행
            if (new Random().nextDouble() < 0.5) {
                dropRandomItem(player);
            }
        }
    }

    private void dropRandomItem(Player player) {
        Inventory playerInventory = player.getInventory();

        // 플레이어 인벤토리가 비어있지 않은 경우
        if (playerInventory.getSize() > 0) {
            int randomSlot = new Random().nextInt(playerInventory.getSize());

            // 랜덤한 슬롯의 아이템을 얻어옴
            ItemStack droppedItem = playerInventory.getItem(randomSlot);

            // 아이템이 존재하면 드롭 처리
            if (droppedItem != null && droppedItem.getType() != Material.AIR) {
                player.getWorld().dropItemNaturally(player.getLocation(), droppedItem);
                playerInventory.clear(randomSlot);
            }
        }
    }
}