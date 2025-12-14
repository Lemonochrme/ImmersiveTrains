package immersive_trains.item;

import immersive_trains.entity.AircraftEntity;
import net.minecraft.world.level.Level;

public class AircraftItem extends VehicleItem {
    public interface AircraftConstructor extends VehicleConstructor {
        AircraftEntity create(Level world);
    }

    public AircraftItem(Properties settings, AircraftConstructor constructor) {
        super(settings, constructor);
    }
}
