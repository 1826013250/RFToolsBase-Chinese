package mcjty.rftoolsbase.commands;

import net.minecraft.world.entity.player.Player;

public interface RfToolsCommand {
    public String getHelp();

    /**
     * 0 is allowed for everyone
     * 4 is most restrictive
     */
    public int getPermissionLevel();

    /**
     * @return true if this is a client-side command.
     */
    public boolean isClientSide();

    public String getCommand();

    // @todo 1.14
    public void execute(Player sender, String[] args);
}
