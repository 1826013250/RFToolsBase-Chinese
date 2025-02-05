package mcjty.rftoolsbase.api.screens;

import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

/**
 * Implement this interface on your screen module (typically the module
 * that also implements IScreenModule) to allow updating of that module
 * directly in world
 */
public interface IScreenModuleUpdater {

    /**
     * Return a copy of the input tagCommpound with possible modifications
     * if you want this. This method is guaranteed to be called right
     * after any interaction with the screen (mouse click) and on the server
     * side. Return null if nothing has to be changed
     * @param tagCompound
     * @param world
     * @param player can be null in case button is released. Beware of that!
     * @return a new tagCompound or null if no change needed
     */
    CompoundTag update(CompoundTag tagCompound, Level world, Player player);

}
