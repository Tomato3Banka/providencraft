package tech.lq0.providencraft.init;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import static tech.lq0.providencraft.Utils.MOD_ID;

public class VillagerInit {
    public static final DeferredRegister<PointOfInterestType> POINTS_OF_INTEREST = DeferredRegister.create(ForgeRegistries.POI_TYPES, MOD_ID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, MOD_ID);

    //Elifaus
    public static final RegistryObject<PointOfInterestType> ELIFAUS_POI = POINTS_OF_INTEREST.register(
            "elifaus", () -> new PointOfInterestType("elifaus", PointOfInterestType.getAllStates(BlockRegistry.PORCELAIN_THRONE.get()), 1, 1)
    );

    public static final RegistryObject<VillagerProfession> ELIFAUS = PROFESSIONS.register(
            "elifaus", () -> new VillagerProfession("elifaus", ELIFAUS_POI.get(), ImmutableSet.of(), ImmutableSet.of(), null));

    public static void registerElifausPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, ELIFAUS_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //Ruozhi
    public static final RegistryObject<PointOfInterestType> RUOZHI_POI = POINTS_OF_INTEREST.register(
            "ruozhi", () -> new PointOfInterestType("ruozhi", PointOfInterestType.getAllStates(BlockRegistry.COMMUNICATION_TABLE.get()), 1, 1)
    );

    public static final RegistryObject<VillagerProfession> RUOZHI = PROFESSIONS.register(
            "ruozhi", () -> new VillagerProfession("ruozhi", RUOZHI_POI.get(), ImmutableSet.of(), ImmutableSet.of(), null));

    public static void registerRuozhiPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, RUOZHI_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void fillTradeData() {

        VillagerTrades.ITrade[] ruozhiLevel1 = new VillagerTrades.ITrade[]{
                new EmeraldForItemsTrade(Items.IRON_INGOT, 6, 10, 3),
                new EmeraldForItemsTrade(Blocks.PUMPKIN.asItem(), 8, 10, 5),
                new ItemsForEmeraldsTrade(Items.PUMPKIN_PIE, 5, 2, 5)
        };
        VillagerTrades.ITrade[] ruozhiLevel2 = new VillagerTrades.ITrade[]{
                new EmeraldForItemsTrade(Items.REDSTONE, 15, 10, 5),
                new ItemsForEmeraldsTrade(Items.STICKY_PISTON, 7, 1, 5)
        };
    }

    private static Int2ObjectMap<VillagerTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> p_221238_0_) {
        return new Int2ObjectOpenHashMap<>(p_221238_0_);
    }

    static class EmeraldForItemsTrade implements VillagerTrades.ITrade {
        private final Item tradeItem;
        private final int count;
        private final int maxUses;
        private final int xpValue;
        private final float priceMultiplier;

        public EmeraldForItemsTrade(ItemStack tradeItemIn, int countIn, int maxUsesIn, int xpValueIn) {
            this.tradeItem = tradeItemIn.getItem();
            this.count = countIn;
            this.maxUses = maxUsesIn;
            this.xpValue = xpValueIn;
            this.priceMultiplier = 0.05F;
        }

        public EmeraldForItemsTrade(Item tradeItemIn, int countIn, int maxUsesIn, int xpValueIn) {
            this(new ItemStack(tradeItemIn), countIn, maxUsesIn, xpValueIn);
        }

        @Override
        @ParametersAreNonnullByDefault
        public MerchantOffer getOffer(Entity trader, Random rand) {
            ItemStack itemstack = new ItemStack(this.tradeItem, this.count);
            return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }

    static class ItemsForEmeraldsTrade implements VillagerTrades.ITrade {
        private final ItemStack sellingItem;
        private final int emeraldCount;
        private final int sellingItemCount;
        private final int maxUses;
        private final int xpValue;
        private final float priceMultiplier;

        public ItemsForEmeraldsTrade(Block sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue) {
            this(new ItemStack(sellingItem), emeraldCount, sellingItemCount, maxUses, xpValue);
        }

        public ItemsForEmeraldsTrade(Item sellingItem, int emeraldCount, int sellingItemCount, int xpValue) {
            this(new ItemStack(sellingItem), emeraldCount, sellingItemCount, 12, xpValue);
        }

        public ItemsForEmeraldsTrade(Item sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue) {
            this(new ItemStack(sellingItem), emeraldCount, sellingItemCount, maxUses, xpValue);
        }

        public ItemsForEmeraldsTrade(ItemStack sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue) {
            this(sellingItem, emeraldCount, sellingItemCount, maxUses, xpValue, 0.05F);
        }

        public ItemsForEmeraldsTrade(ItemStack sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
            this.sellingItem = sellingItem;
            this.emeraldCount = emeraldCount;
            this.sellingItemCount = sellingItemCount;
            this.maxUses = maxUses;
            this.xpValue = xpValue;
            this.priceMultiplier = priceMultiplier;
        }

        @ParametersAreNonnullByDefault
        public MerchantOffer getOffer(Entity trader, Random rand) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }

}
