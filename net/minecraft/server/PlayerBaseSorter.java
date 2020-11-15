package net.minecraft.server;

import java.util.*;

public final class PlayerBaseSorter implements Comparator
{
    private Map explicitInferiors;
    private Map explicitSuperiors;
    private Map directInferiorsMap;
    private Map allInferiors;
    private Map groupIndexes;
    private Map indexes;
    private final List list;
    private final Map allBaseSuperiors;
    private final Map allBaseInferiors;
    private final String methodName;
    private static final Set Empty;
    
    public PlayerBaseSorter(final List var1, final Map var2, final Map var3, final String var4) {
        this.list = var1;
        this.allBaseSuperiors = var2;
        this.allBaseInferiors = var3;
        this.methodName = var4;
    }
    
    public void Sort() {
        if (this.list.size() > 1) {
            if (this.explicitInferiors != null) {
                this.explicitInferiors.clear();
            }
            if (this.explicitSuperiors != null) {
                this.explicitSuperiors.clear();
            }
            if (this.directInferiorsMap != null) {
                this.directInferiorsMap.clear();
            }
            if (this.allInferiors != null) {
                this.allInferiors.clear();
            }
            if (this.groupIndexes != null) {
                this.groupIndexes.clear();
            }
            if (this.indexes != null) {
                this.indexes.clear();
            }
            for (int var1 = 0; var1 < this.list.size(); ++var1) {
                final String var2 = (String) this.list.get(var1);
                final String[] var3 = (String[]) this.allBaseInferiors.get(var2);
                final boolean var4 = var3 != null && var3.length > 0;
                final String[] var5 = (String[]) this.allBaseSuperiors.get(var2);
                final boolean var6 = var5 != null && var5.length > 0;
                if ((var4 || var6) && this.directInferiorsMap == null) {
                    this.directInferiorsMap = new Hashtable();
                }
                if (var4) {
                    this.explicitInferiors = build(var2, this.explicitInferiors, this.directInferiorsMap, null, var3);
                }
                if (var6) {
                    this.explicitSuperiors = build(var2, this.explicitSuperiors, null, this.directInferiorsMap, var5);
                }
                if (this.groupIndexes == null) {
                    this.groupIndexes = new Hashtable();
                }
                this.groupIndexes.put(var2, var1);
                if (this.indexes == null) {
                    this.indexes = new Hashtable();
                }
                this.indexes.put(var2, var1);
            }
            if (this.directInferiorsMap != null) {
                for (int var1 = 0; var1 < this.list.size() - 1; ++var1) {
                    for (int var7 = var1 + 1; var7 < this.list.size(); ++var7) {
                        final String var8 = (String) this.list.get(var1);
                        final String var9 = (String) this.list.get(var7);
                        Set var10 = null;
                        Set var11 = null;
                        if (this.explicitInferiors != null) {
                            var10 = (Set) this.explicitInferiors.get(var8);
                            var11 = (Set) this.explicitInferiors.get(var9);
                        }
                        Set var12 = null;
                        Set var13 = null;
                        if (this.explicitSuperiors != null) {
                            var12 = (Set) this.explicitSuperiors.get(var8);
                            var13 = (Set) this.explicitSuperiors.get(var9);
                        }
                        final boolean var14 = var12 != null && var12.contains(var9);
                        final boolean var15 = var10 != null && var10.contains(var9);
                        final boolean var16 = var13 != null && var13.contains(var8);
                        final boolean var17 = var11 != null && var11.contains(var8);
                        if (var14 && var16) {
                            throw new UnsupportedOperationException("Can not sort PlayerBase classes for method '" + this.methodName + "'. '" + var8 + "' wants to be inferior to '" + var9 + "' and '" + var9 + "' wants to be inferior to '" + var8 + "'");
                        }
                        if (var15 && var17) {
                            throw new UnsupportedOperationException("Can not sort PlayerBase classes for method '" + this.methodName + "'. '" + var8 + "' wants to be superior to '" + var9 + "' and '" + var9 + "' wants to be superior to '" + var8 + "'");
                        }
                        if (var14 && var15) {
                            throw new UnsupportedOperationException("Can not sort PlayerBase classes for method '" + this.methodName + "'. '" + var8 + "' wants to be superior and inferior to '" + var9 + "'");
                        }
                        if (var16 && var17) {
                            throw new UnsupportedOperationException("Can not sort PlayerBase classes for method '" + this.methodName + "'. '" + var9 + "' wants to be superior and inferior to '" + var8 + "'");
                        }
                    }
                }
                if (this.allInferiors == null) {
                    this.allInferiors = new Hashtable();
                }
                for (int var1 = 0; var1 < this.list.size(); ++var1) {
                    this.build(this.list.get(var1), null);
                }
                for (int var1 = 0; var1 < this.list.size(); ++var1) {
                    this.indexes(this.list.get(var1));
                }
            }
            Collections.sort((List<Object>)this.list, this);
        }
    }
    
