//package ir.freeland.spring.usebean;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class InternetbankServices {
//
//	@Autowired
//    public void doCardToCard(String sourceCard, String destinationCard) {
//    CardServices cardService = new CardServices();
//    DatabaseManagment database = new DatabaseManagment();
//    
//    String result = cardService.cardToCard(sourceCard, destinationCard);
//    database.save( result );
//    
//  }
//}
package ir.freeland.spring.usebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternetbankServices {

    private final CardServices cardService;
    private final DatabaseManagment database;

    @Autowired
    public InternetbankServices(CardServices cardService, DatabaseManagment database) {
        this.cardService = cardService;
        this.database = database;
    }

    public void doCardToCard(String sourceCard, String destinationCard) {
        String result = cardService.cardToCard(sourceCard, destinationCard);
        database.save(result);
    }
}
