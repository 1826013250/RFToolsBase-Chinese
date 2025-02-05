package mcjty.rftoolsbase.api.screens.data;

import net.minecraft.network.FriendlyByteBuf;

/**
 * Implement this interface for data that you want to send from
 * the server side (IScreenModule) to the client side (IClientScreenModule)
 */
public interface IModuleData {

    /**
     * Get the unique id of this data. This is the same id that was used in IScreenModuleRegistry and
     * is used so RFTools knows how to deserialize a module.
     * @return
     */
    String getId();

    void writeToBuf(FriendlyByteBuf buf);
}
