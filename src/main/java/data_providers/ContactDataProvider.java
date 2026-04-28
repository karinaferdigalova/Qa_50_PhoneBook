package data_providers;

import dto.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List;


    public class ContactDataProvider {
        @DataProvider
        public Iterator<Contact> dataProviderFile() {
            List<Contact> contactList = new ArrayList<> ();
            try (BufferedReader bufferedReader = new BufferedReader
                    (new FileReader("src/test/resources/dataContact.csv"))) {
                String line = bufferedReader.readLine ();
                while (line != null) {
                    String[] splitArray = line.split (",");
                    contactList.add (Contact.builder ()
                            .name (splitArray[0])
                            .lastName (splitArray[1])
                            .email (splitArray[2])
                            .phone (splitArray[3])
                            .address (splitArray[4])
                            .description (splitArray[5])
                            .build ());
                    line = bufferedReader.readLine ();
                }
            } catch (IOException e) {
                e.printStackTrace ();//просто выводит ошибку в консоль (для дебага)
                throw new RuntimeException ("IO exception");
            }
            return contactList.listIterator ();
        }
    }

//    @DataProvider
//    public Iterator<Contact> dataProviderFile() {
//        List<Contact> contactList = new ArrayList<> ();
//
//        try {
//            InputStream is = getClass ().getClassLoader ().getResourceAsStream ("src/test/сsv/dataContact.csv");
//
//            if (is == null) {
//                throw new RuntimeException ("File not found: src/test/сsv/dataContact.csv");
//            }
//
//            BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (is));
//
//            String line = bufferedReader.readLine (); // skip header
//
//            while ((line = bufferedReader.readLine ()) != null) {
//
//                if (line.trim ().isEmpty ()) continue;
//
//                String[] splitArray = line.split (",");
//
//                if (splitArray.length < 6) continue;
//
//                contactList.add (Contact.builder ()
//                        .name (splitArray[0])
//                        .lastName (splitArray[1])
//                        .email (splitArray[2])
//                        .phone (splitArray[3])
//                        .address (splitArray[4])
//                        .description (splitArray[5])
//                        .build ());
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException ("IO exception", e);
//        }
//
//        System.out.println("Contacts loaded: " + contactList.size());
//        return contactList.iterator ();
//    }
//}

//dataProviderFile() — это генератор тестовых данных.
//Он должен:
//Взять данные (из CSV файла у меня)
//Превратить их в объекты Contact
//Отдать их тесту
