package immersive_trains;

import immersive_trains.client.render.entity.weaponRenderer.*;
import immersive_trains.entity.weapon.Weapon;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry for weapon renderers.
 * Kept as minimal infrastructure for potential future train-mounted equipment.
 */
public class WeaponRendererRegistry {
    public static final Map<ResourceLocation, WeaponRenderer<? extends Weapon>> REGISTRY = new HashMap<>();

    public static void register(ResourceLocation id, WeaponRenderer<? extends Weapon> renderer) {
        REGISTRY.put(id, renderer);
    }

    static {
        // Weapon renderer registrations removed - no weapons needed for train prototype
    }

    public static void bootstrap() {
        // nop
    }

    public static <W extends Weapon> WeaponRenderer<W> get(W weapon) {
        //noinspection unchecked
        return (WeaponRenderer<W>) REGISTRY.get(BuiltInRegistries.ITEM.getKey(weapon.getStack().getItem()));
    }
}
