import java.util.ArrayList;
import java.util.List;

public class Cage<T extends Animal> {

    private final List<T> animals = new ArrayList<>();
    private final int capacity;

    public Cage(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Місткість повинна бути більше нуля!"
            );
        }

        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedPlaces() {
        return animals.size();
    }

    public void addAnimal(T animal) {
        if (animal == null) {
            throw new IllegalArgumentException(
                    "Тварина не може бути null!"
            );
        }

        if (animals.contains(animal)) {
            throw new IllegalArgumentException(
                    "Ця тварина вже знаходиться у вольєрі!"
            );
        }

        if (animals.size() >= capacity) {
            throw new IllegalStateException(
                    "Вольєр переповнений!"
            );
        }

        animals.add(animal);
    }

    public void removeAnimal(T animal) {
        if (!animals.remove(animal)) {
            throw new IllegalArgumentException(
                    "Тварини немає у вольєрі!"
            );
        }
    }
}

class MammalCage<T extends Mammal> extends Cage<T> {
    public MammalCage(int capacity) {
        super(capacity);
    }
}

class LionCage extends MammalCage<Lion> {
    public LionCage(int capacity) {
        super(capacity);
    }
}

class HoovedCage extends MammalCage<Hoofed> {
    public HoovedCage(int capacity) {
        super(capacity);
    }
}

class BirdCage extends Cage<Bird> {
    public BirdCage(int capacity) {
        super(capacity);
    }
}