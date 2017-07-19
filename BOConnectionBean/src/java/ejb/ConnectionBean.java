package ejb;

import java.util.ArrayList;
import java.util.Optional;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author ShaldNikita
 */
@Startup
@Stateless
@Singleton
@DependsOn("BouquetOrderFactoryBean")
public class ConnectionBean implements ConnectionBeanRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean addElementToDB(BouquetOrder p) {
        try {
            em.persist(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BouquetOrder getElementFromDB(String id) {
        BouquetOrder p;
        p = em.find(BouquetOrder.class, id);
        return p;
    }

    @Override
    public boolean updateField(Long id, Optional<String> wishes, Optional<Integer> moneySpent, Optional<Integer> total, Optional<String> path, Boolean isReady) {
        BouquetOrder order;
        try {
            order = em.getReference(BouquetOrder.class, id);
            order.setWishes(wishes.orElse(null));
            order.setMoneySpent(moneySpent.orElse(null));
            order.setTotal(total.orElse(null));
            order.setImgPath(path.orElse(null));
            order.setStatus(isReady ? Status.Ready : Status.Accepted);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStatus(String id, Status status) {
        BouquetOrder order;
        try {
            order = em.getReference(BouquetOrder.class, id);
            order.setStatus(status);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeOrder(Long id) {
        BouquetOrder order;
        try {
            order = em.getReference(BouquetOrder.class, id);
            em.remove(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<BouquetOrder> getBouquetOrderList() {
        return new ArrayList(em.createNamedQuery("getBouquetOrderList", BouquetOrder.class).getResultList());
    }
}
