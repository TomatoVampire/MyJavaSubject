package WORK8;
import java.util.*;

public class PetTest {
    public static void main(String[] args){
        Pet p1 = new Pet("Tom",Pet.Species.CAT);
        Pet p3 = new Pet("hm",Pet.Species.CAT);
        Pet p2 = new Pet("John",Pet.Species.DOG);

        Map<Pet.Species, Set<Pet>> pets = new EnumMap<>(Pet.Species.class);
        pets.put(Pet.Species.CAT,new HashSet<>());
        pets.put(Pet.Species.DOG,new HashSet<>());
        pets.get(Pet.Species.CAT).add(p1);
        pets.get(Pet.Species.CAT).add(p3);
        pets.get(Pet.Species.DOG).add(p2);
        System.out.println(pets.get(Pet.Species.CAT));
        System.out.println(pets.get(Pet.Species.DOG));
    }
}

class Pet{
    public enum Species{
        DOG,CAT;
    }
    String name;
    Species type;

    public Pet(String name, Species type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString(){
        return name + ": "+ type;
    }
}