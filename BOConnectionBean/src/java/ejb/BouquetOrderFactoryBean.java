
package ejb;

import java.util.Date;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Stateless
@Singleton
public class BouquetOrderFactoryBean implements BouquetOrderFactoryBeanRemote{

    public BouquetOrderFactoryBean(){
        
    }
    
    @Override
    public BouquetOrder getNewBouquetOrder(String customer, Date untilDate, Integer quantity, 
            Integer price, Integer moneySpend, Integer total, Status status, String wishes, String imgPath){
        return new BouquetOrder(customer, untilDate, quantity, price, moneySpend, total, status, wishes, imgPath);
    }
   
}
