package immersive_trains;

import immersive_trains.cobalt.registration.Registration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public interface Sounds {
    // Core sounds needed for the single vehicle
    Supplier<SoundEvent> ENGINE_START = register("engine_start");
    Supplier<SoundEvent> PROPELLER = register("propeller");
    Supplier<SoundEvent> PROPELLER_SMALL = register("propeller_small");
    Supplier<SoundEvent> REPAIR = register("repair");

    static void bootstrap() {
        // nop
    }

    static Supplier<SoundEvent> register(String name) {
        ResourceLocation id = Main.locate(name);
        return Registration.register(BuiltInRegistries.SOUND_EVENT, id, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
