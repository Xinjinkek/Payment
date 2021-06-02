import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate {

    //To validate user input Email Address
    public boolean eValidate(String email){

        //Declaration of variable
        boolean validate = false;

        //Regex validation of pattern for user input
        String email_Pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[_A-Za-z0-9-]{2,})$";

        //Pattern and Match to determine the email address
        Pattern attributes = Pattern.compile(email_Pattern);
        Matcher emailEqual = attributes.matcher(email);

        if(emailEqual.matches()){
            validate = true;
        }
        else {
            validate = false;
        }

        return validate;

    }

}
