package net.minecraft.server;

import java.util.*;

public class TeleporterAether extends PortalTravelAgent
{
    private Random random;
    
    public TeleporterAether() {
        this.random = new Random();
    }
    
    public void placeInPortal(final World world, final Entity entity) {
        if (this.placeInExistingPortal(world, entity)) {
            return;
        }
        this.createPortal(world, entity);
        this.placeInExistingPortal(world, entity);
    }
    
    public boolean placeInExistingPortal(final World world, final Entity entity) {
        final char c = '\u0080';
        double d = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        final int l = MathHelper.floor(entity.locX);
        final int i2 = MathHelper.floor(entity.locZ);
        for (int j2 = l - c; j2 <= l + c; ++j2) {
            final double d2 = j2 + 0.5 - entity.locX;
            for (int j3 = i2 - c; j3 <= i2 + c; ++j3) {
                final double d3 = j3 + 0.5 - entity.locZ;
                for (int k2 = 127; k2 >= 0; --k2) {
                    if (world.getTypeId(j2, k2, j3) == AetherBlocks.Portal.id) {
                        while (world.getTypeId(j2, k2 - 1, j3) == AetherBlocks.Portal.id) {
                            --k2;
                        }
                        final double d4 = k2 + 0.5 - entity.locY;
                        final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                        if (d < 0.0 || d5 < d) {
                            d = d5;
                            i = j2;
                            j = k2;
                            k = j3;
                        }
                    }
                }
            }
        }
        if (d >= 0.0) {
            final int k3 = i;
            final int l2 = j;
            final int i3 = k;
            double d6 = k3 + 0.5;
            final double d7 = l2 + 0.5;
            double d8 = i3 + 0.5;
            if (world.getTypeId(k3 - 1, l2, i3) == AetherBlocks.Portal.id) {
                d6 -= 0.5;
            }
            if (world.getTypeId(k3 + 1, l2, i3) == AetherBlocks.Portal.id) {
                d6 += 0.5;
            }
            if (world.getTypeId(k3, l2, i3 - 1) == AetherBlocks.Portal.id) {
                d8 -= 0.5;
            }
            if (world.getTypeId(k3, l2, i3 + 1) == AetherBlocks.Portal.id) {
                d8 += 0.5;
            }
            entity.setPositionRotation(d6, d7, d8, entity.yaw, 0.0f);
            final double motionX = 0.0;
            entity.motZ = motionX;
            entity.motY = motionX;
            entity.motX = motionX;
            return true;
        }
        return false;
    }
    
