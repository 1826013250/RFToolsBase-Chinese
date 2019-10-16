package mcjty.rftoolsbase.api.screens.data;

import io.netty.buffer.ByteBuf;

/**
 * A CONTAINER_FACTORY for IModuleData. You need to register an implementation of this to
 * the screen module registry (IScreenModuleRegistry).
 */
public interface IModuleDataFactory<T extends IModuleData> {

    T createData(ByteBuf buf);
}
