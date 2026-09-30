public class CuratorRecord {
    private String lastName;
    private String firstName;
    private String birthDate;
    private String phone;
    private String address;

    public CuratorRecord(String lastName, String firstName, String birthDate,
                         String phone, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public void printRecord() {
        System.out.println("Прізвище: " + lastName);
        System.out.println("Ім'я: " + firstName);
        System.out.println("Дата народження: " + birthDate);
        System.out.println("Телефон: " + phone);
        System.out.println("Домашня адреса: " + address);
    }
}