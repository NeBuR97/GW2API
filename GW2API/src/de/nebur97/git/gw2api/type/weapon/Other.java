package de.nebur97.git.gw2api.type.weapon;

/**
 * An enum of other weapons. <li>{@link #LargeBundle} <li>{@link #SmallBundle}
 * <li>{@link #Toy} <li>{@link #TwoHandedToy}
 * 
 * @author NeBuR97
 **/
public enum Other implements WeaponType
{
    LARGEBUNDLE, SMALLBUNDLE, TOY() {
	@Override
	public boolean isOneHanded()
	{
	    return true;
	}
    },
    TWOHANDEDTOY() {
	@Override
	public boolean isTwoHanded()
	{
	    return true;
	}

    },
    UNKNOWN() {
	@Override
	public boolean isOther()
	{
	    return false;
	}
    };

    @Override
    public boolean isAquatic()
    {
	return false;
    }

    @Override
    public boolean isOffHand()
    {
	return false;
    }

    @Override
    public boolean isOneHanded()
    {
	return false;
    }

    @Override
    public boolean isOther()
    {
	return true;
    }

    @Override
    public boolean isTwoHanded()
    {
	return false;
    }

    @Override
    public boolean canBeOffHand()
    {
	return false;
    }
}