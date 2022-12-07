package utils.web.helpers;

import java.util.Random;

public class User {
    private String FirstName;
    private String LastName;
    private String email;
    private String password;

    public User() {
        this.FirstName = "Test";
        this.LastName = "Account";
        this.email = randomizeEmail();
        this.password = "S4f3Pas5w0rD & 1332";
    }

    public String randomizeEmail(){
        Random random = new Random();
        String email = "fake";
        int randomizer = random.nextInt(99999);
        randomizer += 10;
        return email + randomizer + "@fakemail.com";
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
