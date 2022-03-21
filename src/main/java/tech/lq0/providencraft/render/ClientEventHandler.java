package tech.lq0.providencraft.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.init.EntityRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.AHOGE_BOOMERANG_ENTITY.get(), (EntityRendererManager manager) -> new RenderAhogeBoomerangEntity(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.PLUNGER_ENTITY.get(), (EntityRendererManager manager) -> new RenderPlungerEntity(manager));
    }
}
