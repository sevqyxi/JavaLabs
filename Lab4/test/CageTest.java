
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CageTest {

    @Test
    void testAddAnimal() {
        Cage<Lion> cage = new Cage<>(2);
        cage.addAnimal(new Lion("Сімба"));

        assertEquals(1, cage.getOccupiedPlaces());
    }

    @Test
    void testCapacity() {
        Cage<Lion> cage = new Cage<>(3);

        assertEquals(3, cage.getCapacity());
    }

    @Test
    void testFullCage() {
        Cage<Lion> cage = new Cage<>(1);
        cage.addAnimal(new Lion("Сімба"));

        assertThrows(IllegalStateException.class,
                () -> cage.addAnimal(new Lion("Муфаса")));
    }

    @Test
    void testRemoveAnimal() {
        Cage<Lion> cage = new Cage<>(2);
        Lion lion = new Lion("Сімба");

        cage.addAnimal(lion);
        cage.removeAnimal(lion);

        assertEquals(0, cage.getOccupiedPlaces());
    }

    @Test
    void testRemoveMissingAnimal() {
        Cage<Lion> cage = new Cage<>(2);

        assertThrows(IllegalArgumentException.class,
                () -> cage.removeAnimal(new Lion("Сімба")));
    }

    @Test
    void testCountAllAnimals() {
        Zoo zoo = new Zoo();

        Cage<Lion> lions = new Cage<>(2);
        Cage<Hoofed> hoofed = new Cage<>(3);

        zoo.addCage(lions);
        zoo.addCage(hoofed);

        lions.addAnimal(new Lion("Сімба"));
        hoofed.addAnimal(new Zebra("Марті"));
        hoofed.addAnimal(new Giraffe("Мелман"));

        assertEquals(3, zoo.getCountOfAnimals());
    }

    @Test
    void testEmptyAnimalName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lion("   "));
    }

    @Test
    void testDuplicateAnimal() {
        Cage<Lion> cage = new Cage<>(2);
        Lion lion = new Lion("Сімба");

        cage.addAnimal(lion);

        assertThrows(IllegalArgumentException.class,
                () -> cage.addAnimal(lion));
    }

    @Test
    void testDuplicateCage() {
        Zoo zoo = new Zoo();
        Cage<Lion> cage = new Cage<>(2);

        zoo.addCage(cage);

        assertThrows(IllegalArgumentException.class,
                () -> zoo.addCage(cage));
    }
}
