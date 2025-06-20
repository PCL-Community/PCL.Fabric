package io.github.pcl_community.pcl_fabric.mixin;

import io.github.pcl_community.pcl_fabric.client.screens.PCLScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.TextIconButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/TextIconButtonWidget;setPosition(II)V"), method = "init")
    private void init(CallbackInfo ci) {
        int l = this.height / 4 + 132;

        TextIconButtonWidget pcl = this.addDrawableChild(
                TextIconButtonWidget.builder(
                        Text.empty(),
                        button -> this.client.setScreen(new PCLScreen()), true)
                        .width(20)
                        .texture(Identifier.of("pcl", "icon"), 16, 16)
                        .build()
        );
        pcl.setPosition(this.width / 2 + 128, l);
    }
}
