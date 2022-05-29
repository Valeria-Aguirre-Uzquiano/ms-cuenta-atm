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
 * @author Win10Pro
 */
@Entity
@Table(name = "transaction_type")
@NamedQueries({
    @NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t"),
    @NamedQuery(name = "TransactionType.findByTypetId", query = "SELECT t FROM TransactionType t WHERE t.typetId = :typetId")})
public class TransactionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "typet_id")
    private Integer typetId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typetId", fetch = FetchType.LAZY)
    private List<Registros> registrosList;
    @JoinColumn(name = "save_id", referencedColumnName = "save_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ahorros saveId;
    @JoinColumn(name = "bal_id", referencedColumnName = "bal_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConsultaSaldo balId;
    @JoinColumn(name = "deposit_id", referencedColumnName = "deposit_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Deposito depositId;
    @JoinColumn(name = "with_id", referencedColumnName = "with_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Retiro withId;

    public TransactionType() {
    }

    public TransactionType(Integer typetId) {
        this.typetId = typetId;
    }

    public Integer getTypetId() {
        return typetId;
    }

    public void setTypetId(Integer typetId) {
        this.typetId = typetId;
    }

    public List<Registros> getRegistrosList() {
        return registrosList;
    }

    public void setRegistrosList(List<Registros> registrosList) {
        this.registrosList = registrosList;
    }

    public Ahorros getSaveId() {
        return saveId;
    }

    public void setSaveId(Ahorros saveId) {
        this.saveId = saveId;
    }

    public ConsultaSaldo getBalId() {
        return balId;
    }

    public void setBalId(ConsultaSaldo balId) {
        this.balId = balId;
    }

    public Deposito getDepositId() {
        return depositId;
    }

    public void setDepositId(Deposito depositId) {
        this.depositId = depositId;
    }

    public Retiro getWithId() {
        return withId;
    }

    public void setWithId(Retiro withId) {
        this.withId = withId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typetId != null ? typetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionType)) {
            return false;
        }
        TransactionType other = (TransactionType) object;
        if ((this.typetId == null && other.typetId != null) || (this.typetId != null && !this.typetId.equals(other.typetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.TransactionType[ typetId=" + typetId + " ]";
    }
    
}
