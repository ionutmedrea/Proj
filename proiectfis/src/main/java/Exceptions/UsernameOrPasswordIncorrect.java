package Exceptions;

public class UsernameOrPasswordIncorrect extends Exception {

    public UsernameOrPasswordIncorrect() {
        super("The username or the password you inserted is incorrect!");
    }

}
