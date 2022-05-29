package bo.edu.ucb.mscuentaatm.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Valeria Aguirre
 */
@Entity
@Table(name = "retiro")
@NamedQueries({
    @NamedQuery(name = "Retiro.findAll", query = "SELECT r FROM Retiro r"),
    @NamedQuery(name = "Retiro.findByWithId", query = "SELECT r FROM Retiro r WHERE r.withId = :withId"),
    @NamedQuery(name = "Retiro.findByAmount", query = "SELECT r FROM Retiro r WHERE r.amount = :amount")})
public class Retiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "with_id")
    private Integer withId;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "withId", fetch = FetchType.LAZY)
    private List<TransactionType> transactionTypeList;

    public Retiro() {
    }

    public Retiro(Integer withId) {
        this.withId = withId;
    }

    public Integer getWithId() {
        return withId;
    }

    public void setWithId(Integer withId) {
        this.withId = withId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Cliente getClientId() {
        return clientId;
    }

    public void setClientId(Cliente clientId) {
        this.clientId = clientId;
    }

    public List<TransactionType> getTransactionTypeList() {
        return transactionTypeList;
    }

    public void setTransactionTypeList(List<TransactionType> transactionTypeList) {
        this.transactionTypeList = transactionTypeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (withId != null ? withId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retiro)) {
            return false;
        }
        Retiro other = (Retiro) object;
        if ((this.withId == null && other.withId != null) || (this.withId != null && !this.withId.equals(other.withId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.Retiro[ withId=" + withId + " ]";
    }
    
}

