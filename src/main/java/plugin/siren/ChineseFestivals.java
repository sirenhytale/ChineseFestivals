package plugin.siren;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import plugin.siren.Utils.HStats;

import javax.annotation.Nonnull;

public class ChineseFestivals extends JavaPlugin {
    private static final String VERSION = "0.1.0";
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

        LOGGER.atInfo().log("Version " + VERSION + " of Chinese Festivals has successfully loaded.");
        if(ifDebug()){
            LOGGER.atInfo().log("= =- -=- -=- -=- -=- -=- -=- -=- -=- -=- -= =");
            LOGGER.atInfo().log("Loaded Chinese Festivals in Debug mode.");
        }
        LOGGER.atInfo().log("===---==---==---==---==---==---==---==---==---==---===");
    }

    @Override
    protected void shutdown(){
        LOGGER.atInfo().log("===---==---==---== CHINESE FESTIVALS ==---==---==---===");
        LOGGER.atInfo().log("Mermaids has began to shutdown.");
        LOGGER.atInfo().log("Saving any necessary data.");
        LOGGER.atInfo().log("Version " + VERSION + " of Chinese Festivals has successfully shutdown.");
        LOGGER.atInfo().log("===---==---==---==---==---==---==---==---==---==---===");
    }

    public static ChineseFestivals get(){
        return plugin;
    }

    public static boolean ifDebug(){
        return DEBUG;
    }
}
