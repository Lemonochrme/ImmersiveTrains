package immersive_trains.client.render.entity.renderer;

import immersive_trains.Main;
import immersive_trains.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_trains.entity.AircraftEntity;
import immersive_trains.entity.TrainEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class TrainEntityRenderer<T extends TrainEntity> extends AircraftEntityRenderer<T> {
    private static final ResourceLocation ID = Main.locate("train");

    private final ModelPartRenderHandler<T> model = new ModelPartRenderHandler<T>()
            .add("banners", this::renderBanners);

    public TrainEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.8f;
    }

    @Override
    protected ResourceLocation getModelId() {
        return ID;
    }

    @Override
    protected ModelPartRenderHandler<T> getModel(AircraftEntity entity) {
        return model;
    }
}
