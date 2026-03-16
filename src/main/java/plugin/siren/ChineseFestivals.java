package plugin.siren;

import com.hypixel.hytale.event.EventRegistration;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.HytaleServer;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import plugin.siren.Events.PlayerReadyEventCF;
import plugin.siren.Utils.HStats;
import plugin.siren.Utils.UpdateChecker;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

public class ChineseFestivals extends JavaPlugin {
    private static final String VERSION = "0.1.1";
    private static final boolean DEBUG = false;

    private static ChineseFestivals plugin;
    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public ChineseFestivals(@Nonnull JavaPluginInit init){
        super(init);

        plugin = this;

        new HStats("2e5a99a8-e8ca-4750-b4f8-cd695a34d762", VERSION);
    }

    @Override
    protected void setup(){
        LOGGER.atInfo().log("===---==---==---== CHINESE FESTIVALS ==---==---==---===");
        LOGGER.atInfo().log("Chinese Festivals has began to load.");

        EventRegistration<String, PlayerReadyEvent> playerReadyEventRegistration = this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, PlayerReadyEventCF::onPlayerReadyEvent);
        if(playerReadyEventRegistration != null && playerReadyEventRegistration.isRegistered()) {
            LOGGER.atInfo().log("Registered Player Ready Event.");
        }else{
            LOGGER.atSevere().log("Failed to register Player Ready Event.");
        }

        LOGGER.atInfo().log("Version " + VERSION + " of Chinese Festivals has successfully loaded.");

        if(ifDebug()){
            LOGGER.atInfo().log("= =- -=- -=- -=- -=- -=- -=- -=- -=- -=- -= =");
            LOGGER.atInfo().log("Loaded Chinese Festivals in Debug mode.");
        }

        String recentVersion = UpdateChecker.checkForUpdate();
        if(!ChineseFestivals.getVersion().equalsIgnoreCase(recentVersion)){
            LOGGER.atInfo().log("= =- -=- -=- -=- -=- -=- -=- -=- -=- -=- -= =");
            String versionMessage = "The Chinese Festivals Mod version is outdated, Chinese Festivals has released v" + recentVersion +".";
            ChineseFestivals.LOGGER.atInfo().log(versionMessage);

            Runnable updateCheckRunnable = new Runnable() {
                @Override
                public void run() {
                    LOGGER.atInfo().log(versionMessage);
                }
            };
            HytaleServer.SCHEDULED_EXECUTOR.schedule(updateCheckRunnable,15, TimeUnit.SECONDS);
        }
        LOGGER.atInfo().log("===---==---==---==---==---==---==---==---==---==---===");
    }

    @Override
    protected void shutdown(){
        LOGGER.atInfo().log("===---==---==---== CHINESE FESTIVALS ==---==---==---===");
        LOGGER.atInfo().log("Chinese Festivals has began to shutdown.");
        LOGGER.atInfo().log("Saving any necessary data.");
        LOGGER.atInfo().log("Version " + VERSION + " of Chinese Festivals has successfully shutdown.");
        LOGGER.atInfo().log("===---==---==---==---==---==---==---==---==---==---===");
    }

    public static ChineseFestivals get(){
        return plugin;
    }

    public static String getVersion(){
        return VERSION;
    }

    public static boolean ifDebug(){
        return DEBUG;
    }
}
