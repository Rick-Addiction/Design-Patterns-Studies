package warriorspecialability.common;

public interface ISpecialAbilityAdapterFactory<A> {

    ISpecialAbilityAdapter getSpecialAbilityAdapterBySpecialAbilityType(A specialAbilityType);
}
