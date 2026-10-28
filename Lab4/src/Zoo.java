
import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private final List<Cage<? extends Animal>> cages =
            new ArrayList<>();

    public void addCage(Cage<? extends Animal> cage) {
        if (cage == null) {
            throw new IllegalArgumentException(
                    "Вольєр не може бути null!"
            );
        }

        if (cages.contains(cage)) {
            throw new IllegalArgumentException(
                    "Цей вольєр вже доданий до зоопарку!"
            );
        }

        cages.add(cage);
    }

    public int getCountOfAnimals() {
        int total = 0;

        for (Cage<? extends Animal> cage : cages) {
            total += cage.getOccupiedPlaces();
        }

        return total;
    }
}
