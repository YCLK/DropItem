package io.github.yclk.dropitem;

import org.bukkit.plugin.java.JavaPlugin;

public final class DropItem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("DropItem 플러그인이 실행되었습니다!");
        getServer().getPluginManager().registerEvents(new HitListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("DropItem 플러그인이 종료되었습니다!");
    }
}