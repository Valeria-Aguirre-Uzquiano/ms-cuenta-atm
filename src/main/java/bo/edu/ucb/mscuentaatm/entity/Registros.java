package bo.edu.ucb.mscuentaatm.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Valeria Aguirre
 */
@Entity
@Table(name = "registros")
@NamedQueries({
    @NamedQuery(name = "Registros.findAll", query = "SELECT r FROM Registros r"),
    @NamedQuery(name = "Registros.findByRecordId", query = "SELECT r FROM Registros r WHERE r.recordId = :recordId"),
    @NamedQuery(name = "Registros.findByRecordDate", query = "SELECT r FROM Registros r WHERE r.recordDate = :recordDate")})
public class Registros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "record_id")
    private Integer recordId;
    @Basic(optional = false)
    @Column(name = "record_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Card cardId;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clientId;
    @JoinColumn(name = "typet_id", referencedColumnName = "typet_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TransactionType typetId;

    public Registros() {
    }

    public Registros(Integer recordId) {
        this.recordId = recordId;
    }

    public Registros(Integer recordId, Date recordDate) {
        this.recordId = recordId;
        this.recordDate = recordDate;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public Cliente getClientId() {
        return clientId;
    }

    public void setClientId(Cliente clientId) {
        this.clientId = clientId;
    }

    public TransactionType getTypetId() {
        return typetId;
    }

    public void setTypetId(TransactionType typetId) {
        this.typetId = typetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registros)) {
            return false;
        }
        Registros other = (Registros) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.Registros[ recordId=" + recordId + " ]";
    }
    
}
