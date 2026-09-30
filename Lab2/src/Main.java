import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CuratorRecord> journal = new ArrayList<>();

        String lastName = readName(scanner, "Введіть прізвище: ");
        String firstName = readName(scanner, "Введіть ім'я: ");
        String birthDate = readDate(scanner);
        String phone = readPhone(scanner);
        String address = readAddress(scanner);

        CuratorRecord student = new CuratorRecord(
                lastName, firstName, birthDate, phone, address
        );
        journal.add(student);
        System.out.println("\nЗаписи в журналі:");

        for (CuratorRecord record : journal) {
            record.printRecord();
        }
        scanner.close();
    }

    public static String readDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        while (true) {
            System.out.print("Введіть дату народження (дд.мм.рррр): ");
            String date = scanner.nextLine();

            try {
                LocalDate.parse(date, formatter);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Неправильна дата. Спробуйте ще раз.");
            }
        }
    }

    public static String readPhone(Scanner scanner) {
        while (true) {
            System.out.print("Введіть номер телефону: ");
            String phone = scanner.nextLine();

            if (phone.matches("\\+?[0-9]{10,13}")) {
                return phone;
            }
            System.out.println("Неправильний формат номера.");
        }
    }

    public static String readAddress(Scanner scanner) {
        while (true) {
            System.out.print("Введіть домашню адресу (вулиця, будинок, квартира): ");
            String address = scanner.nextLine();
            String[] parts = address.split(",");
            if (parts.length == 3
                    && !parts[0].trim().isEmpty()
                    && !parts[1].trim().isEmpty()
                    && !parts[2].trim().isEmpty()) {
                return address;
            }

            System.out.println("Введіть адресу у форматі: вулиця, будинок, квартира.");
        }
    }

    public static String readName(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String name = scanner.nextLine();

            if (name.matches("[А-Яа-яІіЇїЄєҐґA-Za-z'’-]+")) {
                return name;
            }

            System.out.println("Ім'я або прізвище має містити тільки літери.");
        }
    }
}