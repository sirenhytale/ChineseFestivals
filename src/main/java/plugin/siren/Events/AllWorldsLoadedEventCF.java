package plugin.siren.Events;

import com.hypixel.hytale.server.core.HytaleServer;
import com.hypixel.hytale.server.core.universe.world.events.AllWorldsLoadedEvent;
import plugin.siren.Utils.SirensCFUpdateChecker;

import java.util.concurrent.TimeUnit;

public class AllWorldsLoadedEventCF {
    public static void onAllWorldsLoaded(AllWorldsLoadedEvent event){
        //SirensCFUpdateChecker
        Runnable updateCheckRunnable = new Runnable() {
            @Override
            public void run() {
                SirensCFUpdateChecker.sendUpdateMessage(true);
            }
        };

        HytaleServer.SCHEDULED_EXECUTOR.scheduleAtFixedRate(updateCheckRunnable, 3, 60*60, TimeUnit.SECONDS);
    }
}
