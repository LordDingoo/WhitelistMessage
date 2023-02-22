package io.github.lorddingoo.whitelistmessage.ModMessage;

import net.minecraft.server.PlayerManager;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerManager.class)
public class MixinPlayerManager {
    @Redirect(method = "checkCanJoin", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/Text;translatable(Ljava/lang/String;)Lnet/minecraft/text/MutableText;", ordinal = 0))
    public MutableText mod$redirectWhitelistText(String key) {
        String discordLink = "https://discord.gg/EPWF5A6v2K";
        MutableText discordLinkText = Text.of(discordLink).styled((style) -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, discordLink)));

        return Text.of(
                Formatting.RED, "Hello there, you aren't whitelisted yet - join the ",
                Formatting.BLUE, discordLinkText,
                Formatting.RED, " and make sure to type in your username"
        );
    }
}