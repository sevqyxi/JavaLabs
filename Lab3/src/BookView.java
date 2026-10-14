import java.util.Scanner;

public class BookView {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1 - Книги зазначеного автора");
        System.out.println("2 - Книги зазначеного видавництва");
        System.out.println("3 - Книги, видані пізніше вказаного року");
        System.out.println("4 - Відсортувати книги за видавництвами");
        System.out.println("0 - Вихід");
        System.out.print("Ваш вибір: ");
    }

    public void showSearchModeMenu() {
        System.out.println("Як обрати значення для пошуку?");
        System.out.println("1 - Ввести вручну");
        System.out.println("2 - Випадково з підготовлених даних");
        System.out.print("Ваш вибір: ");
    }

    // Повертає null, якщо введення закінчилось (наприклад, Ctrl+D)
    public String readLine() {
        if (!scanner.hasNextLine()) {
            return null;
        }
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showPrompt(String prompt) {
        System.out.print(prompt);
    }

    public void showBooks(String header, Book[] books) {
        System.out.println();
        System.out.println(header + ":");
        if (books.length == 0) {
            System.out.println("Книги не знайдено.");
            return;
        }
        for (int i = 0; i < books.length; i++) {
            System.out.printf("%2d. %s%n", i + 1, books[i]);
        }
        System.out.println("Усього: " + books.length);
    }
}