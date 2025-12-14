package immersive_trains;

import immersive_trains.client.render.entity.renderer.*;
import immersive_trains.cobalt.registration.Registration;

public class Renderer {
    public static void bootstrap() {
        // Register only the single vehicle renderer
        Registration.register(Entities.AIRSHIP.get(), AirshipEntityRenderer::new);
    }
}