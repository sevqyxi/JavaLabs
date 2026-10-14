public class BookController {

    private static final int MANUAL = 1;
    private static final int RANDOM = 2;

    private final BookModel model;
    private final BookView view;

    // Стає true, коли користувач закрив введення (Ctrl+D), тоді програма завершується
    private boolean inputEnded = false;

    public BookController(BookModel model, BookView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.showBooks("Вихідний масив книг", model.getBooks());

        while (!inputEnded) {
            view.showMenu();
            int choice = readNumber(0, 4);
            if (inputEnded) {
                break;
            }

            switch (choice) {
                case 1:
                    searchByAuthor();
                    break;
                case 2:
                    searchByPublisher();
                    break;
                case 3:
                    searchAfterYear();
                    break;
                case 4:
                    sortByPublisher();
                    break;
                case 0:
                    view.showMessage("Роботу програми завершено.");
                    return;
            }
        }
        view.showMessage("\nВведення закінчилось, програму закрито.");
    }

    // Читає ціле число від min до max. Поки введення некоректне, просить повторити.
    private int readNumber(int min, int max) {
        while (true) {
            String input = view.readLine();
            if (input == null) {
                inputEnded = true;
                return -1;
            }

            String text = input.trim();
            if (text.isEmpty()) {
                view.showMessage("Ви нічого не ввели.");
            } else {
                try {
                    int number = Integer.parseInt(text);
                    if (number >= min && number <= max) {
                        return number;
                    }
                    view.showMessage("Варіанту " + number + " немає. Потрібне число від " + min + " до " + max + ".");
                } catch (NumberFormatException e) {
                    if (text.matches("[+-]?\\d+")) {
                        view.showMessage("Занадто велике число.");
                    } else {
                        view.showMessage("\"" + text + "\" не є цілим числом.");
                    }
                }
            }
            view.showPrompt("Спробуйте ще раз: ");
        }
    }

    // Читає непорожній рядок. Поки рядок порожній, просить повторити.
    private String readText(String prompt) {
        view.showPrompt(prompt);
        while (true) {
            String input = view.readLine();
            if (input == null) {
                inputEnded = true;
                return null;
            }
            if (Book.isValidText(input)) {
                return input.trim();
            }
            view.showPrompt("Значення не може бути порожнім. Спробуйте ще раз: ");
        }
    }

    private int askSearchMode() {
        view.showSearchModeMenu();
        return readNumber(MANUAL, RANDOM);
    }

    private boolean hasBooks() {
        if (model.isEmpty()) {
            view.showMessage("Масив книг порожній, обробляти нічого.");
            return false;
        }
        return true;
    }

    // Повертає текст для пошуку: введений вручну або випадковий.
    // null означає, що пошук виконувати не треба.
    private String chooseText(String prompt, String randomValue) {
        int mode = askSearchMode();
        if (inputEnded) {
            return null;
        }
        if (mode == MANUAL) {
            return readText(prompt);
        }

        view.showMessage("Випадково обрано: \"" + randomValue + "\"");
        if (!Book.isValidText(randomValue)) {
            view.showMessage("Це значення порожнє, пошук не виконано.");
            return null;
        }
        return randomValue;
    }

    private void searchByAuthor() {
        if (!hasBooks()) {
            return;
        }
        String author = chooseText("Введіть автора: ", model.getRandomAuthor());
        if (author != null) {
            view.showBooks("Книги автора \"" + author.trim() + "\"", model.findByAuthor(author));
        }
    }

    private void searchByPublisher() {
        if (!hasBooks()) {
            return;
        }
        String publisher = chooseText("Введіть видавництво: ", model.getRandomPublisher());
        if (publisher != null) {
            view.showBooks("Книги видавництва \"" + publisher.trim() + "\"", model.findByPublisher(publisher));
        }
    }

    private void searchAfterYear() {
        if (!hasBooks()) {
            return;
        }
        int mode = askSearchMode();
        if (inputEnded) {
            return;
        }

        int year;
        if (mode == MANUAL) {
            view.showPrompt("Введіть рік (від 1 до " + Book.currentYear() + "): ");
            year = readNumber(1, Book.currentYear());
            if (inputEnded) {
                return;
            }
        } else {
            year = model.getRandomYear();
            view.showMessage("Випадково обрано рік: " + year);
            if (!Book.isValidYear(year)) {
                view.showMessage("Цей рік некоректний, пошук не виконано.");
                return;
            }
        }
        view.showBooks("Книги, видані пізніше " + year + " року", model.findAfterYear(year));
    }

    private void sortByPublisher() {
        if (!hasBooks()) {
            return;
        }
        view.showBooks("Книги, відсортовані за видавництвом", model.sortByPublisher());
    }
}