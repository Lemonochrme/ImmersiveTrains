package immersive_trains;

import immersive_trains.cobalt.registration.Registration;
import immersive_trains.data.UpgradeDataLoader;
import immersive_trains.data.VehicleDataLoader;
import immersive_trains.resources.BBModelLoader;

public class DataLoaders {
    public static void bootstrap() {
        // nop
    }

    static {
        Registration.registerDataLoader("aircraft_upgrades", new UpgradeDataLoader());
        Registration.registerDataLoader("aircraft", new VehicleDataLoader());

        Registration.registerResourceLoader("objects_bbmodel", new BBModelLoader());
    }
}
