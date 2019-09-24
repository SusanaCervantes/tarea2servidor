/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
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

    @Basic(optional = false)
    @Column(name = "SEG_PORCENTAJE")
    private Long segPorcentaje;
    @Version
    @Column(name = "SEG_VERSION")
    private Long segVersion;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SEG_ID")
    private Long segId;
    @Basic(optional = false)
    @Column(name = "SEG_DETALLE")
    private String segDetalle;
    @Basic(optional = false)
    @Column(name = "SEG_FECHA")
    private String segFecha;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne
    private Proyecto proId;

    public Seguimiento() {
    }

    public Seguimiento(Long segId) {
        this.segId = segId;
    }

    public Seguimiento(Long segId, String segDetalle, String segFecha, Long segPorcentaje) {
        this.segId = segId;
        this.segDetalle = segDetalle;
        this.segFecha = segFecha;
        this.segPorcentaje = segPorcentaje;
    }
    
    public Seguimiento(SeguimientoDto seg){
        this.segId = seg.getId();
        actualizar(seg);
    }
    
    public void actualizar(SeguimientoDto seg){
        this.segDetalle = seg.getDetalle();
        this.segFecha = seg.getFecha();
        this.segPorcentaje = new Long(seg.getPorcentaje());
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
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

    public Long getSegPorcentaje() {
        return segPorcentaje;
    }

    public void setSegPorcentaje(Long segPorcentaje) {
        this.segPorcentaje = segPorcentaje;
    }

    public Long getSegVersion() {
        return segVersion;
    }

    public void setSegVersion(Long segVersion) {
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
        return "model.Seguimiento[ segId=" + segId + " ]";
    }

    
}
