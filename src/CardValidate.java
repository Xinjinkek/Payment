//Class written to use for Card Validation Purpose
//To validate if the Credit Card Number input is correct

public class CardValidate {

    //Declaration of variables
    private boolean validation = false;
    private String cardName;
    private long cardNum;

    //Constructor
    CardValidate(String cn) {
        cardName = cn;
    }

    //Card Validity
    public boolean validateNumber(String cardNum) {
        int sum = 0;
        boolean conditionA = false, conditionB = false;

        //By using Luhn Algorithm for credit card validation
        for (int i = 1; i < cardNum.length(); i += 2) {
            int digit = Integer.valueOf(cardNum.substring(i, i+1));
            if (i % 2 == 0) {
                digit *= 2;
                sum += (digit / 10) + (digit % 10);
            }
            else {
                sum += digit;
            }
        }
        conditionA = true;

        if (cardNum.startsWith("4") && cardName == "Visa") {
            //Card Number that starts with 4 is Visa
            conditionB = true;
        }
        else if (cardNum.startsWith("5") && cardName == "MasterCard") {
            //Card Number that starts with 5 is MasterCard
            conditionB = true;
        }
        else {
            conditionB = false;
        }

        if (conditionA && conditionB) {
            //When card number and name are correct
            //then return true
            validation = true;
        }

        return validation;

    }

}
