package immersive_trains.client.render.entity.renderer;

import immersive_trains.Main;
import immersive_trains.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_trains.entity.AircraftEntity;
import immersive_trains.entity.BambooHopperEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BambooHopperEntityRenderer<T extends BambooHopperEntity> extends AircraftEntityRenderer<T> {
    private static final ResourceLocation ID = Main.locate("bamboo_hopper");

    protected ResourceLocation getModelId() {
        return ID;
    }

    private final ModelPartRenderHandler<T> model = new ModelPartRenderHandler<>();

    public BambooHopperEntityRenderer(EntityRendererProvider.Context context) {
        super(context);

        this.shadowRadius = 2.0f;
    }

    @Override
    protected ModelPartRenderHandler<T> getModel(AircraftEntity entity) {
        return model;
    }
}
