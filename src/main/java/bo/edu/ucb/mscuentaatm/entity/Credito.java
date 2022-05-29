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
@Table(name = "credito")
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c"),
    @NamedQuery(name = "Credito.findByCreditoId", query = "SELECT c FROM Credito c WHERE c.creditoId = :creditoId"),
    @NamedQuery(name = "Credito.findByGarante", query = "SELECT c FROM Credito c WHERE c.garante = :garante"),
    @NamedQuery(name = "Credito.findByIngreso", query = "SELECT c FROM Credito c WHERE c.ingreso = :ingreso"),
    @NamedQuery(name = "Credito.findByCantidadt", query = "SELECT c FROM Credito c WHERE c.cantidadt = :cantidadt"),
    @NamedQuery(name = "Credito.findByCantidadf", query = "SELECT c FROM Credito c WHERE c.cantidadf = :cantidadf"),
    @NamedQuery(name = "Credito.findByCuotas", query = "SELECT c FROM Credito c WHERE c.cuotas = :cuotas"),
    @NamedQuery(name = "Credito.findByCuotasr", query = "SELECT c FROM Credito c WHERE c.cuotasr = :cuotasr"),
    @NamedQuery(name = "Credito.findByCutpasp", query = "SELECT c FROM Credito c WHERE c.cutpasp = :cutpasp"),
    @NamedQuery(name = "Credito.findByFechac", query = "SELECT c FROM Credito c WHERE c.fechac = :fechac"),
    @NamedQuery(name = "Credito.findByInmueble", query = "SELECT c FROM Credito c WHERE c.inmueble = :inmueble")})
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credito_id")
    private Integer creditoId;
    @Column(name = "garante")
    private String garante;
    @Column(name = "ingreso")
    private Integer ingreso;
    @Basic(optional = false)
    @Column(name = "cantidadt")
    private int cantidadt;
    @Column(name = "cantidadf")
    private Integer cantidadf;
    @Basic(optional = false)
    @Column(name = "cuotas")
    private int cuotas;
    @Column(name = "cuotasr")
    private Integer cuotasr;
    @Column(name = "cutpasp")
    private Integer cutpasp;
    @Column(name = "fechac")
    @Temporal(TemporalType.DATE)
    private Date fechac;
    @Column(name = "inmueble")
    private String inmueble;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clientId;

    public Credito() {
    }

    public Credito(Integer creditoId) {
        this.creditoId = creditoId;
    }

    public Credito(Integer creditoId, int cantidadt, int cuotas) {
        this.creditoId = creditoId;
        this.cantidadt = cantidadt;
        this.cuotas = cuotas;
    }

    public Integer getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(Integer creditoId) {
        this.creditoId = creditoId;
    }

    public String getGarante() {
        return garante;
    }

    public void setGarante(String garante) {
        this.garante = garante;
    }

    public Integer getIngreso() {
        return ingreso;
    }

    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }

    public int getCantidadt() {
        return cantidadt;
    }

    public void setCantidadt(int cantidadt) {
        this.cantidadt = cantidadt;
    }

    public Integer getCantidadf() {
        return cantidadf;
    }

    public void setCantidadf(Integer cantidadf) {
        this.cantidadf = cantidadf;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Integer getCuotasr() {
        return cuotasr;
    }

    public void setCuotasr(Integer cuotasr) {
        this.cuotasr = cuotasr;
    }

    public Integer getCutpasp() {
        return cutpasp;
    }

    public void setCutpasp(Integer cutpasp) {
        this.cutpasp = cutpasp;
    }

    public Date getFechac() {
        return fechac;
    }

    public void setFechac(Date fechac) {
        this.fechac = fechac;
    }

    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }

    public Cliente getClientId() {
        return clientId;
    }

    public void setClientId(Cliente clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditoId != null ? creditoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.creditoId == null && other.creditoId != null) || (this.creditoId != null && !this.creditoId.equals(other.creditoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.atm.Credito[ creditoId=" + creditoId + " ]";
    }
    
}

