// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, BlockGrass, WorldGenTrees, WorldGenBigTree, 
//            WorldGenForest, WorldGenSwamp, SpawnListEntry, EntitySheep, 
//            EntityPig, EntityChicken, EntityCow, EntitySpider, 
//            EntityZombie, EntitySkeleton, EntityCreeper, EntitySlime, 
//            EntityEnderman, EntitySquid, BiomeDecorator, EnumCreatureType, 
//            BiomeGenOcean, BiomeGenPlains, BiomeGenDesert, BiomeGenHills, 
//            BiomeGenForest, BiomeGenTaiga, BiomeGenSwamp, BiomeGenRiver, 
//            BiomeGenHell, BiomeGenSky, WorldGenerator, World

public abstract class BiomeGenBase
{

    protected BiomeGenBase(int i)
    {
        topBlock = (byte)Block.grass.blockID;
        fillerBlock = (byte)Block.dirt.blockID;
        field_6502_q = 0x4ee031;
        field_35492_q = 0.1F;
        field_35491_r = 0.3F;
        field_35490_s = 0.5F;
        field_35489_t = 0.5F;
        spawnableMonsterList = new ArrayList();
        spawnableCreatureList = new ArrayList();
        spawnableWaterCreatureList = new ArrayList();
        enableRain = true;
        field_35493_z = new WorldGenTrees();
        field_35480_A = new WorldGenBigTree();
        field_35481_B = new WorldGenForest();
        field_35482_C = new WorldGenSwamp();
        field_35494_y = i;
        field_35486_a[i] = this;
        field_35488_u = func_35475_a();
        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntitySheep.class, 12, 4, 4));
        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityPig.class, 10, 4, 4));
        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityChicken.class, 10, 4, 4));
        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityCow.class, 8, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntitySpider.class, 10, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityZombie.class, 10, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntitySkeleton.class, 10, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityCreeper.class, 10, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntitySlime.class, 10, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityEnderman.class, 2, 4, 4));
        spawnableWaterCreatureList.add(new SpawnListEntry(net.minecraft.src.EntitySquid.class, 10, 4, 4));
    }

    protected BiomeDecorator func_35475_a()
    {
        return new BiomeDecorator(this);
    }

    private BiomeGenBase func_35478_a(float f, float f1)
    {
        field_35490_s = f;
        field_35489_t = f1;
        return this;
    }

    private BiomeGenBase func_35479_b(float f, float f1)
    {
        field_35492_q = f;
        field_35491_r = f1;
        return this;
    }

    private BiomeGenBase setDisableRain()
    {
        enableRain = false;
        return this;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if(random.nextInt(10) == 0)
        {
            return field_35480_A;
        } else
        {
            return field_35493_z;
        }
    }

    protected BiomeGenBase setBiomeName(String s)
    {
        biomeName = s;
        return this;
    }

    protected BiomeGenBase func_4124_a(int i)
    {
        field_6502_q = i;
        return this;
    }

    protected BiomeGenBase setColor(int i)
    {
        color = i;
        return this;
    }

    public int getSkyColorByTemp(float f)
    {
        f /= 3F;
        if(f < -1F)
        {
            f = -1F;
        }
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        return java.awt.Color.getHSBColor(0.6222222F - f * 0.05F, 0.5F + f * 0.1F, 1.0F).getRGB();
    }

    public List getSpawnableList(EnumCreatureType enumcreaturetype)
    {
        if(enumcreaturetype == EnumCreatureType.monster)
        {
            return spawnableMonsterList;
        }
        if(enumcreaturetype == EnumCreatureType.creature)
        {
            return spawnableCreatureList;
        }
        if(enumcreaturetype == EnumCreatureType.waterCreature)
        {
            return spawnableWaterCreatureList;
        } else
        {
            return null;
        }
    }

    public boolean getEnableSnow()
    {
        return enableSnow;
    }

    public boolean canSpawnLightningBolt()
    {
        if(enableSnow)
        {
            return false;
        } else
        {
            return enableRain;
        }
    }

    public float getBiome()
    {
        return 0.1F;
    }

    public final int func_35476_e()
    {
        return (int)(field_35489_t * 65536F);
    }

    public final int func_35474_f()
    {
        return (int)(field_35490_s * 65536F);
    }

    public void func_35477_a(World world, Random random, int i, int j)
    {
        field_35488_u.func_35881_a(world, random, i, j);
    }

    public static final BiomeGenBase field_35486_a[] = new BiomeGenBase[256];
    public static final BiomeGenBase field_35484_b = (new BiomeGenOcean(0)).setColor(112).setBiomeName("Ocean").func_35479_b(-1F, 0.5F);
    public static final BiomeGenBase field_35485_c = (new BiomeGenPlains(1)).setColor(0x8db360).setBiomeName("Plains").func_35478_a(0.8F, 0.4F);
    public static final BiomeGenBase desert = (new BiomeGenDesert(2)).setColor(0xfa9418).setBiomeName("Desert").setDisableRain().func_35478_a(2.0F, 0.0F).func_35479_b(0.1F, 0.2F);
    public static final BiomeGenBase field_35483_e = (new BiomeGenHills(3)).setColor(0x606060).setBiomeName("Extreme Hills").func_35479_b(0.2F, 1.8F).func_35478_a(0.2F, 0.3F);
    public static final BiomeGenBase forest = (new BiomeGenForest(4)).setColor(0x56621).setBiomeName("Forest").func_4124_a(0x4eba31).func_35478_a(0.7F, 0.8F);
    public static final BiomeGenBase taiga = (new BiomeGenTaiga(5)).setColor(0xb6659).setBiomeName("Taiga").func_4124_a(0x4eba31).func_35478_a(0.3F, 0.8F).func_35479_b(0.1F, 0.4F);
    public static final BiomeGenBase swampland = (new BiomeGenSwamp(6)).setColor(0x7f9b2).setBiomeName("Swampland").func_4124_a(0x8baf48).func_35479_b(-0.2F, 0.1F).func_35478_a(0.8F, 0.9F);
    public static final BiomeGenBase field_35487_i = (new BiomeGenRiver(7)).setColor(255).setBiomeName("River").func_35479_b(-0.5F, 0.0F);
    public static final BiomeGenBase hell = (new BiomeGenHell(8)).setColor(0xff0000).setBiomeName("Hell").setDisableRain();
    public static final BiomeGenBase sky = (new BiomeGenSky(9)).setColor(0x8080ff).setBiomeName("Sky").setDisableRain();
    public String biomeName;
    public int color;
    public byte topBlock;
    public byte fillerBlock;
    public int field_6502_q;
    public float field_35492_q;
    public float field_35491_r;
    public float field_35490_s;
    public float field_35489_t;
    public BiomeDecorator field_35488_u;
    protected List spawnableMonsterList;
    protected List spawnableCreatureList;
    protected List spawnableWaterCreatureList;
    private boolean enableSnow;
    private boolean enableRain;
    public final int field_35494_y;
    protected WorldGenTrees field_35493_z;
    protected WorldGenBigTree field_35480_A;
    protected WorldGenForest field_35481_B;
    protected WorldGenSwamp field_35482_C;

}
