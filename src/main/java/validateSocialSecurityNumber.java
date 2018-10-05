//Created by Collatty 4/10-2018

import org.apache.commons.lang3.StringUtils;



// Abstract in case of reuse and let
abstract public class validateSocialSecurityNumber {

    //Check if social security number is long enough
    public void validateLength(String socialSecurityNumber){
        if (socialSecurityNumber.length() != 11) {
            throw new IllegalArgumentException("Social security number has to be eleven numbers, and not separated by spaces!");
        }
    }
    //Check if social security number contains non-numeric chars
    public void validateNumeric(String socialSecurityNumber){
        if (!StringUtils.isNumeric(socialSecurityNumber)) {
            throw new IllegalArgumentException("Please make sure you have only inserted numbers");
        }
    }

    //Birthday as in DAY OF MONTH
    public int validateBirthDay(String socialSecurityNumber){
        int day = Integer.parseInt(socialSecurityNumber.substring(0,2));
        if (day < 1 || day > 31) { //Standardsjekk antall dager
            throw new IllegalArgumentException("Invalid day");
        }
        return day;
    }
    //Has to be 12 or lower
    public int validateBirthMonth(String socialSecurityNumber){
        int month = Integer.parseInt(socialSecurityNumber.substring(2,4));
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month!");
        }
        return month;
    }

    private int getYear(String socialSecurityNumber){
        return Integer.parseInt(socialSecurityNumber.substring(4,6));
    }

    //Valid day in corresponding month and year?
    public void validateBirthDate(String socialSecurityNumber){
        int month = validateBirthMonth(socialSecurityNumber);
        int day = validateBirthDay(socialSecurityNumber);
        // All years are valid so, no need to test them individually.
        int year = getYear(socialSecurityNumber);
        boolean isLeapYear = (year%4 == 0);
        if (day == 31) {
            switch (month) {
                case 2:
                    throw new IllegalArgumentException("Not enough days in that month!");
                case 4:
                    throw new IllegalArgumentException("Not enough days in that month!");
                case 6:
                    throw new IllegalArgumentException("Not enough days in that month!");
                case 9:
                    throw new IllegalArgumentException("Not enough days in that month!");
                case 11:
                    throw new IllegalArgumentException("Not enough days in that month!");
            }
        } else if (day == 30 && month == 2) {
            throw new IllegalArgumentException("Not enough days in that month!");
        } else if (day == 29 && month == 2 && !isLeapYear){
            throw new IllegalArgumentException("Not a leap year!");
        }else if (day == 28 && month != 2) {
            throw new IllegalArgumentException("Only February contains 28 days!");
        }

    }

    public void validateIndividualNumbers(String socialSecurityNumber) {
        int year = getYear(socialSecurityNumber);
        int individualNumbers = Integer.parseInt(socialSecurityNumber.substring(6,9));

        //if individualNumbers 000-499 || 900-999 all birth years are valid
        //if individualNumbers 500-749 birth years 00-39 && 54-99 are valid
        //if individualNumbers 750-899 birth years 00-39 are valid

        if ((499 < individualNumbers  && individualNumbers < 750) && ( year < 54 && year > 39 )) {
            throw new IllegalArgumentException("Invalid individual numbers given your birth year!");
        } else if ((750 < individualNumbers  && individualNumbers < 900) && ( year < 39 )){
            throw new IllegalArgumentException("Invalid individual numbers given your birth year!");
        }
    }

    public void validateFirstControlCipher(String socialSecurityNumber){
        // Formula from wikipedia
        int controlCipher = 11
                - (((3 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(0))))
                + (7 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(1))))
                + (6 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(2))))
                + (Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(3))))
                + (8 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(4))))
                + (9 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(5))))
                + (4 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(6))))
                + (5 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(7))))
                + (2 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(8)))))
                %11);
        if (!(controlCipher == Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(9))))){
            throw new IllegalArgumentException("The first control cipher is invalid!");
        }
    }

    public void validateSecondControlCipher(String socialSecurityNumber){
        // Formula from wikipedia
        int controlCipher = 11
                - (((5 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(0))))
                + (4 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(1))))
                + (3 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(2))))
                + (2 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(3))))
                + (7 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(4))))
                + (6 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(5))))
                + (5 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(6))))
                + (4 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(7))))
                + (3 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(8))))
                + (2 * Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(9)))))
                %11
        );

        if (!(controlCipher == Integer.parseInt(String.valueOf(socialSecurityNumber.charAt(10))))){
            throw new IllegalArgumentException("The second control cipher is invalid!");
        }
    }

    public void validatePersonalNumber(String socialSecurityNumber) {
        validateIndividualNumbers(socialSecurityNumber);
        validateFirstControlCipher(socialSecurityNumber);
        validateSecondControlCipher(socialSecurityNumber);
    }

    public void validateSocialSecurityNumber(String socialSecurityNumber) {
        validateBirthDate(socialSecurityNumber);
        validatePersonalNumber(socialSecurityNumber);
    }
}


