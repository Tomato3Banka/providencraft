package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.WaterCardEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class DuelWaterGun extends Item {
    public DuelWaterGun() {
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).maxDamage(40));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("duel_water_gun_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("duel_water_gun_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("duel_water_gun_func")).mergeStyle(TextFormatting.AQUA));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        ItemStack stack = context.getItem();
        PlayerEntity player = context.getPlayer();
        if (!world.isRemote) {
            if (player != null && player.isSneaking()) {
                BlockRayTraceResult raytraceresult = rayTrace(world, player, RayTraceContext.FluidMode.SOURCE_ONLY);
                if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                    BlockState state = world.getBlockState(raytraceresult.getPos());
                    if (state.isIn(Blocks.WATER)) {
                        stack.setDamage(0);
                        player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                    } else if (state.isIn(Blocks.LAVA)) {
                        player.setFire(10);
                    }
                }
            }
        }
        return ActionResultType.CONSUME;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            if (playerIn.isSneaking()) {
                BlockRayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
                if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                    BlockState state = worldIn.getBlockState(raytraceresult.getPos());
                    if (state.isIn(Blocks.WATER)) {
                        stack.setDamage(0);
                        playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                        return new ActionResult<>(ActionResultType.PASS, stack);
                    } else if (state.isIn(Blocks.LAVA)) {
                        playerIn.setFire(10);
                        return new ActionResult<>(ActionResultType.PASS, stack);
                    }
                }
            }

            if (stack.getDamage() < stack.getMaxDamage()) {
                WaterCardEntity waterCard = new WaterCardEntity(worldIn, playerIn);
                waterCard.setShooter(playerIn);
                waterCard.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 4.0f, 0.0f);
                worldIn.addEntity(waterCard);

                if (!playerIn.abilities.isCreativeMode) {
                    stack.setDamage(stack.getDamage() + 1);
                }
                return new ActionResult<>(ActionResultType.CONSUME, stack);
            }
        }
        return new ActionResult<>(ActionResultType.PASS, stack);
    }
}
