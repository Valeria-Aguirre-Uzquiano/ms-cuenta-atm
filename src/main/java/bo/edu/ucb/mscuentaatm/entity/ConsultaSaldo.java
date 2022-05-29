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
@Table(name = "consulta_saldo")
@NamedQueries({
    @NamedQuery(name = "ConsultaSaldo.findAll", query = "SELECT c FROM ConsultaSaldo c"),
    @NamedQuery(name = "ConsultaSaldo.findByBalId", query = "SELECT c FROM ConsultaSaldo c WHERE c.balId = :balId"),
    @NamedQuery(name = "ConsultaSaldo.findBySaldo", query = "SELECT c FROM ConsultaSaldo c WHERE c.saldo = :saldo")})
public class ConsultaSaldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bal_id")
    private Integer balId;
    @Column(name = "saldo")
    private Integer saldo;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "balId", fetch = FetchType.LAZY)
    private List<TransactionType> transactionTypeList;

    public ConsultaSaldo() {
    }

    public ConsultaSaldo(Integer balId) {
        this.balId = balId;
    }

    public Integer getBalId() {
        return balId;
    }

    public void setBalId(Integer balId) {
        this.balId = balId;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
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
        hash += (balId != null ? balId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaSaldo)) {
            return false;
        }
        ConsultaSaldo other = (ConsultaSaldo) object;
        if ((this.balId == null && other.balId != null) || (this.balId != null && !this.balId.equals(other.balId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.ConsultaSaldo[ balId=" + balId + " ]";
    }
    
}

