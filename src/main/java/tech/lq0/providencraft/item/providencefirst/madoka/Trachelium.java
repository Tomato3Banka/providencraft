package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.particle.TracheliumParticleData;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.*;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Trachelium extends Item {
    public static final String TAG_AMMO = "ammo";

    public Trachelium(){
        super(new Properties().maxStackSize(1).maxDamage(8).group(ModGroup.itemgroup).rarity(Rarity.create("LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("trachelium_des1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("trachelium_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MADOKA);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }

    public static int getAmmo(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_AMMO, 8);
    }

    public static void setAmmo(ItemStack stack, int num){
        ItemNBTTool.setInt(stack, TAG_AMMO, num);
    }

    public static void shoot(ItemStack stack, PlayerEntity player){
//        if(player.isCreative()){
//            return;
//        }
        setAmmo(stack, Math.max(getAmmo(stack) - 1, 0));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        setAmmo(stack, 8);
        return stack;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(getAmmo(stack) < 8){
            playerIn.setActiveHand(handIn);
            return ActionResult.resultConsume(stack);
        }else {
            return new ActionResult<>(ActionResultType.FAIL, stack);
        }
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

//    @Override
//    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
//        if(this.getUseDuration(stack) - count < 20) {
//            if (player.getEntityWorld() instanceof ServerWorld) {
//                System.out.println(1919);
//                IParticleData particleData = new TracheliumParticleData(new Vector3d(0, 0, 0),
//                        new Color(255, 255, 255, 0), 0.3f, player.getPosX(), player.getPosY() + 1.3, player.getPosZ(), true);
//                ((ServerWorld) player.getEntityWorld()).spawnParticle(particleData, player.getPosX(), player.getPosY() + 1.3, player.getPosZ(),
//                        3, Math.random() * 3 + 2, Math.random() * 3 + 2, Math.random() * 3 + 2, 0.1D);
//            }
//
//        }
//        super.onUsingTick(stack, player, count);
//    }
}
