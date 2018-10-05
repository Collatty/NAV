import org.junit.Assert;
import org.junit.Test;

public class ValidateSocialSecurityNumberTest {


    @Test //See if length of input gets validated correctly
    public void testValidLength(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981"); //SSN generated at http://prag.matisk.com/ssn/
        try {
            validSSN.validateLength(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class) //See if length of input gets validated correctly
    public void testInvalidLength(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("123456789101112");
        invalidSSN.validateLength(invalidSSN.getSocialSecurityNumber());
    }

    @Test //See if type of input gets validated correctly
    public void testValidCharacters(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981");
        try {
            validSSN.validateNumeric(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class) //See if type of input gets validated correctly
    public void testInvalidCharacters(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("12345plopp101112");
        invalidSSN.validateNumeric(invalidSSN.getSocialSecurityNumber());
    }

    @Test //See if birth day gets validated correctly
    public void testValidBirthDay(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981");
        try {
            validSSN.validateBirthDay(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class) //See if birth day gets validated correctly
    public void testInvalidBirthDay(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("40038749981");
        invalidSSN.validateBirthDay(invalidSSN.getSocialSecurityNumber());
    }

    @Test //See if birth month gets validated correctly
    public void testValidBirthMonth(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981");
        try {
            validSSN.validateBirthMonth(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class) //See if birth month gets validated correctly
    public void testInvalidBirthMonth(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("10138749981");
        invalidSSN.validateBirthMonth(invalidSSN.getSocialSecurityNumber());
    }

    @Test //Test corresponding days, months and years
    public void testValidBirthDate(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981");
        try {
            validSSN.validateBirthDate(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test //Test corresponding days, months and years
    public void testValidBirthDateEnoughDays(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("31058749981");
        try {
            validSSN.validateBirthDate(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test //Test corresponding days, months and years
    public void testValidBirthDateLeapYear(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("29029649981");
        try {
            validSSN.validateBirthDate(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test //Test corresponding days, months and years
    public void testValidBirthDateNormalFebruary(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("28028749981");
        try {
            validSSN.validateBirthDate(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class) //Test corresponding days, months and years
    public void testInvalidBirthDateTooFewDays(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("31118749981");
        invalidSSN.validateBirthDate(invalidSSN.getSocialSecurityNumber());
    }

    @Test (expected = IllegalArgumentException.class) //Test corresponding days, months and years
    public void testInvalidBirthDateTooFewDaysFebruary(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("30028749981");
        invalidSSN.validateBirthDate(invalidSSN.getSocialSecurityNumber());
    }

    @Test (expected = IllegalArgumentException.class) //Test corresponding days, months and years
    public void testInvalidBirthDateLeapYear(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("29029449981");
        invalidSSN.validateBirthDate(invalidSSN.getSocialSecurityNumber());
    }

    @Test //See if individual numbers are evaluated correctly  -  test for 000-499
    public void testValidIndividualNumbers000(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981");
        try {
            validSSN.validateIndividualNumbers(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test //See if individual numbers are evaluated correctly  -  test for 500-749
    public void testValidIndividualNumbers500(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("12028750181");
        try {
            validSSN.validateIndividualNumbers(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test //See if individual numbers are evaluated correctly  -  test for 750-899
    public void testValidIndividualNumbers750(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("12022480081");
        try {
            validSSN.validateIndividualNumbers(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class) //See if individual numbers are evaluated correctly  -  test for 500-749
    public void testInvalidIndividualNumbers500(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("29024050181");
        invalidSSN.validateIndividualNumbers(invalidSSN.getSocialSecurityNumber());
    }

    @Test (expected = IllegalArgumentException.class) //See if individual numbers are evaluated correctly  -  test for 500-749
    public void testInvalidIndividualNumbers750(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("29024080081");
        invalidSSN.validateIndividualNumbers(invalidSSN.getSocialSecurityNumber());
    }


    @Test //See if first control cipher is evaluated correctly
    public void testValidFirstControlCipher(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981");
        try {
            validSSN.validateFirstControlCipher(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class)  //See if first control cipher is evaluated correctly
    public void testInvalidFirstControlCipher(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("10038749931");
        invalidSSN.validateFirstControlCipher(invalidSSN.getSocialSecurityNumber());
    }


    @Test //See if second control cipher is evaluated correctly
    public void testValidSecondControlCipher(){
        SocialSecurityNumber validSSN = new SocialSecurityNumber("10038749981");
        try {
            validSSN.validateSecondControlCipher(validSSN.getSocialSecurityNumber());
            //Pass
        } catch (IllegalArgumentException e) {
            Assert.fail("Should not have thrown IAE!");
        }
    }

    @Test (expected = IllegalArgumentException.class) //See if second control cipher is evaluated correctly
    public void testInvalidSecondControlCipher(){
        SocialSecurityNumber invalidSSN = new SocialSecurityNumber("10038749982");
        invalidSSN.validateSecondControlCipher(invalidSSN.getSocialSecurityNumber());
    }














}
