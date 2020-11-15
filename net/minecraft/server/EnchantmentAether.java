package net.minecraft.server;

public class EnchantmentAether
{
    public ItemStack enchantFrom;
    public ItemStack enchantTo;
    public int enchantPowerNeeded;
    
    public EnchantmentAether(final ItemStack from, final ItemStack to, final int i) {
        this.enchantFrom = from;
        this.enchantTo = to;
        this.enchantPowerNeeded = i;
    }
}
