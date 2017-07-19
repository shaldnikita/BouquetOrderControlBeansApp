package ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@NamedQuery(name = "getBouquetOrderList", query = "SELECT e FROM BouquetOrder e")
public class BouquetOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String customer;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date doUntil;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "price", nullable = false)
    private Integer price;
    private Integer moneySpent;
    private Integer total;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String wishes;
    private String imgPath;

    public BouquetOrder() {
    }

    public BouquetOrder(String customer, Date untilDate, Integer quantity, Integer price, Integer moneySpend,
            Integer total, Status status, String wishes, String imgPath) {
        this.customer = customer;
        this.doUntil = untilDate;
        this.quantity = quantity;
        this.price = price;
        this.moneySpent = moneySpend;
        this.total = total;
        this.status = status;
        this.wishes = wishes;
        this.imgPath = imgPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDoUntil() {
        return doUntil;
    }

    public void setDoUntil(Date doUntil) {
        this.doUntil = doUntil;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(Integer moneySpent) {
        this.moneySpent = moneySpent;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BouquetOrder)) {
            return false;
        }
        BouquetOrder other = (BouquetOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order №" + id + " for " + customer + " until " + doUntil;
    }

}
