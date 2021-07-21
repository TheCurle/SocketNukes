package dev.socketmods.socketnukes.client.render.machine;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import dev.socketmods.socketnukes.client.models.BasicGeckolibModel;
import dev.socketmods.socketnukes.tileentity.machine.MainframeTE;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import javax.annotation.Nullable;

/**
 * @brief Barebones TERenderer for the Mainframe.
 *
 * @author Curle
 */
public class MainframeRenderer extends GeoBlockRenderer<MainframeTE> {

    public MainframeRenderer(TileEntityRendererDispatcher renderManager) {
        super(renderManager, new BasicGeckolibModel("geo/mainframe.geo.json", "textures/blocks/mainframe.png", "animations/mainframe.anim.json"));
    }

    /**
     * Fix darkness issue with rendering.
     */
    @Override
    public RenderType getRenderType(MainframeTE animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
