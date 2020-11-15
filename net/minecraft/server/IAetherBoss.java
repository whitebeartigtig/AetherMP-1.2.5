package net.minecraft.server;

public interface IAetherBoss
{
    int getBossHP();
    
    int getBossMaxHP();
    
    boolean isCurrentBoss();
    
    int getBossEntityID();
    
    String getBossTitle();
    
    Entity GetEntity();
}
