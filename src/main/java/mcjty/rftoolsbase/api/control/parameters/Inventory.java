package mcjty.rftoolsbase.api.control.parameters;

import net.minecraft.core.Direction;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This class identifies an inventory on a network. It has an optional
 * node name. If that is not given then the processor itself is meant.
 * There is also a side adjacent to the node or processor and an
 * optional internal side. The internal side represents from which side
 * we are supposedly accessing the inventory.
 */
public class Inventory extends BlockSide {

    @Nullable private final Direction intSide;   // The side at which we are accessing the inventory (can be null)

    public Inventory(@Nullable String name, @Nonnull Direction side, @Nullable Direction intSide) {
        super(name, side);
        this.intSide = intSide;
    }

    public String serialize() {
        return "#" + (hasNodeName() ? getNodeName() : "-") + "#" + getSide().getSerializedName() + "#" + (intSide == null ? "-" : intSide.getSerializedName()) + "#";
    }

    public static Inventory deserialize(String s) {
        String[] splitted = StringUtils.split(s, '#');
        return new Inventory("-".equals(splitted[0]) ? null : splitted[0], Direction.byName(splitted[1]),
                "-".equals(splitted[2]) ? null : Direction.byName(splitted[2]));
    }

    @Override
    @Nonnull
    public Direction getSide() {
        return super.getSide();
    }

    @Nullable
    public Direction getIntSide() {
        return intSide;
    }

    @Override
    public String getStringRepresentation() {
        String s = StringUtils.left(getSide().getSerializedName().toUpperCase(), 1);
        if (getIntSide() == null) {
            s += "/*";
        } else {
            String is = StringUtils.left(getIntSide().getSerializedName().toUpperCase(), 1);
            s += "/" + is;
        }
        if (getNodeName() == null) {
            return s;
        } else {
            return StringUtils.left(getNodeName(), 6) + " " + s;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Inventory inventory = (Inventory) o;

        if (intSide != inventory.intSide) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (intSide != null ? intSide.hashCode() : 0);
        return result;
    }
}
