package tech.lq0.providencraft.item.others;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MVAStew extends Item {
    //MVA means Madoka Vegetable Asui

    private static final Food food = (new Food.Builder()).saturation(0.8f).hunger(10).
            effect(() -> new EffectInstance(Effects.RESISTANCE, 2400, 1), 1.0f).build();

    public MVAStew() {
        super(new Item.Properties().food(food).maxStackSize(1).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("mva_stew_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("mva_stew_des2")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if(entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            if (player.isCreative()) {
                return itemStack;
            } else {
                return Items.BOWL.getDefaultInstance();
            }
        }
        return itemStack;
    }
}
