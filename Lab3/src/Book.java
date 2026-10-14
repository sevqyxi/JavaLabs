import java.time.Year;

public class Book {

    private final String title;
    private final String author;
    private final String publisher;
    private final int year;
    private final int pages;
    private final double price;

    // Якщо якесь значення некоректне, книга не створюється
    public Book(String title, String author, String publisher, int year, int pages, double price) {
        if (!isValidText(title)) {
            throw new IllegalArgumentException("назва книги не може бути порожньою");
        }
        if (!isValidText(author)) {
            throw new IllegalArgumentException("автор не може бути порожнім");
        }
        if (!isValidText(publisher)) {
            throw new IllegalArgumentException("видавництво не може бути порожнім");
        }
        if (!isValidYear(year)) {
            throw new IllegalArgumentException("некоректний рік видання: " + year);
        }
        if (pages <= 0) {
            throw new IllegalArgumentException("кількість сторінок має бути більшою за 0: " + pages);
        }
        if (Double.isNaN(price) || Double.isInfinite(price) || price < 0) {
            throw new IllegalArgumentException("некоректна ціна: " + price);
        }

        this.title = title.trim();
        this.author = author.trim();
        this.publisher = publisher.trim();
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }

    public static boolean isValidYear(int year) {
        return year > 0 && year <= currentYear();
    }

    public static int currentYear() {
        return Year.now().getValue();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-22s | %-17s | %-16s | %4d | %4d стор. | %7.2f грн",
                title, author, publisher, year, pages, price);
    }
}