//Created by Collatty 4/10-2018



public class SocialSecurityNumber extends ValidateSocialSecurityNumber {

    private String socialSecurityNumber;

    public SocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber=socialSecurityNumber.trim(); // Removing heading and trailing whitespaces with .trim()

    }

    public String getSocialSecurityNumber(){
        return this.socialSecurityNumber;
    }

}
