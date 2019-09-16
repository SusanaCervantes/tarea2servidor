/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Susana
 */
@Entity
@Table(name = "ADM_SEGUIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findBySegId", query = "SELECT s FROM Seguimiento s WHERE s.segId = :segId")
    , @NamedQuery(name = "Seguimiento.findBySegDetalle", query = "SELECT s FROM Seguimiento s WHERE s.segDetalle = :segDetalle")
    , @NamedQuery(name = "Seguimiento.findBySegFecha", query = "SELECT s FROM Seguimiento s WHERE s.segFecha = :segFecha")
    , @NamedQuery(name = "Seguimiento.findBySegPorcentaje", query = "SELECT s FROM Seguimiento s WHERE s.segPorcentaje = :segPorcentaje")
    , @NamedQuery(name = "Seguimiento.findBySegVersion", query = "SELECT s FROM Seguimiento s WHERE s.segVersion = :segVersion")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SEG_ID")
    private BigDecimal segId;
    @Basic(optional = false)
    @Column(name = "SEG_DETALLE")
    private String segDetalle;
    @Basic(optional = false)
    @Column(name = "SEG_FECHA")
    private String segFecha;
    @Basic(optional = false)
    @Column(name = "SEG_PORCENTAJE")
    private BigInteger segPorcentaje;
    @Column(name = "SEG_VERSION")
    private BigInteger segVersion;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne
    private Proyecto proId;

    public Seguimiento() {
    }

    public Seguimiento(BigDecimal segId) {
        this.segId = segId;
    }

    public Seguimiento(BigDecimal segId, String segDetalle, String segFecha, BigInteger segPorcentaje) {
        this.segId = segId;
        this.segDetalle = segDetalle;
        this.segFecha = segFecha;
        this.segPorcentaje = segPorcentaje;
    }

    public BigDecimal getSegId() {
        return segId;
    }

    public void setSegId(BigDecimal segId) {
        this.segId = segId;
    }

    public String getSegDetalle() {
        return segDetalle;
    }

    public void setSegDetalle(String segDetalle) {
        this.segDetalle = segDetalle;
    }

    public String getSegFecha() {
        return segFecha;
    }

    public void setSegFecha(String segFecha) {
        this.segFecha = segFecha;
    }

    public BigInteger getSegPorcentaje() {
        return segPorcentaje;
    }

    public void setSegPorcentaje(BigInteger segPorcentaje) {
        this.segPorcentaje = segPorcentaje;
    }

    public BigInteger getSegVersion() {
        return segVersion;
    }

    public void setSegVersion(BigInteger segVersion) {
        this.segVersion = segVersion;
    }

    public Proyecto getProId() {
        return proId;
    }

    public void setProId(Proyecto proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segId != null ? segId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.segId == null && other.segId != null) || (this.segId != null && !this.segId.equals(other.segId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Seguimiento[ segId=" + segId + " ]";
    }
    
}
