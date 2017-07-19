/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.Optional;
import javax.ejb.Remote;

/**
 *
 * @author shaldnikita
 */
@Remote
public interface ConnectionBeanRemote {
    boolean addElementToDB(BouquetOrder p);
    BouquetOrder getElementFromDB(String id);
    
    boolean updateField(Long id, Optional<String> wishes, Optional<Integer> moneySpent,
            Optional<Integer> total, Optional<String> path, Boolean isReady);
    
    boolean updateStatus(String id, Status status);
    boolean removeOrder(Long id);
    ArrayList<BouquetOrder> getBouquetOrderList();
}
