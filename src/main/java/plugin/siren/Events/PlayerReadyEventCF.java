package plugin.siren.Events;

import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.world.World;
import plugin.siren.ChineseFestivals;
import plugin.siren.Utils.UpdateCheckerCF;

public class PlayerReadyEventCF {
    public static void onPlayerReadyEvent(PlayerReadyEvent event){
        World world = event.getPlayer().getWorld();
        world.execute(() -> {
            Player player = event.getPlayer();

            UpdateCheckerCF.sendUpdateMessage(player);
        });
    }
}
