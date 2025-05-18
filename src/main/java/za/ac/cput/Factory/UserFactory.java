package za.ac.cput.Factory;
+
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {
    
    public static User createUser(String userId, String firstName, String lastName, Long idNumber, String phoneNumber, String email, String password){

        if(Helper.isNullOrEmpty(userId))
            return null;
        if(Helper.isNullOrEmpty(firstName))
            return null;
        if(Helper.isNullOrEmpty(lastName))
            return null;
        if(Helper.isNullOrEmpty(email))
            return null;
        if(Helper.isNullOrEmpty(phoneNumber))
            return null;
        if(Helper.isNullOrEmpty(password))
            return null;
        if(Helper.isNullOrEmpty(idNumber)|| !Helper.isValid(idNumber))
            return null;


        return new User.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setPassword(password)
                .setIdNumber(idNumber)
                .build();
    }
}
