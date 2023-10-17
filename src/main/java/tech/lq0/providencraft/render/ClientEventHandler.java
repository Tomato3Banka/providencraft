package tech.lq0.providencraft.render;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.init.BlockRegistry;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.TileEntityRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.PLUNGER_ENTITY.get(), PlungerEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), KurumiBoomerangEntityRenderer::new);

        event.enqueueWork(() -> RenderTypeLookup.setRenderLayer(BlockRegistry.HARANO_SAPLING.get(), RenderType.getCutout()));
        event.enqueueWork(() -> RenderTypeLookup.setRenderLayer(BlockRegistry.HARANO_DOOR.get(), RenderType.getCutout()));
        event.enqueueWork(() -> RenderTypeLookup.setRenderLayer(BlockRegistry.HARANO_TRAPDOOR.get(), RenderType.getCutout()));
    }
}
