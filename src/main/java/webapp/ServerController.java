package webapp;

import code.SocialSecurityNumber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ServerController {

    @RequestMapping("/")
    public String index(){
        return "Hello world!";
    }




    @RequestMapping("/validate")
    public String validation(@RequestParam("socialSecurityNumber")
                             String socialSecurityNumber) {

        SocialSecurityNumber ssn = new SocialSecurityNumber(socialSecurityNumber);

        try {
            ssn.validateSocialSecurityNumber(ssn.getSocialSecurityNumber());
            return "Gyldig fødselsnummer!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }


    }

}
