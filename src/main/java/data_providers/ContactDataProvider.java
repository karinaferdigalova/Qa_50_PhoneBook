package data_providers;

import dto.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List;

import static utils.ContactFactory.*;


public class ContactDataProvider {
    @DataProvider
    public Iterator<Contact> dataProviderFile() {
        List<Contact> contactList = new ArrayList<> ();
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader ("src/test/resources/dataContact.csv"))) {
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

    @DataProvider
    public Iterator<Contact> dataProviderFileWrongNumber() {
        List<Contact> contactList = new ArrayList<> ();
        Contact contact = positiveContact ();
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader ("src/test/resources/pb_wrongNumber.csv"))) {
            String line = bufferedReader.readLine ();
            while (line != null) {
                contactList.add (Contact.builder ()
                        .name (contact.getName ())
                        .lastName (contact.getLastName ())
                        .email (contact.getEmail ())
                        .phone (line)
                        .address (contact.getAddress ())
                        .description (contact.getDescription ())
                        .build ());
                line = bufferedReader.readLine ();
            }
        } catch (IOException e) {
            e.printStackTrace ();//просто выводит ошибку в консоль (для дебага)
            throw new RuntimeException ("IO exception");
        }
        return contactList.listIterator ();
    }
    @DataProvider
    public Iterator<Contact> dataProviderEmptyFields() {
        List<Contact> contactList = new ArrayList<> ();
        Contact contact = positiveContact ();
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader ("src/test/resources/invalidDataFields.csv"))) {
            String line = bufferedReader.readLine ();
            while (line != null) {
                String[] splitArray = line.split (",",-1);
                contactList.add (Contact.builder ()
                        .name (splitArray[0])
                        .lastName (splitArray[1])
                        .email (contact.getEmail ())
                        .phone (contact.getPhone ())
                        .address (splitArray[2])
                        .description (contact.getDescription ())
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


//dataProviderFile() — это генератор тестовых данных.
//Он должен:
//Взять данные (из CSV файла у меня)
//Превратить их в объекты Contact
//Отдать их тесту
