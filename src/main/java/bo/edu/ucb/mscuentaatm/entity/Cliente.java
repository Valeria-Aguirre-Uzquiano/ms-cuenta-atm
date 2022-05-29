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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClientId", query = "SELECT c FROM Cliente c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Cliente.findByFirstName", query = "SELECT c FROM Cliente c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Cliente.findByLastName", query = "SELECT c FROM Cliente c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Cliente.findByGender", query = "SELECT c FROM Cliente c WHERE c.gender = :gender"),
    @NamedQuery(name = "Cliente.findByClientAge", query = "SELECT c FROM Cliente c WHERE c.clientAge = :clientAge"),
    @NamedQuery(name = "Cliente.findByAddress", query = "SELECT c FROM Cliente c WHERE c.address = :address")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "client_age")
    private Integer clientAge;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Card cardId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<ConsultaSaldo> consultaSaldoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<Credito> creditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<Registros> registrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<Ahorros> ahorrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<Deposito> depositoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<Retiro> retiroList;

    public Cliente() {
    }

    public Cliente(Integer clientId) {
        this.clientId = clientId;
    }

    public Cliente(Integer clientId, String address) {
        this.clientId = clientId;
        this.address = address;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getClientAge() {
        return clientAge;
    }

    public void setClientAge(Integer clientAge) {
        this.clientAge = clientAge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public List<ConsultaSaldo> getConsultaSaldoList() {
        return consultaSaldoList;
    }

    public void setConsultaSaldoList(List<ConsultaSaldo> consultaSaldoList) {
        this.consultaSaldoList = consultaSaldoList;
    }

    public List<Credito> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Credito> creditoList) {
        this.creditoList = creditoList;
    }

    public List<Registros> getRegistrosList() {
        return registrosList;
    }

    public void setRegistrosList(List<Registros> registrosList) {
        this.registrosList = registrosList;
    }

    public List<Ahorros> getAhorrosList() {
        return ahorrosList;
    }

    public void setAhorrosList(List<Ahorros> ahorrosList) {
        this.ahorrosList = ahorrosList;
    }

    public List<Deposito> getDepositoList() {
        return depositoList;
    }

    public void setDepositoList(List<Deposito> depositoList) {
        this.depositoList = depositoList;
    }

    public List<Retiro> getRetiroList() {
        return retiroList;
    }

    public void setRetiroList(List<Retiro> retiroList) {
        this.retiroList = retiroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.Cliente[ clientId=" + clientId + " ]";
    }
    
}
