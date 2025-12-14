package immersive_trains;

import immersive_trains.entity.VehicleEntity;
import immersive_trains.entity.misc.WeaponMount;
import immersive_trains.entity.weapon.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry for weapon constructors.
 * Kept as minimal infrastructure for potential future train-mounted equipment.
 */
public class WeaponRegistry {
    public static final Map<ResourceLocation, WeaponConstructor> REGISTRY = new HashMap<>();

    public static void register(ResourceLocation id, WeaponConstructor constructor) {
        REGISTRY.put(id, constructor);
    }

    static {
        // Weapon registrations removed - no weapons needed for train prototype
    }

    public static void bootstrap() {
        // nop
    }

    public static WeaponConstructor get(ItemStack weapon) {
        return REGISTRY.get(BuiltInRegistries.ITEM.getKey(weapon.getItem()));
    }

    public interface WeaponConstructor {
        Weapon create(VehicleEntity entity, ItemStack itemStack, WeaponMount mount, int slot);
    }
}
