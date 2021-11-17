package specialabilitiestree.common;

public interface ISpecialAbilityAdapterFactory<A> {

    ISpecialAbilityAdapter getSpecialAbilityAdapterBySpecialAbilityType(A specialAbilityType);
}
