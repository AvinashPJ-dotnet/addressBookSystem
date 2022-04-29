import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class OpenCsvWriter {
    public void writeToCSV(ArrayList<PersonDetails> listContactDetails) throws IOException {
        Writer writer = null;
        try {
            writer = new FileWriter("./address-book-Csv.csv");
            {
                StatefulBeanToCsvBuilder<PersonDetails> builder = new StatefulBeanToCsvBuilder<>(writer);
                StatefulBeanToCsv<PersonDetails> beanWriter = builder.withQuotechar(CSVWriter.NO_ESCAPE_CHARACTER).build();
                beanWriter.write(listContactDetails);
            }
        } catch (IOException ignored) {
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } finally {
            assert writer != null;
            writer.close();
        }
    }
}
