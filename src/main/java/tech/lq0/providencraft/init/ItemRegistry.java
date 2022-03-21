package tech.lq0.providencraft.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.item.donate.DonateItemExample;
import tech.lq0.providencraft.item.magicros.chiram.FlatVegetableChestplate;
import tech.lq0.providencraft.item.magicros.chiram.LotusPotato;
import tech.lq0.providencraft.item.magicros.chiram.SteelPlate;
import tech.lq0.providencraft.item.magicros.haine.HaiPlate;
import tech.lq0.providencraft.item.providenceOI.shirako.Fetuozi;
import tech.lq0.providencraft.item.providenceOI.shirako.MomoDaifuku;
import tech.lq0.providencraft.item.providencefirst.ayelet.CrystalHorn;
import tech.lq0.providencraft.item.providencefirst.madoka.*;
import tech.lq0.providencraft.item.providencefirst.mari.Machete;
import tech.lq0.providencraft.item.providencefirst.mari.MariStew;
import tech.lq0.providencraft.item.providencefirst.mitsuki.Crown;
import tech.lq0.providencraft.item.providencefirst.niina.BananaMilk;
import tech.lq0.providencraft.item.providencefirst.usa.Plunger;
import tech.lq0.providencraft.item.providencesecond.lecia.ElectricHorn;
import tech.lq0.providencraft.item.providencesecond.louise.*;
import tech.lq0.providencraft.item.providencesecond.lucia.BigMoeOnePotion;
import tech.lq0.providencraft.item.providencesecond.lucia.LuciaRiceCake;
import tech.lq0.providencraft.item.providencesecond.mojuko.YagiStaffCard;
import tech.lq0.providencraft.item.providencethird.beni.LavaCake;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    //ITEMS
    /**
     * 1st
     **/
    //madoka
    public static final RegistryObject<Item> RED_AHOGE = ITEMS.register("red_ahoge", RedAhoge::new);
    public static final RegistryObject<Item> RED_AHOGE_SWORD = ITEMS.register("red_ahoge_sword", RedAhogeSword::new);
    public static final RegistryObject<Item> RED_AHOGE_BOOMERANG = ITEMS.register("red_ahoge_boomerang", RedAhogeBoomerang::new);
    public static final RegistryObject<Item> RED_AHOGE_HELMET = ITEMS.register("red_ahoge_helmet", RedAhogeHelmet::new);

    //ayelet
    public static final RegistryObject<Item> CRYSTAL_HORN = ITEMS.register("crystal_horn", CrystalHorn::new);

    //mari
    public static final RegistryObject<Item> MACHETE = ITEMS.register("machete", Machete::new);
    public static final RegistryObject<Item> MARI_STEW = ITEMS.register("mari_stew", MariStew::new);

    //mitsuki
    public static final RegistryObject<Item> CROWN = ITEMS.register("crown", Crown::new);

    //niina
    public static final RegistryObject<Item> BANANA_MILK = ITEMS.register("banana_milk", BananaMilk::new);

    //usa
    public static final RegistryObject<Item> PLUNGER = ITEMS.register("plunger", Plunger::new);

    /**
     * 2nd
     **/
    //lucia
    public static final RegistryObject<Item> LUCIA_RICE_CAKE = ITEMS.register("lucia_rice_cake", LuciaRiceCake::new);
    public static final RegistryObject<Item> BIG_MOE_ONE_POTION = ITEMS.register("big_moe_one_potion", BigMoeOnePotion::new);

    //louise
    public static final RegistryObject<Item> MAGIC_BOOK = ITEMS.register("magic_book", MagicBook::new);
    public static final RegistryObject<Item> MAGIC_BOOK_MYANNA = ITEMS.register("magic_book_myanna", MagicBookMyanna::new);
    public static final RegistryObject<Item> MAGIC_BOOK_MYANNA_PLUS = ITEMS.register("magic_book_myanna_plus", MagicBookMyannaPlus::new);
    public static final RegistryObject<Item> WHITE_AHOGE = ITEMS.register("white_ahoge", WhiteAhoge::new);
    public static final RegistryObject<Item> WHITE_DOUBLE_AHOGE = ITEMS.register("white_double_ahoge", WhiteDoubleAhoge::new);

    //mojuko
    public static final RegistryObject<Item> YAGI_STAFF_CARD = ITEMS.register("yagi_staff_card", YagiStaffCard::new);

    //lecia
    public static final RegistryObject<Item> ELECTRIC_HORN = ITEMS.register("electric_horn", ElectricHorn::new);

    /**
     * magicros
     **/
    //chiram
    public static final RegistryObject<Item> FLAT_VEGETABLE_CHESTPLATE = ITEMS.register("flat_vegetable_chestplate", FlatVegetableChestplate::new);
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", SteelPlate::new);
    public static final RegistryObject<Item> LOTUS_POTATO = ITEMS.register("lotus_potato", LotusPotato::new);

    //haine
    public static final RegistryObject<Item> HAI_PLATE = ITEMS.register("hai_plate", HaiPlate::new);


    /**
     * POI
     **/
    //shirako
    public static final RegistryObject<Item> MOMO_DAIFUKU = ITEMS.register("momo_daifuku", MomoDaifuku::new);
    public static final RegistryObject<Item> FETUOZI = ITEMS.register("fetuozi", Fetuozi::new);


    /**
     * 3rd
     **/
    //beni
    public static final RegistryObject<Item> LAVA_CAKE = ITEMS.register("lava_cake", LavaCake::new);


    /**
     * donate
     */
    public static final RegistryObject<Item> DONATE_ITEM_EXAMPLE = ITEMS.register("donate_item_example", DonateItemExample::new);

    //BLOCKS
    public static final RegistryObject<Item> RED_AHOGE_BLOCK = ITEMS.register("red_ahoge_block",
            () -> new BlockItem(BlockRegistry.RED_AHOGE_BLOCK.get(), new Item.Properties().group(ModGroup.itemgroup)));
    public static final RegistryObject<Item> COMMUNICATION_TABLE = ITEMS.register("communication_table",
            () -> new BlockItem(BlockRegistry.COMMUNICATION_TABLE.get(), new Item.Properties().group(ModGroup.itemgroup)));
}
