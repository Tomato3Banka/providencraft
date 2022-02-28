package tech.lq0.providencraft.item.chiram;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import tech.lq0.providencraft.ModArmorMaterial;
import tech.lq0.providencraft.ModGroup;

public class FlatVegetableChestplate extends ArmorItem {
    public FlatVegetableChestplate(){
        super(ModArmorMaterial.CHIRAM, EquipmentSlotType.CHEST,new Properties().group(ModGroup.itemgroup));
    }
}
