package warriorspecialability.specialability;

import java.util.Arrays;

public class Healing {

    public void healWarrior(String performer, String...warriors){
        var sb = new StringBuilder();
        sb.append(performer).append(" healed ");

        if(warriors.length>1){
            sb.append("warriors ");
            Arrays.stream(warriors).forEach(enemy -> {
                if(warriors[0].equals(enemy))
                    sb.append(enemy);
                else if(warriors[warriors.length-1].equals(enemy))
                    sb.append(" and ").append(enemy);
                else
                    sb.append(", ").append(enemy);
            });

        }
        else {
            sb.append("warrior " + warriors[0]);
        }

        System.out.println(sb.toString());
    }
}