    public boolean createPortal(final World world, final Entity entity) {
        final byte byte0 = 16;
        double d = -1.0;
        final int i = MathHelper.floor(entity.locX);
        final int j = MathHelper.floor(entity.locY);
        final int k = MathHelper.floor(entity.locZ);
        int l = i;
        int i2 = j;
        int j2 = k;
        int k2 = 0;
        final int l2 = this.random.nextInt(4);
        for (int i3 = i - byte0; i3 <= i + byte0; ++i3) {
            final double d2 = i3 + 0.5 - entity.locX;
            for (int j3 = k - byte0; j3 <= k + byte0; ++j3) {
                final double d3 = j3 + 0.5 - entity.locZ;
            Label_0429:
                for (int k3 = 127; k3 >= 0; --k3) {
                    if (world.isEmpty(i3, k3, j3)) {
                        while (k3 > 0 && world.isEmpty(i3, k3 - 1, j3)) {
                            --k3;
                        }
                        for (int k4 = l2; k4 < l2 + 4; ++k4) {
                            int l3 = k4 % 2;
                            int i4 = 1 - l3;
                            if (k4 % 4 >= 2) {
                                l3 = -l3;
                                i4 = -i4;
                            }
                            for (int j4 = 0; j4 < 3; ++j4) {
                                for (int k5 = 0; k5 < 4; ++k5) {
                                    for (int l4 = -1; l4 < 4; ++l4) {
                                        final int j5 = i3 + (k5 - 1) * l3 + j4 * i4;
                                        final int l5 = k3 + l4;
                                        final int j6 = j3 + (k5 - 1) * i4 - j4 * l3;
                                        if (l4 < 0 && !this.blockIsGood(world.getTypeId(j5, l5, j6), world.getData(j5, l5, j6))) {
                                            continue Label_0429;
                                        }
                                        if (l4 >= 0 && !world.isEmpty(j5, l5, j6)) {
                                            continue Label_0429;
                                        }
                                    }
                                }
                            }
                            final double d4 = k3 + 0.5 - entity.locY;
                            final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                            if (d < 0.0 || d5 < d) {
                                d = d5;
                                l = i3;
                                i2 = k3;
                                j2 = j3;
                                k2 = k4 % 4;
                            }
                        }
                    }
                }
            }
        }
        if (d < 0.0) {
            for (int j7 = i - byte0; j7 <= i + byte0; ++j7) {
                final double d6 = j7 + 0.5 - entity.locX;
                for (int k6 = k - byte0; k6 <= k + byte0; ++k6) {
                    final double d7 = k6 + 0.5 - entity.locZ;
                Label_0778:
                    for (int l6 = 127; l6 >= 0; --l6) {
                        if (world.isEmpty(j7, l6, k6)) {
                            while (world.isEmpty(j7, l6 - 1, k6) && l6 > 0) {
                                --l6;
                            }
                            for (int l7 = l2; l7 < l2 + 2; ++l7) {
                                final int i5 = l7 % 2;
                                final int j8 = 1 - i5;
                                for (int k7 = 0; k7 < 4; ++k7) {
                                    for (int l8 = -1; l8 < 4; ++l8) {
                                        final int i6 = j7 + (k7 - 1) * i5;
                                        final int k8 = l6 + l8;
                                        final int i7 = k6 + (k7 - 1) * j8;
                                        if (l8 < 0 && !this.blockIsGood(world.getTypeId(i6, k8, i7), world.getData(i6, k8, i7))) {
                                            continue Label_0778;
                                        }
                                        if (l8 >= 0 && !world.isEmpty(i6, k8, i7)) {
                                            continue Label_0778;
                                        }
                                    }
                                }
                                final double d8 = l6 + 0.5 - entity.locY;
                                final double d9 = d6 * d6 + d8 * d8 + d7 * d7;
                                if (d < 0.0 || d9 < d) {
                                    d = d9;
                                    l = j7;
                                    i2 = l6;
                                    j2 = k6;
                                    k2 = l7 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int k9 = k2;
        final int l9 = l;
        int i8 = i2;
        final int l10 = j2;
        int i9 = k9 % 2;
        int j9 = 1 - i9;
        if (k9 % 4 >= 2) {
            i9 = -i9;
            j9 = -j9;
        }
        if (d < 0.0) {
            if (i2 < 70) {
                i2 = 70;
            }
            if (i2 > 118) {
                i2 = 118;
            }
            i8 = i2;
            for (int i10 = -1; i10 <= 1; ++i10) {
                for (int i11 = 1; i11 < 3; ++i11) {
                    for (int j10 = -1; j10 < 3; ++j10) {
                        final int k10 = l9 + (i11 - 1) * i9 + i10 * j9;
                        final int l11 = i8 + j10;
                        final int i12 = l10 + (i11 - 1) * j9 - i10 * i9;
                        final boolean flag = j10 < 0;
                        world.setTypeId(k10, l11, i12, flag ? Block.GLOWSTONE.id : 0);
                    }
                }
            }
        }
        for (int j11 = 0; j11 < 4; ++j11) {
            world.suppressPhysics = true;
            for (int j12 = 0; j12 < 4; ++j12) {
                for (int k11 = -1; k11 < 4; ++k11) {
                    final int l12 = l9 + (j12 - 1) * i9;
                    final int i13 = i8 + k11;
                    final int j13 = l10 + (j12 - 1) * j9;
                    final boolean flag2 = j12 == 0 || j12 == 3 || k11 == -1 || k11 == 3;
                    world.setTypeId(l12, i13, j13, flag2 ? Block.GLOWSTONE.id : AetherBlocks.Portal.id);
                }
            }
            world.suppressPhysics = false;
            for (int k12 = 0; k12 < 4; ++k12) {
                for (int l13 = -1; l13 < 4; ++l13) {
                    final int i14 = l9 + (k12 - 1) * i9;
                    final int j14 = i8 + l13;
                    final int k13 = l10 + (k12 - 1) * j9;
                    world.applyPhysics(i14, j14, k13, world.getTypeId(i14, j14, k13));
                }
            }
        }
        return true;
    }
    
    public boolean blockIsGood(final int block, final int meta) {
        return block != 0 && Block.byId[block].material.isSolid() && (block != AetherBlocks.Aercloud.id || meta != 0);
    }
}
