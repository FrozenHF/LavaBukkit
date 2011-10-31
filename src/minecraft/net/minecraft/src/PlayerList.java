// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PlayerListEntry

public class PlayerList
{

    public PlayerList()
    {
        field_35583_c = 12;
        field_35584_a = new PlayerListEntry[16];
    }

    private static int func_35568_g(long l)
    {
        return func_35571_a((int)(l ^ l >>> 32));
    }

    private static int func_35571_a(int i)
    {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int func_35573_a(int i, int j)
    {
        return i & j - 1;
    }

    public int func_35576_a()
    {
        return field_35582_b;
    }

    public Object func_35578_a(long l)
    {
        int i = func_35568_g(l);
        for(PlayerListEntry playerlistentry = field_35584_a[func_35573_a(i, field_35584_a.length)]; playerlistentry != null; playerlistentry = playerlistentry.field_35833_c)
        {
            if(playerlistentry.field_35834_a == l)
            {
                return playerlistentry.field_35832_b;
            }
        }

        return null;
    }

    public boolean func_35575_b(long l)
    {
        return func_35569_c(l) != null;
    }

    final PlayerListEntry func_35569_c(long l)
    {
        int i = func_35568_g(l);
        for(PlayerListEntry playerlistentry = field_35584_a[func_35573_a(i, field_35584_a.length)]; playerlistentry != null; playerlistentry = playerlistentry.field_35833_c)
        {
            if(playerlistentry.field_35834_a == l)
            {
                return playerlistentry;
            }
        }

        return null;
    }

    public void func_35577_a(long l, Object obj)
    {
        int i = func_35568_g(l);
        int j = func_35573_a(i, field_35584_a.length);
        for(PlayerListEntry playerlistentry = field_35584_a[j]; playerlistentry != null; playerlistentry = playerlistentry.field_35833_c)
        {
            if(playerlistentry.field_35834_a == l)
            {
                playerlistentry.field_35832_b = obj;
            }
        }

        field_35581_e++;
        func_35570_a(i, l, obj, j);
    }

    private void func_35567_b(int i)
    {
        PlayerListEntry aplayerlistentry[] = field_35584_a;
        int j = aplayerlistentry.length;
        if(j == 0x40000000)
        {
            field_35583_c = 0x7fffffff;
            return;
        } else
        {
            PlayerListEntry aplayerlistentry1[] = new PlayerListEntry[i];
            func_35579_a(aplayerlistentry1);
            field_35584_a = aplayerlistentry1;
            field_35583_c = (int)((float)i * field_35580_d);
            return;
        }
    }

    private void func_35579_a(PlayerListEntry aplayerlistentry[])
    {
        PlayerListEntry aplayerlistentry1[] = field_35584_a;
        int i = aplayerlistentry.length;
        for(int j = 0; j < aplayerlistentry1.length; j++)
        {
            PlayerListEntry playerlistentry = aplayerlistentry1[j];
            if(playerlistentry == null)
            {
                continue;
            }
            aplayerlistentry1[j] = null;
            do
            {
                PlayerListEntry playerlistentry1 = playerlistentry.field_35833_c;
                int k = func_35573_a(playerlistentry.field_35831_d, i);
                playerlistentry.field_35833_c = aplayerlistentry[k];
                aplayerlistentry[k] = playerlistentry;
                playerlistentry = playerlistentry1;
            } while(playerlistentry != null);
        }

    }

    public Object func_35574_d(long l)
    {
        PlayerListEntry playerlistentry = func_35572_e(l);
        return playerlistentry != null ? playerlistentry.field_35832_b : null;
    }

    final PlayerListEntry func_35572_e(long l)
    {
        int i = func_35568_g(l);
        int j = func_35573_a(i, field_35584_a.length);
        PlayerListEntry playerlistentry = field_35584_a[j];
        PlayerListEntry playerlistentry1;
        PlayerListEntry playerlistentry2;
        for(playerlistentry1 = playerlistentry; playerlistentry1 != null; playerlistentry1 = playerlistentry2)
        {
            playerlistentry2 = playerlistentry1.field_35833_c;
            if(playerlistentry1.field_35834_a == l)
            {
                field_35581_e++;
                field_35582_b--;
                if(playerlistentry == playerlistentry1)
                {
                    field_35584_a[j] = playerlistentry2;
                } else
                {
                    playerlistentry.field_35833_c = playerlistentry2;
                }
                return playerlistentry1;
            }
            playerlistentry = playerlistentry1;
        }

        return playerlistentry1;
    }

    private void func_35570_a(int i, long l, Object obj, int j)
    {
        PlayerListEntry playerlistentry = field_35584_a[j];
        field_35584_a[j] = new PlayerListEntry(i, l, obj, playerlistentry);
        if(field_35582_b++ >= field_35583_c)
        {
            func_35567_b(2 * field_35584_a.length);
        }
    }

    static int func_35566_f(long l)
    {
        return func_35568_g(l);
    }

    private transient PlayerListEntry field_35584_a[];
    private transient int field_35582_b;
    private int field_35583_c;
    private final float field_35580_d = 0.75F;
    private volatile transient int field_35581_e;
}
