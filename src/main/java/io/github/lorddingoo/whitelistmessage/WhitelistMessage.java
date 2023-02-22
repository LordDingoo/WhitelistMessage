package io.github.lorddingoo.whitelistmessage;

import io.github.lorddingoo.whitelistmessage.ModMessage.MixinPlayerManager;
import net.fabricmc.api.ModInitializer;

public class WhitelistMessage implements ModInitializer {
    @Override
    public void onInitialize() {

        new MixinPlayerManager();
    }
}
