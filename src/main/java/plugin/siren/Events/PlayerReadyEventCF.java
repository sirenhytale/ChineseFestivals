package plugin.siren.Events;

import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.world.World;
import plugin.siren.ChineseFestivals;
import plugin.siren.Utils.UpdateChecker;

public class PlayerReadyEventCF {
    public static void onPlayerReadyEvent(PlayerReadyEvent event){
        World world = event.getPlayer().getWorld();
        world.execute(() -> {
            Player player = event.getPlayer();

            String recentVersion = UpdateChecker.checkForUpdate();
            if(!ChineseFestivals.getVersion().equalsIgnoreCase(recentVersion)){
                String versionMessage = "The Chinese Festivals Mod version is outdated, Chinese Festivals has released v" + recentVersion +".";
                ChineseFestivals.LOGGER.atInfo().log(versionMessage);
                /*if(player.hasPermission("*")){
                    player.sendMessage(Message.raw(versionMessage).color(Color.RED));
                }*/
            }
        });
    }
}
