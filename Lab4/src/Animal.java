
abstract class Animal {
    private final String name;

    public Animal(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Ім'я тварини не може бути порожнім!"
            );
        }

        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}

class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
}

class Lion extends Mammal {
    public Lion(String name) {
        super(name);
    }
}

class Hoofed extends Mammal {
    public Hoofed(String name) {
        super(name);
    }
}

class Zebra extends Hoofed {
    public Zebra(String name) {
        super(name);
    }
}

class Giraffe extends Hoofed {
    public Giraffe(String name) {
        super(name);
    }
}

class Eagle extends Bird {
    public Eagle(String name) {
        super(name);
    }
}
