import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class OpenCsvAndGsonWriter {
    public static final String ADDRESS_BOOK_CSV_PATH = "./address-book-Csv.csv";
    public static final String ADDRESS_BOOK_JSON_PATH = "./address-book-Csv.json";


    public void writeToCSV(ArrayList<PersonDetails> listContactDetails) throws IOException {
        Writer writer = null;
        try {
            writer = new FileWriter(ADDRESS_BOOK_CSV_PATH);
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

//    public void writeToJson(){
//        try {
//            BufferedReader reader = Files.newBufferedReader(Paths.get(ADDRESS_BOOK_CSV_PATH));
//            CSVReader csvReader = new CSVReader(reader);
//
//            {
//                CsvToBeanBuilder<PersonDetails> csvToBeanBuilder = new CsvToBeanBuilder<>(csvReader);
//                csvToBeanBuilder.withType(PersonDetails.class);
//                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
//                csvToBeanBuilder.withSkipLines(1);
//                CsvToBean<PersonDetails> csvToBean = csvToBeanBuilder.build();
//                List<PersonDetails> parsePersonDetail = csvToBean.parse();
//                Gson gson = new Gson();
//                String jsonPersonDetails = gson.toJson(parsePersonDetail);
//                FileWriter fileWriter = new FileWriter(ADDRESS_BOOK_JSON_PATH);
//                fileWriter.write(jsonPersonDetails);
//                fileWriter.close();
//            }
//        }catch (IOException ignore){
//
//        }
//    }

    public void writeToJson(ArrayList<PersonDetails> listContactDetails){
        try(Writer writer = new FileWriter(ADDRESS_BOOK_JSON_PATH)){

            JSONObject jsonAddressBookObject = new JSONObject();
            JSONArray jsonArr = new JSONArray();
            for (PersonDetails person :
                    listContactDetails) {
                JSONObject object = new JSONObject();
                object.put("FirstName",  person.getFirstName());
                object.put("LastName", person.getLastName());
                object.put("Address", person.getAddress());
                object.put("City", person.getCity());
                object.put("State", person.getState());
                object.put("Zip", person.getZip());
                object.put("PhoneNumber",person.getPhone());
                object.put("Email", person.getEmail());
                jsonArr.put(object);
            }

            jsonAddressBookObject.put("book",jsonArr);
            writer.write(jsonAddressBookObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
