package plugin.siren.Events;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import plugin.siren.ChineseFestivals;
import plugin.siren.System.SirensChineseFestivalsComponent;
import plugin.siren.Utils.SirensCFUpdateChecker;

public class PlayerReadyEventCF {
    public static void onPlayerReadyEvent(PlayerReadyEvent event){
        World world = event.getPlayer().getWorld();
        if (world == null){
            ChineseFestivals.LOGGER.atSevere().log("Most recent player failed to get get world inside PlayerReadyEvent : PlayerReadyEventCF");
        } else {
            world.execute(() -> {
                Ref<EntityStore> ref = event.getPlayerRef();
                Store<EntityStore> store = ref.getStore();

                SirensChineseFestivalsComponent sirensComponent = new SirensChineseFestivalsComponent();
                store.putComponent(ref, SirensChineseFestivalsComponent.getComponentType(), sirensComponent);

                SirensChineseFestivalsComponent sirensCFComponent = store.ensureAndGetComponent(ref, SirensChineseFestivalsComponent.getComponentType());
                if (sirensCFComponent == null) {
                    SirensCFUpdateChecker.sendUpdateMessage(null, false, SirensCFUpdateChecker.Type.Default, false);
                } else {
                    if (!sirensCFComponent.getUpdateCheckerCheck()) {
                        SirensCFUpdateChecker.sendUpdateMessage(null, false, SirensCFUpdateChecker.Type.Default, false);

                        sirensCFComponent.setCheckOnUpdateChecker(true);
                    }
                }
            });
        }
    }
}
