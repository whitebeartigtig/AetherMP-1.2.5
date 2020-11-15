package net.minecraft.server;

import net.minecraft.server.*;

public class LoadingScreenRendererTrivia extends LoadingScreenRenderer
{
    private String trivia;
    private String string1;
    private String string2;
    private long time;
    private boolean someRandomBoolean;
    private Minecraft game;
    
    public LoadingScreenRendererTrivia(final Minecraft minecraft) {
        super(minecraft);
        this.string1 = "";
        this.string2 = "";
        this.time = System.currentTimeMillis();
        this.someRandomBoolean = false;
        this.game = minecraft;
        this.trivia = "";
    }
    
    public void printText(final String s) {
        this.someRandomBoolean = false;
        this.func_597_c(s);
    }
    
    public void displaySavingString(final String s) {
        this.someRandomBoolean = true;
        this.func_597_c(this.string2);
    }
    
    public void func_597_c(final String s) {
        if (this.game.running) {
            this.string2 = s;
            if (this.string1 == "" && this.string2 == "") {
                this.trivia = "";
            }
            if (this.string2 != "" && this.trivia == "") {
                this.trivia = mod_Trivia.getNewString();
            }
            final ScaledResolution scaledresolution = new ScaledResolution(this.game.gameSettings, this.game.displayWidth, this.game.displayHeight);
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, scaledresolution.scaledWidthD, scaledresolution.scaledHeightD, 0.0, 100.0, 300.0);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -200.0f);
            return;
        }
        if (this.someRandomBoolean) {
            return;
        }
        throw new MinecraftError();
    }
    
    public void displayLoadingString(final String s) {
        if (this.game.running) {
            this.time = 0L;
            this.string1 = s;
            this.setLoadingProgress(-1);
            this.time = 0L;
            this.time = 0L;
            if (this.string1 == "" && this.string2 == "") {
                this.trivia = "";
            }
            if (this.string1 != "" && this.string2 == "" && this.trivia == "") {
                this.trivia = mod_Trivia.getNewString();
            }
            return;
        }
        if (this.someRandomBoolean) {
            return;
        }
        throw new MinecraftError();
    }
    
    public void setLoadingProgress(final int i) {
        if (!this.game.running) {
            if (this.someRandomBoolean) {
                return;
            }
            throw new MinecraftError();
        }
        else {
            final long l = System.currentTimeMillis();
            if (l - this.time < 20L) {
                return;
            }
            this.time = l;
            final ScaledResolution scaledresolution = new ScaledResolution(this.game.gameSettings, this.game.displayWidth, this.game.displayHeight);
            final int j = scaledresolution.getScaledWidth();
            final int k = scaledresolution.getScaledHeight();
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, scaledresolution.scaledWidthD, scaledresolution.scaledHeightD, 0.0, 100.0, 300.0);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -200.0f);
            GL11.glClear(16640);
            final Tessellator tessellator = Tessellator.instance;
            final int i2 = this.game.renderEngine.getTexture("/gui/background.png");
            GL11.glBindTexture(3553, i2);
            final float f = 32.0f;
            tessellator.startDrawingQuads();
            tessellator.setColorOpaque_I(4210752);
            tessellator.addVertexWithUV(0.0, (double)k, 0.0, 0.0, (double)(k / f));
            tessellator.addVertexWithUV((double)j, (double)k, 0.0, (double)(j / f), (double)(k / f));
            tessellator.addVertexWithUV((double)j, 0.0, 0.0, (double)(j / f), 0.0);
            tessellator.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.0);
            tessellator.draw();
            if (i >= 0) {
                final byte byte0 = 100;
                final byte byte2 = 2;
                final int j2 = j / 2 - byte0 / 2;
                final int k2 = k / 2 + 16;
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(8421504);
                tessellator.addVertex((double)j2, (double)k2, 0.0);
                tessellator.addVertex((double)j2, (double)(k2 + byte2), 0.0);
                tessellator.addVertex((double)(j2 + byte0), (double)(k2 + byte2), 0.0);
                tessellator.addVertex((double)(j2 + byte0), (double)k2, 0.0);
                tessellator.setColorOpaque_I(8454016);
                tessellator.addVertex((double)j2, (double)k2, 0.0);
                tessellator.addVertex((double)j2, (double)(k2 + byte2), 0.0);
                tessellator.addVertex((double)(j2 + i), (double)(k2 + byte2), 0.0);
                tessellator.addVertex((double)(j2 + i), (double)k2, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
            }
            this.game.fontRenderer.drawStringWithShadow(this.string2, (j - this.game.fontRenderer.getStringWidth(this.string2)) / 2, k / 2 - 4 - 16, 16777215);
            this.game.fontRenderer.drawStringWithShadow(this.string1, (j - this.game.fontRenderer.getStringWidth(this.string1)) / 2, k / 2 - 4 + 8, 16777215);
            this.game.fontRenderer.drawStringWithShadow(this.trivia, (j - this.game.fontRenderer.getStringWidth(this.trivia)) / 2, k - 16, 16777113);
            Display.update();
            try {
                Thread.yield();
            }
            catch (Exception ex) {}
        }
    }
}
