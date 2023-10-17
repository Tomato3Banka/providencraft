package tech.lq0.providencraft.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.LeviyBeamEntity;
import tech.lq0.providencraft.entity.projectile.*;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<PlungerEntity>> PLUNGER_ENTITY =
            ENTITY_TYPES.register("plunger_entity",
                    () -> EntityType.Builder.<PlungerEntity>create(PlungerEntity::new, EntityClassification.MISC).size(0.3f, 0.3f).build("plunger_entity"));
    public static final RegistryObject<EntityType<KurumiBoomerangEntity>> KURUMI_BOOMERANG_ENTITY =
            ENTITY_TYPES.register("kurumi_boomerang_entity",
                    () -> EntityType.Builder.<KurumiBoomerangEntity>create(KurumiBoomerangEntity::new, EntityClassification.MISC).size(1.0f, 0.3f).build("kurumi_boomerang_entity"));

    public static final RegistryObject<EntityType<LeviyBeamEntity>> LEVIY_BEAM_ENTITY =
            ENTITY_TYPES.register("leviy_beam",
                    () -> EntityType.Builder.create(LeviyBeamEntity::new, EntityClassification.MISC).size(1, 100).disableSerialization().trackingRange(300).func_233608_b_(Integer.MAX_VALUE).build("leviy_beam"));
}
