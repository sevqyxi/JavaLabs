import java.util.Comparator;

// Порівнює книги за видавництвом, а якщо воно однакове — за назвою
public class PublisherComparator implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
        int result = first.getPublisher().compareToIgnoreCase(second.getPublisher());
        if (result == 0) {
            result = first.getTitle().compareToIgnoreCase(second.getTitle());
        }
        return result;
    }
}