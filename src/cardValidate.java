public class cardValidate {
    //declaration of variable
    private boolean validation = false;
    private String cardName;
    private long cardNum;

    //Constructor
    cardValidate(String cn)
    {
        cardName = cn;
    }

    //Card Validity
    public boolean validate(String cardNum)
    {
        int sum = 0;
        boolean conditionA = false, conditionB = false;

        for (int i = 1; i < cardNum.length(); i += 2)
        {
            int digit = Integer.valueOf(cardNum.substring(i, i+1));
            if (i % 2 == 0)
            {
                digit *= 2;
                sum += (digit / 10) + (digit % 10);
            }
            else
            {
                sum += digit;
            }
        }
        conditionA = true;

        if (cardNum.startsWith("4") && cardName == "Visa")
        {
            conditionB = true;
        }
        else if (cardNum.startsWith("5") && cardName == "MasterCard")
        {
            conditionB = true;
        }
        else
        {
            conditionB = false;
        }

        if (conditionA && conditionB)
        {
            validation = true;
        }

        return validation;

    }
}
