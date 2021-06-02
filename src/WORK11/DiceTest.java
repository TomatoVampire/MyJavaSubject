package WORK11;

import java.util.Random;

public class DiceTest {
    public static void main(String[] args) {
        System.out.println("掷骰子："+ rollDice());
    }

    public static Dice rollDice(){
        Random random = new Random();
        int seed = random.nextInt(6);//取值为0-5
        seed += 1;
        for(Dice dice : Dice.values()){
            if(dice.value == seed) return dice;
        }
        return Dice.NAN;
    }

    public static enum Dice{
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        NAN(-1);
        public final int value;
        Dice(int v){value = v;}
        //@Override public String toString(){return Integer.toString(value);}
    }
}
