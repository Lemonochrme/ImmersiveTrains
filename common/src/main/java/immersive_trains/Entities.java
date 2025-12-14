package immersive_trains;

import immersive_trains.cobalt.registration.Registration;
import immersive_trains.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public interface Entities {
    // Keep only one vehicle entity as the base for future train development
    Supplier<EntityType<AirshipEntity>> AIRSHIP = register("airship", EntityType.Builder
            .of(AirshipEntity::new, MobCategory.MISC)
            .sized(1.5f, 3.0f)
            .clientTrackingRange(12)
            .fireImmune()
    );

    static void bootstrap() {

    }

    static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        ResourceLocation id = Main.locate(name);
        return Registration.register(BuiltInRegistries.ENTITY_TYPE, id, () -> builder.build(id.toString()));
    }
}
