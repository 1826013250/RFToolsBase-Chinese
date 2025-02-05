package mcjty.rftoolsbase.client;

import net.minecraft.core.BlockPos;

/**
 * This class holds information on client-side only which are global to the mod.
 */
public class ClientInfo {
    private BlockPos selectedTE = null;
    private BlockPos destinationTE = null;

    private BlockPos hilightedBlock = null;
    private long expireHilight = 0;

    public void hilightBlock(BlockPos c, long expireHilight) {
        hilightedBlock = c;
        this.expireHilight = expireHilight;
    }

    public BlockPos getHilightedBlock() {
        return hilightedBlock;
    }

    public long getExpireHilight() {
        return expireHilight;
    }

    public BlockPos getSelectedTE() {
        return selectedTE;
    }

    public void setSelectedTE(BlockPos selectedTE) {
        this.selectedTE = selectedTE;
    }

    public BlockPos getDestinationTE() {
        return destinationTE;
    }

    public void setDestinationTE(BlockPos destinationTE) {
        this.destinationTE = destinationTE;
    }

}
