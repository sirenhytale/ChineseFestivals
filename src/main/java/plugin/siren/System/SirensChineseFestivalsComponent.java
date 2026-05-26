package plugin.siren.System;

import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import plugin.siren.ChineseFestivals;

import javax.annotation.Nullable;

public class SirensChineseFestivalsComponent implements Component<EntityStore> {

    private boolean updateChecker;

    public static ComponentType<EntityStore, SirensChineseFestivalsComponent> getComponentType(){
        return ChineseFestivals.get().getSirensChineseFestivalsComponentType();
    }

    public SirensChineseFestivalsComponent(){
        this.updateChecker = false;
    }

    public SirensChineseFestivalsComponent(SirensChineseFestivalsComponent other){
        this.updateChecker = other.updateChecker;
    }

    @Nullable
    @Override
    public Component<EntityStore> clone() {
        return new SirensChineseFestivalsComponent(this);
    }

    public boolean getUpdateCheckerCheck(){
        return this.updateChecker;
    }

    public void setCheckOnUpdateChecker(boolean checked){
        this.updateChecker = checked;
    }
}
