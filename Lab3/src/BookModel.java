import java.util.Arrays;
import java.util.Random;

public class BookModel {

    private Book[] books;

    private final Random random = new Random();

    // Значення для випадкового пошуку. Частини з них навмисно немає в масиві,
    // а деякі некоректні, щоб перевірити обробку таких випадків.
    private final String[] searchAuthors = {
            "Харукі Муракамі", "Стефані Маєр", "Ден Браун", "Юкіо Місіма",
            "Міеко Кавакамі", "Кадзуо Ішіґуро", "Лев Толстой", "   "
    };

    private final String[] searchPublishers = {
            "Knopf", "Little, Brown", "Europa Editions", "Faber and Faber",
            "New Directions", "Видавництво Старого Лева", ""
    };

    private final int[] searchYears = {1950, 1990, 2000, 2005, 2010, 2024, -5, 3000};

    public BookModel() {
        createBooks();
    }

    // Видавництва і роки взято з перших англомовних видань.
    // Кількість сторінок орієнтовна, ціни умовні.
    private void createBooks() {
        books = new Book[] {
                new Book("Норвезький ліс", "Харукі Муракамі", "Vintage", 2000, 296, 420.00),
                new Book("Сутінки", "Стефані Маєр", "Little, Brown", 2005, 498, 380.00),
                new Book("Золотий храм", "Юкіо Місіма", "Knopf", 1959, 262, 350.00),
                new Book("Груди і яйця", "Міеко Кавакамі", "Europa Editions", 2020, 430, 450.00),
                new Book("Код да Вінчі", "Ден Браун", "Doubleday", 2003, 454, 400.00),
                new Book("Сповідь маски", "Юкіо Місіма", "New Directions", 1958, 254, 320.00),
                new Book("Кафка на пляжі", "Харукі Муракамі", "Knopf", 2005, 436, 480.00),
                new Book("Ангели і демони", "Ден Браун", "Pocket Books", 2000, 572, 390.00),
                new Book("Молодик", "Стефані Маєр", "Little, Brown", 2006, 563, 380.00),
                new Book("Рай", "Міеко Кавакамі", "Europa Editions", 2021, 192, 360.00),
                new Book("Не відпускай мене", "Кадзуо Ішіґуро", "Faber and Faber", 2005, 263, 410.00),
                new Book("Жінка в пісках", "Кобо Абе", "Knopf", 1964, 241, 330.00),
                new Book("Залишок дня", "Кадзуо Ішіґуро", "Faber and Faber", 1989, 245, 370.00)
        };
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, books.length);
    }

    public boolean isEmpty() {
        return books.length == 0;
    }

    public String getRandomAuthor() {
        return searchAuthors[random.nextInt(searchAuthors.length)];
    }

    public String getRandomPublisher() {
        return searchPublishers[random.nextInt(searchPublishers.length)];
    }

    public int getRandomYear() {
        return searchYears[random.nextInt(searchYears.length)];
    }

    // Пошук без урахування регістру і за частиною імені:
    // "муракамі" знайде книги Харукі Муракамі
    public Book[] findByAuthor(String author) {
        String text = author.trim().toLowerCase();
        Book[] found = new Book[books.length];
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(text)) {
                found[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(found, count);
    }

    public Book[] findByPublisher(String publisher) {
        String text = publisher.trim().toLowerCase();
        Book[] found = new Book[books.length];
        int count = 0;
        for (Book book : books) {
            if (book.getPublisher().toLowerCase().contains(text)) {
                found[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(found, count);
    }

    public Book[] findAfterYear(int year) {
        Book[] found = new Book[books.length];
        int count = 0;
        for (Book book : books) {
            if (book.getYear() > year) {
                found[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(found, count);
    }

    // Сортуємо копію, щоб вихідний масив не змінювався
    public Book[] sortByPublisher() {
        Book[] sorted = Arrays.copyOf(books, books.length);
        Arrays.sort(sorted, new PublisherComparator());
        return sorted;
    }
}