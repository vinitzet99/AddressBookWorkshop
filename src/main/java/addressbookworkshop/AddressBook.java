/**
 * @uthor: Vinit Kumar
 * @created on: 08-Feb-2021
 * Address Book Workshop
 */
package addressbookworkshop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
    /**
     * Display Welcome message
     */
    public static void message() {
        System.out.println("Welcome To AddressBook");
    }
    /**
     * checks if Start name is Caps and is at least of 3 length
     *
     * @param name
     * @return
     */
    public Boolean isValidName(String name) throws AddressBookException {
        if (name == null || name == "") {
            throw new AddressBookException("Invalid Input");
        } else {
            String regex = "^[A-Z][a-z]{2,}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(name);
            return m.matches();
        }
    }
    /**
     * check email valid
     * abc,bl,co is mandatory
     * xyz,in is not mandatory
     *
     * @param email
     * @return
     */
    public Boolean isValidEmail(String email) throws AddressBookException {
        if (email == null || email == "") {
            throw new AddressBookException("Invalid Input");
        } else {
            String regex = "^[a-zA-Z0-9_+-]+([.][a-zA-Z0-9]+)*@[0-9a-zA-Z]+[.][a-zA-Z]{2,}+([.][a-zA-Z]{2,})?$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(email);
            return m.matches();
        }
    }

    /**
     * Creates contact
     * validate Firstname
     * Validate Lastname
     * Validate Email
     * return new Contact or null Contact
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param email
     * @param phoneNumber
     * @return
     * @throws AddressBookException
     */
    public Contact createContact(String firstName,String lastName,String address, String city, String state,int zip,
                              String email,long phoneNumber) throws AddressBookException {
        AddressBook addressBook=new AddressBook();
        Boolean validFirst=addressBook.isValidName(firstName);
        Boolean validLast=addressBook.isValidName(lastName);
        Boolean validEmail=addressBook.isValidEmail(email);
        if(validEmail && validLast && validFirst) {
            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
            return contact;
        }
        else{
            Contact contact=new Contact("","","","","",-1,-1,"");
            return contact;
        }
    }

    public static void main(String[] args) {
        message();
    }
}
