import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddressBookFileIOService {

    public void write(List<PersonDetails> personDetailsList) {
        StringBuffer personContactBuffer = new StringBuffer();
        personDetailsList.forEach(person -> {
            String personDataString = person.toString().concat("\n");
            personContactBuffer.append(personDataString);
        });

        try {
            Files.write(Paths.get("person-contact-file.txt"), personContactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File("person-contact-file.txt").toPath()).forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public long countEntries() {
        long count = 0;
        try {
            count = Files.lines(new File("person-contact-file.txt").toPath()).count();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return count;
    }
}
