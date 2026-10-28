public class Main {

    public static void main(String[] args) {

        Zoo zoo = new Zoo();

        LionCage lionCage = new LionCage(2);
        HoovedCage hoofedCage = new HoovedCage(3);
        BirdCage birdCage = new BirdCage(2);

        zoo.addCage(lionCage);
        zoo.addCage(hoofedCage);
        zoo.addCage(birdCage);

        Lion lion1 = new Lion("Сімба");
        Lion lion2 = new Lion("Муфаса");

        lionCage.addAnimal(lion1);
        lionCage.addAnimal(lion2);

        hoofedCage.addAnimal(new Zebra("Марті"));
        hoofedCage.addAnimal(new Giraffe("Мелман"));

        birdCage.addAnimal(new Eagle("Орел"));

        System.out.println("Усього тварин: "
                + zoo.getCountOfAnimals());

        System.out.println("Місць для левів: "
                + lionCage.getCapacity());

        System.out.println("Зайнято місць: "
                + lionCage.getOccupiedPlaces());

        lionCage.removeAnimal(lion1);

        System.out.println("Після вилучення лева: "
                + zoo.getCountOfAnimals());

        try {
            lionCage.addAnimal(new Lion("Алекс"));
            lionCage.addAnimal(new Lion("Скар"));
        } catch (IllegalStateException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}