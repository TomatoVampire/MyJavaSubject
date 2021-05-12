package WORK7;
import java.util.EnumSet;
import java.util.Set;

public class ColorTest {
    public static void main(String[] args){
        System.out.println(Color.mix(EnumSet.of(Color.RED,Color.GREEN)));
        System.out.println(Color.mix(EnumSet.of(Color.RED,Color.GREEN,Color.BLUE)));
        System.out.println(Color.mix(EnumSet.of(Color.RED,Color.GREEN,Color.BLUE)));
        System.out.println(Color.mix(EnumSet.of(Color.RED)));
        System.out.println(Color.mix(EnumSet.of(Color.GREEN,Color.BLUE)));
    }
}

enum Color{
    RED,GREEN,BLUE;
    //YELLOW,CYAN,PURPLE,WHITE;

    public static String mix(Set<Color> set){
        if(set.size() == 1) return set.iterator().next().toString();
        if(set.equals(EnumSet.of(Color.GREEN,Color.BLUE,Color.RED))){
            return "WHITE";
        }
        if(set.equals(EnumSet.of(Color.GREEN,Color.RED))){
            return "YELLOW";
        }
        if(set.equals(EnumSet.of(Color.GREEN,Color.BLUE))){
            return "CYAN";
        }
        if(set.equals(EnumSet.of(Color.BLUE,Color.RED))){
            return "PURPLE";
        }
        return null;
    }
}
