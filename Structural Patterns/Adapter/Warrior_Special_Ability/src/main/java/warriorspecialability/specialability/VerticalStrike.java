package warriorspecialability.specialability;

import java.util.Arrays;

public class VerticalStrike {

    public void executeVerticalStrike(String performer, String...enemies){

        var sb = new StringBuilder();
        sb.append(performer).append(" attacked ");

        if(enemies.length>1){
            sb.append("enemies ");
            Arrays.stream(enemies).forEach(enemy -> {
                if(enemies[0].equals(enemy))
                    sb.append(enemy);
                else if(enemies[enemies.length-1].equals(enemy))
                    sb.append(" and ").append(enemy);
                else
                    sb.append(", ").append(enemy);
            });

        }
        else {
            sb.append("enemy " + enemies[0]);
        }

        sb.append(" with a Vertical Strike Attack");

        System.out.println(sb.toString());
    }
}