    private void indexes(final String var1) {
        final int var2 = (int) this.groupIndexes.get(var1);
        for (final String var4 : this.allInferiors.get(var1)) {
            final Integer var5 = (Integer) this.groupIndexes.get(var4);
            if (var5 != null && var2 > var5) {
                this.groupIndexes.put(var4, var2);
            }
        }
    }
    
    private Set build(final String var1, final String var2) {
        Set var3 = (Set) this.allInferiors.get(var1);
        if (var3 == null) {
            var3 = this.build(var1, null, (var2 != null) ? var2 : var1);
            if (var3 == null) {
                var3 = PlayerBaseSorter.Empty;
            }
            this.allInferiors.put(var1, var3);
        }
        return var3;
    }
    
    private Set build(final String var1, Set var2, final String var3) {
        final Set var4 = (Set) this.directInferiorsMap.get(var1);
        if (var4 == null) {
            return var2;
        }
        if (var2 == null) {
            var2 = (HashSet<Object>)new HashSet<String>();
        }
        for (final String var6 : var4) {
            if (var6 == var3) {
                throw new UnsupportedOperationException("Can not sort PlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + var3 + "'");
            }
            var2.add(var6);
            Set var7;
            try {
                var7 = this.build(var6, var3);
            }
            catch (UnsupportedOperationException var8) {
                throw new UnsupportedOperationException("Can not sort PlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + var6 + "'", var8);
            }
            if (var7 == PlayerBaseSorter.Empty) {
                continue;
            }
            var2.addAll(var7);
        }
        return var2;
    }
    
    private static Map build(final String var0, Map var1, final Map var2, final Map var3, final String[] var4) {
        if (var1 == null) {
            var1 = new Hashtable<String, HashSet>();
        }
        final HashSet var5 = new HashSet();
        for (int var6 = 0; var6 < var4.length; ++var6) {
            if (var4[var6] != null) {
                var5.add(var4[var6]);
            }
        }
        if (var2 != null) {
            getOrCreateSet(var2, var0).addAll(var5);
        }
        if (var3 != null) {
            final Iterator var7 = var5.iterator();
            while (var7.hasNext()) {
                getOrCreateSet(var3, var7.next()).add(var0);
            }
        }
        var1.put(var0, var5);
        return var1;
    }
    
    private static Set getOrCreateSet(final Map var0, final String var1) {
        Object var2 = var0.get(var1);
        if (var2 == null) {
            var0.put(var1, var2 = new HashSet());
        }
        return (Set)var2;
    }
    
    public int compare(final String var1, final String var2) {
        if (this.allInferiors != null) {
            if (this.allInferiors.get(var1).contains(var2)) {
                return 1;
            }
            if (this.allInferiors.get(var2).contains(var1)) {
                return -1;
            }
        }
        final int var3 = this.groupIndexes.get(var1).compareTo(this.groupIndexes.get(var2));
        return (var3 != 0) ? var3 : this.indexes.get(var1).compareTo(this.indexes.get(var2));
    }
    
    @Override
    public int compare(final Object var1, final Object var2) {
        return this.compare((String)var1, (String)var2);
    }
    
    static {
        Empty = new HashSet();
    }
}
