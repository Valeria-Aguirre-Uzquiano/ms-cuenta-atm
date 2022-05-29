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
@Table(name = "deposito")
@NamedQueries({
    @NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d"),
    @NamedQuery(name = "Deposito.findByDepositId", query = "SELECT d FROM Deposito d WHERE d.depositId = :depositId"),
    @NamedQuery(name = "Deposito.findByAmount", query = "SELECT d FROM Deposito d WHERE d.amount = :amount")})
public class Deposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deposit_id")
    private Integer depositId;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depositId", fetch = FetchType.LAZY)
    private List<TransactionType> transactionTypeList;

    public Deposito() {
    }

    public Deposito(Integer depositId) {
        this.depositId = depositId;
    }

    public Integer getDepositId() {
        return depositId;
    }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
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
        hash += (depositId != null ? depositId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.depositId == null && other.depositId != null) || (this.depositId != null && !this.depositId.equals(other.depositId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.Deposito[ depositId=" + depositId + " ]";
    }
    
}

