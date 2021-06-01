import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate {

    public boolean eValidate(String email){
        boolean validate = false;

        String email_Pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[_A-Za-z0-9-]{2,})$";

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
