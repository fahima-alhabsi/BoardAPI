package Controllers;

import Reposetries.CardRepositry;
import Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CardController {
    @Autowired
    CardService cardService ;
}
