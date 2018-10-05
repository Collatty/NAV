//Created by Collatty 4/10-2018



public class SocialSecurityNumber extends validateSocialSecurityNumber{

    private String socialSecurityNumber;

    public SocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber=socialSecurityNumber.trim(); // Removing heading and trailing whitespaces with .trim()

    }

    public static void main(String[] args) {
        SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber("30049434959      ");
        socialSecurityNumber.validateSocialSecurityNumber(socialSecurityNumber.socialSecurityNumber);

    }
}
