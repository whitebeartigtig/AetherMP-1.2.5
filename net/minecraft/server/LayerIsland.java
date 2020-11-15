package net.minecraft.server;

public class LayerIsland extends GenLayer
{
    public LayerIsland(final long l) {
        super(l);
    }
    
    public int[] getInts(final int i, final int j, final int k, final int l) {
        final int[] ai = IntCache.a(k * l);
        for (int i2 = 0; i2 < l; ++i2) {
            for (int j2 = 0; j2 < k; ++j2) {
                this.a((long)(i + j2), (long)(j + i2));
                ai[j2 + i2 * k] = ((this.a(10) == 0) ? 1 : 0);
            }
        }
        if (i > -k && i <= 0 && j > -l && j <= 0) {
            ai[-i + -j * k] = 1;
        }
        return ai;
    }

	@Override
	public int[] a(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return null;
	}
}
