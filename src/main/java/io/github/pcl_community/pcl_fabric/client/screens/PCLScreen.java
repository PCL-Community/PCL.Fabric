package io.github.pcl_community.pcl_fabric.client.screens;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class PCLScreen extends Screen {
    public PCLScreen() {
        super(Text.of("Plain Craft Launcher II"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        int x = this.width / 4;
        int y = this.height / 4;
        int width = this.width / 2;
        int height = this.height / 2;
        int x1 = x + width;
        int y2 = y + height;
        context.fill(x, y, x1, y2, 0xFFCBE1F8);
        this.renderTitleBar(context, x, y, width, height);
        this.renderLeftTab(context, x, y, width, height);
    }

    private void renderTitleBar(DrawContext context, int x, int y, int width, int height) {
        assert this.client != null;
        TextRenderer textRenderer = this.client.textRenderer;

        int titlebarHeight = height / 8;
        context.fill(x, y, x + width, y + titlebarHeight, 0xFF116ECC);
        int padding = (int) Math.round((titlebarHeight - textRenderer.fontHeight) / 2.0);
        context.drawText(textRenderer, "PCL", x + padding, y + padding, 0xFFFFFFFF, false);
    }

    private void renderLeftTab(DrawContext context, int x, int y, int width, int height) {
        y += height / 8;
        height -= height / 8;
        int leftTabWidth = (int) Math.round(width * 0.37);
        context.fill(x, y, x + leftTabWidth, y + height, 0xFFFFFFFF);
    }
}
