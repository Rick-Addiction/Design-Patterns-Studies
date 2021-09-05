package warriorspecialability.specialability;

import java.util.Arrays;

public class Cyclone {

    public void executeCycloneAttack(String source, String...destinations){

        var sb = new StringBuilder();
        sb.append(source).append(" attacked ");

        if(destinations.length>1){
            sb.append("enemies ");
            Arrays.stream(destinations).forEach(enemy -> {
                if(destinations[0].equals(enemy))
                    sb.append(enemy);
                else if(destinations[destinations.length-1].equals(enemy))
                    sb.append(" and ").append(enemy);
                else
                    sb.append(", ").append(enemy);
            });

        }
        else {
            sb.append("enemy " + destinations[0]);
        }

        sb.append(" with a Cyclone Attack");

        System.out.println(sb.toString());
    }
}
