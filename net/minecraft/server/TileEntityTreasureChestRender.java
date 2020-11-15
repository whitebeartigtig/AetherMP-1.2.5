package net.minecraft.server;

public class TileEntityTreasureChestRender extends TileEntityChestRenderer
{
    private ModelChest chestModel;
    private ModelChest largeChestModel;
    
    public TileEntityTreasureChestRender() {
        this.chestModel = new ModelChest();
        this.largeChestModel = (ModelChest)new ModelLargeChest();
    }
    
    public void renderTileEntityAt(final TileEntity tileentity, final double d, final double d1, final double d2, final float f) {
        this.renderTileEntityChestAt((TileEntityChest)tileentity, d, d1, d2, f);
    }
    
    public void renderTileEntityChestAt(final TileEntityChest tileentitychest, final double d, final double d1, final double d2, final float f) {
        int i;
        if (((TileEntity)tileentitychest).world == null) {
            i = 0;
        }
        else {
            final Block block = tileentitychest.getBlockType();
            i = tileentitychest.k();
            if (block != null && i == 0) {
                ((BlockChest)block).b(((TileEntity)tileentitychest).world, ((TileEntity)tileentitychest).x, ((TileEntity)tileentitychest).y, ((TileEntity)tileentitychest).z);
                i = tileentitychest.k();
            }
            tileentitychest.i();
        }
        if (tileentitychest.b != null || tileentitychest.d != null) {
            return;
        }
        ModelChest modelchest;
        if (tileentitychest.c != null || tileentitychest.e != null) {
            modelchest = this.largeChestModel;
            this.bindTextureByName("/LockedChest.png");
        }
        else {
            modelchest = this.chestModel;
            this.bindTextureByName("/LockedChest.png");
        }
        GL11.glPushMatrix();
        GL11.glEnable(32826);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glTranslatef((float)d, (float)d1 + 1.0f, (float)d2 + 1.0f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        int j = 0;
        if (i == 2) {
            j = 180;
        }
        if (i == 3) {
            j = 0;
        }
        if (i == 4) {
            j = 90;
        }
        if (i == 5) {
            j = -90;
        }
        if (i == 2 && tileentitychest.c != null) {
            GL11.glTranslatef(1.0f, 0.0f, 0.0f);
        }
        if (i == 5 && tileentitychest.e != null) {
            GL11.glTranslatef(0.0f, 0.0f, -1.0f);
        }
        GL11.glRotatef((float)j, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        float f2 = tileentitychest.g + (tileentitychest.f - tileentitychest.g) * f;
        if (tileentitychest.b != null) {
            final float f3 = tileentitychest.b.g + (tileentitychest.b.f - tileentitychest.b.g) * f;
            if (f3 > f2) {
                f2 = f3;
            }
        }
        if (tileentitychest.d != null) {
            final float f4 = tileentitychest.d.g + (tileentitychest.d.f - tileentitychest.d.g) * f;
            if (f4 > f2) {
                f2 = f4;
            }
        }
        f2 = 1.0f - f2;
        f2 = 1.0f - f2 * f2 * f2;
        modelchest.chestLid.rotateAngleX = -(f2 * 3.141593f / 2.0f);
        modelchest.renderAll();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
