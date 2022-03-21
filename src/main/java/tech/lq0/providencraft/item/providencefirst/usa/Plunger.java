package tech.lq0.providencraft.item.providencefirst.usa;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nullable;
import java.util.List;

public class Plunger extends SwordItem {
    public Plunger() {
        super(ItemTier.WOOD, 3, -1.5f, new Properties().defaultMaxDamage(503).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("plunger_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("plunger_des2")).mergeStyle(TextFormatting.GRAY));
    }
}
