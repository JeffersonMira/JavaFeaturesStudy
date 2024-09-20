package personal.trainings.interview.passwordGenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordGenerator
{

    /**
     * Generate random password satisfying password complexity policy.
     *
     * Policy defines number of alphabetic characters and digits that must
     * be present in the password.
     *
     * Here are some examples of generated password for characters = 3 and digits = 1:
     *
     * <p>G6KK</p>
     * <p>5PUi</p>
     * <p>mBq9</p>
     *
     * @param characters number of characters that password must have
     * @param digits number of digits that password must have
     * @return
     */
    public String generatePassword( int characters, int digits )
    {
        if(characters < 0 || digits < 0){
            throw new IllegalArgumentException("Number of characters or digits cant be negative.");
        }

        //1) define the list of characters that can be included in the password
        char[] possibleChars = new char[]{'a', 'b','c'};
        List<String> passwordSuggestion = new ArrayList<>();

        //2) Using random generate indexes that I can fetch from my list of characters
        for(int i = 0; i < characters; i++){
            passwordSuggestion.add(String.valueOf(possibleChars[this.getRandom(0, possibleChars.length)]));
        }

        //3) Get the number of digits that the user asked for
        //4) get random indexes for to insert the digits into the character list
        for(int i  = 0; i < digits; i++){
            if(passwordSuggestion.size() > 0 ){
                passwordSuggestion.add(getRandom(0, passwordSuggestion.size()), String.valueOf(getRandom(0, 10)));
            }else{
                passwordSuggestion.add(String.valueOf(getRandom(0, 10)));
            }
        }

        return passwordSuggestion.stream().collect(Collectors.joining());
    }

    private int getRandom(int fromInclusive, int toExclusive)
    {
        return new SecureRandom().nextInt(toExclusive - fromInclusive) + fromInclusive;
    }

    public static void main(String[] args) {
        PasswordGenerator pg= new PasswordGenerator();
        System.out.println(pg.generatePassword(0, 3));
    }

}

