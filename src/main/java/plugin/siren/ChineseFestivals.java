package plugin.siren;

import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.event.EventRegistration;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.world.events.AllWorldsLoadedEvent;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import plugin.siren.Events.AllWorldsLoadedEventCF;
import plugin.siren.Events.PlayerReadyEventCF;
import plugin.siren.System.SirensChineseFestivalsComponent;
import plugin.siren.Utils.HStats;
import plugin.siren.Utils.SirensCFUpdateChecker;

import javax.annotation.Nonnull;

public class ChineseFestivals extends JavaPlugin {
    private static final String VERSION = "0.1.3";
    private static final boolean DEBUG = false;

    private static ChineseFestivals plugin;
    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private ComponentType<EntityStore, SirensChineseFestivalsComponent> sirensChineseFestivalsComponent;

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

        EventRegistration<Void, AllWorldsLoadedEvent> allWorldsLoadedEventRegistration = this.getEventRegistry().registerGlobal(AllWorldsLoadedEvent.class, AllWorldsLoadedEventCF::onAllWorldsLoaded);
        if(allWorldsLoadedEventRegistration != null && allWorldsLoadedEventRegistration.isRegistered()) {
            LOGGER.atInfo().log("Registered All Worlds Loaded Event.");
        }else{
            LOGGER.atSevere().log("Failed to register All Worlds Loaded Event.");
        }

        this.sirensChineseFestivalsComponent = this.getEntityStoreRegistry().registerComponent(SirensChineseFestivalsComponent.class, SirensChineseFestivalsComponent::new);
        if(this.sirensChineseFestivalsComponent != null) {
            LOGGER.atInfo().log("Registered Siren's Chinese Festivals Component.");
        }else{
            LOGGER.atInfo().log("Failed to register Siren's Chinese Festivals Component.");
        }

        LOGGER.atInfo().log("Version " + VERSION + " of Chinese Festivals has successfully loaded.");

        if(ifDebug()){
            LOGGER.atInfo().log("= =- -=- -=- -=- -=- -=- -=- -=- -=- -=- -= =");
            LOGGER.atInfo().log("Loaded Chinese Festivals in Debug mode.");
        }

        SirensCFUpdateChecker.sendUpdateMessage(SirensCFUpdateChecker.Type.StartUp);

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

    public ComponentType<EntityStore, SirensChineseFestivalsComponent> getSirensChineseFestivalsComponentType(){
        return sirensChineseFestivalsComponent;
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
