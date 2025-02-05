package mcjty.rftoolsbase.api.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import mcjty.rftoolsbase.api.screens.data.IModuleData;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

/**
 * This interface represents the client-side module. This will be called with
 * the data from the server.
 *
 * @param <T>
 */
public interface IClientScreenModule<T extends IModuleData> {
    /**
     * The transform mode lets you control how the screen will setup the GL
     * renderer for a your module.
     */
    enum TransformMode {
        NONE,

        /**
         * The GL state is set so that the screen area is a 128x128 sized canvas with 0,0 the top-left. Usual text
         * lines in this mode are 10 high (getHeight below)
         */
        TEXT,

        /**
         * The GL state is set so that the screen area is a 64x64 sized canvas with 0,0 the top -left.  Usual text
         * lines in this mode are 20 high. Note that 'currenty' given with render will still be in 128x128 coordinate
         * space so make sure to divide this by 2 if you are in this mode.
         */
        TEXTLARGE,

        /**
         * The GL state is set so that the screen area is a 128x128 sized canvas with 0,0 the top-left. This is
         * more suitable for ItemStack rendering.
         */
        ITEM
    }

    TransformMode getTransformMode();

    /**
     * Get the height (depends on transform mode) of a line from this module.
     * @return
     */
    int getHeight();

    /**
     * Here you actually render your module. Warning! Always check if screenData is actually set! It is possible
     * you get null here which can mean that you don't need server data or the data isn't ready yet. Prepare for that.
     * Warnings! Always use the GLStateManager and restore state.
     * @param matrixStack
     * @param buffer
     * @param renderInfo
     */
    void render(PoseStack matrixStack, MultiBufferSource buffer, IModuleRenderHelper renderHelper, Font fontRenderer, int currenty, T screenData, ModuleRenderInfo renderInfo);

    /**
     * For interactive modules you can implement this to detect if your module was clickedd
     *
     * @param world
     * @param x
     * @param y
     * @param clicked
     */
    void mouseClick(Level world, int x, int y, boolean clicked);

    /**
     * This is called when your module is being instantiated from a saved world
     * so you can setup your data. The tags that are given to the tagCompound
     * depend on how you set up your GUI in the IClientScreenModule.
     * @param tagCompound
     * @param dim the dimension for the screen this module is in
     * @param pos the position of the screen
     */
    void setupFromNBT(CompoundTag tagCompound, ResourceKey<Level> dim, BlockPos pos);

    // Return true if this module needs server data.
    boolean needsServerData();
}
