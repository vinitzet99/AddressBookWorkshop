package addressbookworkshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

    /**
     * Create Contact
     * assert values
     * @throws AddressBookException
     */
    @Test
    public void validateCreateContact_should_Have_Correct_Contact_Details() throws AddressBookException {
        AddressBook addressBook=new AddressBook();
        Contact c=addressBook.createContact("Abc","Abc","address","city","ST",900,"email@email.com",111111111);
        Assertions.assertEquals("Abc",c.getFirstName());
        Assertions.assertEquals("Abc",c.getLastName());
        Assertions.assertEquals("address",c.getAddress());
        Assertions.assertEquals("city",c.getCity());
        Assertions.assertEquals("ST",c.getState());
        Assertions.assertEquals(900,c.getZip());
        Assertions.assertEquals("email@email.com",c.getEmail());
    }
}
