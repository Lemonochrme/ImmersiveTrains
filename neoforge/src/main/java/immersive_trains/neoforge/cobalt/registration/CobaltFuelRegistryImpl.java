package immersive_trains.neoforge.cobalt.registration;

import immersive_trains.cobalt.registration.CobaltFuelRegistry;
import net.minecraft.world.item.ItemStack;

public class CobaltFuelRegistryImpl extends CobaltFuelRegistry {
    public CobaltFuelRegistryImpl() {
        INSTANCE = this;
    }

    @Override
    public int get(ItemStack stack) {
        return stack.getBurnTime(null);
    }
}
