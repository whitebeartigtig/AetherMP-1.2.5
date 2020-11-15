package net.minecraft.server;

public class Frozen
{
    public ItemStack frozenFrom;
    public ItemStack frozenTo;
    public int frozenPowerNeeded;
    
    public Frozen(final ItemStack from, final ItemStack to, final int i) {
        this.frozenFrom = from;
        this.frozenTo = to;
        this.frozenPowerNeeded = i;
    }
}
