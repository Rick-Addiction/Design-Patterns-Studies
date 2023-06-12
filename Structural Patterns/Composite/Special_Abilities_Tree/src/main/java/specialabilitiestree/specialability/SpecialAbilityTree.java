package specialabilitiestree.specialability;

import specialabilitiestree.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbility;

import java.util.*;

public abstract class SpecialAbilityTree<SpecialAbility> {

    private final Map<SpecialAbility, List<SpecialAbility>> specialAbilityMap = new HashMap<>();

    protected void addAbility(SpecialAbility specialAbility, SpecialAbility[] requirements) {
        specialAbilityMap.put(specialAbility, Arrays.asList(requirements));
    }

    protected void addAbility(SpecialAbility specialAbility) {
        specialAbilityMap.put(specialAbility, null);
    }

    boolean hasAbility(SpecialAbility specialAbility) {
        return specialAbilityMap.containsKey(specialAbility);
    }

    public boolean canAcquireAbility(SpecialAbility ability) {
        List<SpecialAbility> requirements = specialAbilityMap.get(ability);
        if (requirements == null) {
            return true;
        }
        for (SpecialAbility req : requirements) {
            if (!hasAbility(req)) {
                return false;
            }
        }
        return true;
    }

    public List<SpecialAbility> getRequirements(SpecialAbility specialAbility) {
        List<SpecialAbility> requirements = new ArrayList<>();
        Queue<SpecialAbility> queue = new LinkedList<>();
        queue.offer(specialAbility);
        while (!queue.isEmpty()) {
            SpecialAbility current = queue.poll();
            if (specialAbilityMap.containsKey(current)) {
                List<SpecialAbility> reqs = specialAbilityMap.get(current);
                for (SpecialAbility req : reqs) {
                    queue.offer(req);
                    requirements.add(req);
                }
            }
        }
        return requirements;
    }


    public void displayTree(List<SpecialAbility> acquiredSpecialAbilities) {
        System.out.println("Special abilities:");
        for (SpecialAbility specialAbility : specialAbilityMap.keySet()) {
            if (isRootAbility(specialAbility)) {
                displayTree("", null, specialAbility,acquiredSpecialAbilities);
            }
        }
    }

    private boolean isRootAbility(SpecialAbility specialAbility) {

        if(specialAbilityMap.containsKey(specialAbility) && specialAbilityMap.get(specialAbility) == null) {
            return true;
        }
        return false;
    }
    private List<SpecialAbility> getDependentAbilities(SpecialAbility specialAbility) {
        List<SpecialAbility> dependentAbilities = new ArrayList<>();
        for (Map.Entry<SpecialAbility, List<SpecialAbility>> entry : specialAbilityMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().contains(specialAbility)) {
                dependentAbilities.add(entry.getKey());
            }
        }
        return dependentAbilities;
    }

    private void displayTree(String prefix, String color, SpecialAbility specialAbility, List<SpecialAbility> acquiredSpecialAbilities) {
        boolean hasAbility = hasAbility(specialAbility);
        String textColor;
        if (acquiredSpecialAbilities.contains(specialAbility)) {
            textColor = "\u001B[32m"; // Verde
        } else {
            textColor = "\u001B[31m"; // Vermelho
        }
        String resetColor = "\u001B[0m";
        System.out.println(prefix + (hasAbility ? "└── " : "├── ") + textColor + specialAbility + resetColor);
        if (hasAbility) {
            List<SpecialAbility> dependentAbilities = getDependentAbilities(specialAbility);
            for (SpecialAbility dependentAbility : dependentAbilities) {
                String newPrefix = prefix + (hasAbility ? "    " : "│   ");
                displayTree(newPrefix, color, dependentAbility, acquiredSpecialAbilities);
            }
        }
    }
}

