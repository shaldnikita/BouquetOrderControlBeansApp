/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author shaldnikita
 */
@Remote
public interface BouquetOrderFactoryBeanRemote {
    BouquetOrder getNewBouquetOrder(String customer, Date untilDate, Integer quantity, 
            Integer price, Integer moneySpend, Integer total, Status status, String wishes, String imgPath);
}
