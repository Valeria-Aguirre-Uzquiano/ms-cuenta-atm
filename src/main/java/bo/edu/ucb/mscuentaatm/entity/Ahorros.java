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
@Table(name = "ahorros")
@NamedQueries({
    @NamedQuery(name = "Ahorros.findAll", query = "SELECT a FROM Ahorros a"),
    @NamedQuery(name = "Ahorros.findBySaveId", query = "SELECT a FROM Ahorros a WHERE a.saveId = :saveId"),
    @NamedQuery(name = "Ahorros.findByAmount", query = "SELECT a FROM Ahorros a WHERE a.amount = :amount")})
public class Ahorros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "save_id")
    private Integer saveId;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saveId", fetch = FetchType.LAZY)
    private List<TransactionType> transactionTypeList;

    public Ahorros() {
    }

    public Ahorros(Integer saveId) {
        this.saveId = saveId;
    }

    public Integer getSaveId() {
        return saveId;
    }

    public void setSaveId(Integer saveId) {
        this.saveId = saveId;
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
        hash += (saveId != null ? saveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ahorros)) {
            return false;
        }
        Ahorros other = (Ahorros) object;
        if ((this.saveId == null && other.saveId != null) || (this.saveId != null && !this.saveId.equals(other.saveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.Ahorros[ saveId=" + saveId + " ]";
    }
    
}
