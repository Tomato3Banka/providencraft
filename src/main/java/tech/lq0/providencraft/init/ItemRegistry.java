package tech.lq0.providencraft.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.item.blockitem.PorcelainThroneBlockItem;
import tech.lq0.providencraft.item.costume.OI.miya.JellyfishShell;
import tech.lq0.providencraft.item.costume.first.usa.KRM_963_53;
import tech.lq0.providencraft.item.material.*;
import tech.lq0.providencraft.item.others.*;
import tech.lq0.providencraft.item.providenceconnections.qianyun.QianyunHoe;
import tech.lq0.providencraft.item.providenceconnections.qianyun.Suitcase;
import tech.lq0.providencraft.item.providencefirst.usa.KurumiBoomerang;
import tech.lq0.providencraft.item.providencefirst.usa.KurumiHalo;
import tech.lq0.providencraft.item.providencefirst.usa.Plunger;
import tech.lq0.providencraft.item.providencesecond.mumu.MumuSteak;
import tech.lq0.providencraft.tools.Livers;

@SuppressWarnings({"unused"})
public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    //ITEMS
    /**
     * 1st
     **/
    //usa
    public static final RegistryObject<Item> PLUNGER = ITEMS.register("plunger", Plunger::new);
    public static final RegistryObject<Item> KURUMI_BOOMERANG = ITEMS.register("kurumi_boomerang", KurumiBoomerang::new);
    public static final RegistryObject<Item> KURUMI_HALO = ITEMS.register("kurumi_halo", KurumiHalo::new);

    //mumu
    public static final RegistryObject<Item> MUMU_STEAK = ITEMS.register("mumu_steak", MumuSteak::new);

    /**
     * others
     */
    public static final RegistryObject<Item> AUDIO_TAPE_USA_1 = ITEMS.register("audio_tape_usa_1", () -> new AudioTape(Livers.USA, SoundRegistry.USA_DUODUO_ANGEL, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
    public static final RegistryObject<Item> AUDIO_TAPE_USA_2 = ITEMS.register("audio_tape_usa_2", () -> new AudioTape(Livers.USA, SoundRegistry.USA_BOOMERANG, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));
    public static final RegistryObject<Item> AUDIO_TAPE_USA_3 = ITEMS.register("audio_tape_usa_3", () -> new AudioTape(Livers.USA, SoundRegistry.USA_GUNDAM, (new Item.Properties().group(ModGroup.tapegroup).maxStackSize(1))));

    public static final RegistryObject<Item> MUSIC_DISC_DARAKUDATENSHI = ITEMS.register("music_disc_darakudatenshi", () -> new MusicDisc(Livers.USA, SoundRegistry.DARAKUDATENSHI, (new Item.Properties()).group(ModGroup.tapegroup).maxStackSize(1).rarity(Rarity.RARE), 1));

    /**
     * costume
     */
    public static final RegistryObject<Item> KRM_963_53 = ITEMS.register("krm_963_53", KRM_963_53::new);

    //BLOCKS
    public static final RegistryObject<Item> BLUE_SAND = ITEMS.register("blue_sand",
            () -> new BlockItem(BlockRegistry.BLUE_SAND.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> BLUE_SANDSTONE = ITEMS.register("blue_sandstone",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> CUT_BLUE_SANDSTONE = ITEMS.register("cut_blue_sandstone",
            () -> new BlockItem(BlockRegistry.CUT_BLUE_SANDSTONE.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> CHISELED_BLUE_SANDSTONE = ITEMS.register("chiseled_blue_sandstone",
            () -> new BlockItem(BlockRegistry.CHISELED_BLUE_SANDSTONE.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> BLUE_SANDSTONE_SLAB = ITEMS.register("blue_sandstone_slab",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE_SLAB.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> CUT_BLUE_SANDSTONE_SLAB = ITEMS.register("cut_blue_sandstone_slab",
            () -> new BlockItem(BlockRegistry.CUT_BLUE_SANDSTONE_SLAB.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> BLUE_SANDSTONE_STAIRS = ITEMS.register("blue_sandstone_stairs",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE_STAIRS.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> BLUE_SANDSTONE_WALL = ITEMS.register("blue_sandstone_wall",
            () -> new BlockItem(BlockRegistry.BLUE_SANDSTONE_WALL.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> SMOOTH_BLUE_SANDSTONE = ITEMS.register("smooth_blue_sandstone",
            () -> new BlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> SMOOTH_BLUE_SANDSTONE_SLAB = ITEMS.register("smooth_blue_sandstone_slab",
            () -> new BlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_SLAB.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> SMOOTH_BLUE_SANDSTONE_STAIRS = ITEMS.register("smooth_blue_sandstone_stairs",
            () -> new BlockItem(BlockRegistry.SMOOTH_BLUE_SANDSTONE_STAIRS.get(), new Item.Properties().group(ModGroup.blockgroup)));

    public static final RegistryObject<Item> HARANO_LOG = ITEMS.register("harano_log",
            () -> new BlockItem(BlockRegistry.HARANO_LOG.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_PLANKS = ITEMS.register("harano_planks",
            () -> new BlockItem(BlockRegistry.HARANO_PLANKS.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_LEAVES = ITEMS.register("harano_leaves",
            () -> new BlockItem(BlockRegistry.HARANO_LEAVES.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_SAPLING = ITEMS.register("harano_sapling",
            () -> new BlockItem(BlockRegistry.HARANO_SAPLING.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_WOOD = ITEMS.register("harano_wood",
            () -> new BlockItem(BlockRegistry.HARANO_WOOD.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_STAIRS = ITEMS.register("harano_stairs",
            () -> new BlockItem(BlockRegistry.HARANO_STAIRS.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_SLAB = ITEMS.register("harano_slab",
            () -> new BlockItem(BlockRegistry.HARANO_SLAB.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_FENCE = ITEMS.register("harano_fence",
            () -> new BlockItem(BlockRegistry.HARANO_FENCE.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_FENCE_GATE = ITEMS.register("harano_fence_gate",
            () -> new BlockItem(BlockRegistry.HARANO_FENCE_GATE.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_PRESSURE_PLATE = ITEMS.register("harano_pressure_plate",
            () -> new BlockItem(BlockRegistry.HARANO_PRESSURE_PLATE.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> STRIPPED_HARANO_LOG = ITEMS.register("stripped_harano_log",
            () -> new BlockItem(BlockRegistry.STRIPPED_HARANO_LOG.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> STRIPPED_HARANO_WOOD = ITEMS.register("stripped_harano_wood",
            () -> new BlockItem(BlockRegistry.STRIPPED_HARANO_WOOD.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_DOOR = ITEMS.register("harano_door",
            () -> new BlockItem(BlockRegistry.HARANO_DOOR.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_TRAPDOOR = ITEMS.register("harano_trapdoor",
            () -> new BlockItem(BlockRegistry.HARANO_TRAPDOOR.get(), new Item.Properties().group(ModGroup.blockgroup)));
    public static final RegistryObject<Item> HARANO_BUTTON = ITEMS.register("harano_button",
            () -> new BlockItem(BlockRegistry.HARANO_BUTTON.get(), new Item.Properties().group(ModGroup.blockgroup)));
}
