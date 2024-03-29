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
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Susana
 */
@Entity
@Table(name = "ADM_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByActId", query = "SELECT a FROM Actividad a WHERE a.actId = :actId")
    , @NamedQuery(name = "Actividad.findByActEncargado", query = "SELECT a FROM Actividad a WHERE a.actEncargado = :actEncargado")
    , @NamedQuery(name = "Actividad.findByActFpInicio", query = "SELECT a FROM Actividad a WHERE a.actFpInicio = :actFpInicio")
    , @NamedQuery(name = "Actividad.findByActFpFinal", query = "SELECT a FROM Actividad a WHERE a.actFpFinal = :actFpFinal")
    , @NamedQuery(name = "Actividad.findByActFrInicio", query = "SELECT a FROM Actividad a WHERE a.actFrInicio = :actFrInicio")
    , @NamedQuery(name = "Actividad.findByActFrFinal", query = "SELECT a FROM Actividad a WHERE a.actFrFinal = :actFrFinal")
    , @NamedQuery(name = "Actividad.findByActOrden", query = "SELECT a FROM Actividad a WHERE a.actOrden = :actOrden")
    , @NamedQuery(name = "Actividad.findByActDescripcion", query = "SELECT a FROM Actividad a WHERE a.actDescripcion = :actDescripcion")
    , @NamedQuery(name = "Actividad.findByActEstado", query = "SELECT a FROM Actividad a WHERE a.actEstado = :actEstado")
    , @NamedQuery(name = "Actividad.findByActNombre", query = "SELECT a FROM Actividad a WHERE a.actNombre = :actNombre")
    , @NamedQuery(name = "Actividad.filtroN", query = "SELECT a FROM Actividad a WHERE UPPER(a.actNombre) LIKE :actNombre")
    , @NamedQuery(name = "Actividad.findByPro", query = "SELECT a FROM Actividad a WHERE a.proId = :proId")
    , @NamedQuery(name = "Actividad.findByActVersion", query = "SELECT a FROM Actividad a WHERE a.actVersion = :actVersion")})
public class Actividad implements Serializable {

    @Basic(optional = false)
    @Column(name = "ACT_ORDEN")
    private Long actOrden;
    @Version
    @Column(name = "ACT_VERSION")
    private Long actVersion;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ACT_ID")
    private Long actId;
    @Basic(optional = false)
    @Column(name = "ACT_ENCARGADO")
    private String actEncargado;
    @Basic(optional = false)
    @Column(name = "ACT_FP_INICIO")
    private String actFpInicio;
    @Basic(optional = false)
    @Column(name = "ACT_FP_FINAL")
    private String actFpFinal;
    @Column(name = "ACT_FR_INICIO")
    private String actFrInicio;
    @Column(name = "ACT_FR_FINAL")
    private String actFrFinal;
    @Column(name = "ACT_DESCRIPCION")
    private String actDescripcion;
    @Basic(optional = false)
    @Column(name = "ACT_ESTADO")
    private String actEstado;
    @Basic(optional = false)
    @Column(name = "ACT_NOMBRE")
    private String actNombre;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne
    private Proyecto proId;

    public Actividad() {
    }

    public Actividad(Long actId) {
        this.actId = actId;
    }

    public Actividad(Long actId, String actEncargado, String actFpInicio, String actFpFinal, Long actOrden, String actEstado, String actNombre) {
        this.actId = actId;
        this.actEncargado = actEncargado;
        this.actFpInicio = actFpInicio;
        this.actFpFinal = actFpFinal;
        this.actOrden = actOrden;
        this.actEstado = actEstado;
        this.actNombre = actNombre;
    }

    public Actividad(ActividadDto act){
        this.actId = act.getId();
        actualizarAct(act);
    }
    
    public void actualizarAct(ActividadDto act){
        this.actDescripcion = act.getDescripcion();
        this.actEncargado = act.getEncargado();
        this.actEstado = act.getEstado();
        this.actFpFinal = act.getFpfinal();
        this.actFpInicio = act.getFpinicio();
        this.actFrFinal = act.getFpfinal();
        this.actFrInicio = act.getFrinicio();
        this.actNombre = act.getNombre();
        this.actOrden = act.getOrden();
        this.actVersion = act.getVersion();         
    }
    
    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getActEncargado() {
        return actEncargado;
    }

    public void setActEncargado(String actEncargado) {
        this.actEncargado = actEncargado;
    }

    public String getActFpInicio() {
        return actFpInicio;
    }

    public void setActFpInicio(String actFpInicio) {
        this.actFpInicio = actFpInicio;
    }

    public String getActFpFinal() {
        return actFpFinal;
    }

    public void setActFpFinal(String actFpFinal) {
        this.actFpFinal = actFpFinal;
    }

    public String getActFrInicio() {
        return actFrInicio;
    }

    public void setActFrInicio(String actFrInicio) {
        this.actFrInicio = actFrInicio;
    }

    public String getActFrFinal() {
        return actFrFinal;
    }

    public void setActFrFinal(String actFrFinal) {
        this.actFrFinal = actFrFinal;
    }

    public Long getActOrden() {
        return actOrden;
    }

    public void setActOrden(Long actOrden) {
        this.actOrden = actOrden;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActEstado() {
        return actEstado;
    }

    public void setActEstado(String actEstado) {
        this.actEstado = actEstado;
    }

    public String getActNombre() {
        return actNombre;
    }

    public void setActNombre(String actNombre) {
        this.actNombre = actNombre;
    }

    public Long getActVersion() {
        return actVersion;
    }

    public void setActVersion(Long actVersion) {
        this.actVersion = actVersion;
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
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Actividad[ actId=" + actId + " ]";
    }

    
}
