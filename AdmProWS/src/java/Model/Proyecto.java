/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Susana
 */
@Entity
@Table(name = "ADM_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByProId", query = "SELECT p FROM Proyecto p WHERE p.proId = :proId")
    , @NamedQuery(name = "Proyecto.findByProPatrocinador", query = "SELECT p FROM Proyecto p WHERE p.proPatrocinador = :proPatrocinador")
    , @NamedQuery(name = "Proyecto.findByProLtecnico", query = "SELECT p FROM Proyecto p WHERE p.proLtecnico = :proLtecnico")
    , @NamedQuery(name = "Proyecto.findByProFpInicio", query = "SELECT p FROM Proyecto p WHERE p.proFpInicio = :proFpInicio")
    , @NamedQuery(name = "Proyecto.findByProFpFinal", query = "SELECT p FROM Proyecto p WHERE p.proFpFinal = :proFpFinal")
    , @NamedQuery(name = "Proyecto.findByProFrInicio", query = "SELECT p FROM Proyecto p WHERE p.proFrInicio = :proFrInicio")
    , @NamedQuery(name = "Proyecto.findByProFrFinal", query = "SELECT p FROM Proyecto p WHERE p.proFrFinal = :proFrFinal")
    , @NamedQuery(name = "Proyecto.findByProEstado", query = "SELECT p FROM Proyecto p WHERE p.proEstado = :proEstado")
    , @NamedQuery(name = "Proyecto.findByProVersion", query = "SELECT p FROM Proyecto p WHERE p.proVersion = :proVersion")
    , @NamedQuery(name = "Proyecto.findByProNombre", query = "SELECT p FROM Proyecto p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Proyecto.filtro", query = "SELECT p FROM Proyecto p WHERE p.admId = :admId or UPPER(p.proNombre) LIKE :proNombre")})
public class Proyecto implements Serializable {

    

    

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "PRO_ID_GENERATOR", sequenceName = "UNA.ADM_PROYECTO_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRO_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "PRO_ID")
    private Long proId;
    @Column(name = "PRO_PATROCINADOR")
    private String proPatrocinador;
    @Column(name = "PRO_LTECNICO")
    private String proLtecnico;
    @Basic(optional = false)
    @Column(name = "PRO_FP_INICIO")
    private String proFpInicio;
    @Basic(optional = false)
    @Column(name = "PRO_FP_FINAL")
    private String proFpFinal;
    @Column(name = "PRO_FR_INICIO")
    private String proFrInicio;
    @Column(name = "PRO_FR_FINAL")
    private String proFrFinal;
    @Basic(optional = false)
    @Column(name = "PRO_ESTADO")
    private String proEstado;
    @Column(name = "PRO_VERSION")
    private BigInteger proVersion;
    @Basic(optional = false)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Column(name = "PRO_CORREO_LTECNICO")
    private String proCorreoLtecnico;
    @Column(name = "PRO_CORREO_PATROCINADOR")
    private String proCorreoPatrocinador;
    @JoinColumn(name = "ADM_ID", referencedColumnName = "ADM_ID")
    @ManyToOne(optional = false)
    private Administrador admId;
    @OneToMany(mappedBy = "proId")
    private List<Actividad> actividadList;
    @OneToMany(mappedBy = "proId")
    private List<Seguimiento> seguimientoList;

    public Proyecto() {
    }

    public Proyecto(Long proId) {
        this.proId = proId;
    }

    public Proyecto(Long proId, String proFpInicio, String proFpFinal, String proEstado, String proNombre) {
        this.proId = proId;
        this.proFpInicio = proFpInicio;
        this.proFpFinal = proFpFinal;
        this.proEstado = proEstado;
        this.proNombre = proNombre;
    }

    public Proyecto(ProyectosDto pro){
        this.proId = pro.getProId();
        actualizar(pro);
    }

    public void actualizar(ProyectosDto pro){
        this.proCorreoLtecnico = pro.getProCorreoLtecnico();
        this.proCorreoPatrocinador = pro.getProCorreoPatrocinador();
        this.proPatrocinador = pro.getProPatrocinador();
        this.proLtecnico = pro.getProLtecnico();
        this.proFpInicio = pro.getProFpInicio();
        this.proFpFinal = pro.getProFpFinal();
        this.proFrInicio = pro.getProFrInicio();
        this.proFrFinal = pro.getProFrFinal();
        this.proEstado = pro.getProEstado();
        this.proNombre = pro.getProNombre();
        this.admId = new Administrador(pro.getAdmId());
        this.actividadList = pro.getListAct();
        this.seguimientoList = pro.getListSeg();
    }
    
    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProPatrocinador() {
        return proPatrocinador;
    }

    public void setProPatrocinador(String proPatrocinador) {
        this.proPatrocinador = proPatrocinador;
    }

    public String getProLtecnico() {
        return proLtecnico;
    }

    public void setProLtecnico(String proLtecnico) {
        this.proLtecnico = proLtecnico;
    }

    public String getProFpInicio() {
        return proFpInicio;
    }

    public void setProFpInicio(String proFpInicio) {
        this.proFpInicio = proFpInicio;
    }

    public String getProFpFinal() {
        return proFpFinal;
    }

    public void setProFpFinal(String proFpFinal) {
        this.proFpFinal = proFpFinal;
    }

    public String getProFrInicio() {
        return proFrInicio;
    }

    public void setProFrInicio(String proFrInicio) {
        this.proFrInicio = proFrInicio;
    }

    public String getProFrFinal() {
        return proFrFinal;
    }

    public void setProFrFinal(String proFrFinal) {
        this.proFrFinal = proFrFinal;
    }

    public String getProEstado() {
        return proEstado;
    }

    public void setProEstado(String proEstado) {
        this.proEstado = proEstado;
    }

    public BigInteger getProVersion() {
        return proVersion;
    }

    public void setProVersion(BigInteger proVersion) {
        this.proVersion = proVersion;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Proyecto[ proId=" + proId + " ]";
    }

    public Administrador getAdmId() {
        return admId;
    }

    public void setAdmId(Administrador admId) {
        this.admId = admId;
    }

    public String getProCorreoLtecnico() {
        return proCorreoLtecnico;
    }

    public void setProCorreoLtecnico(String proCorreoLtecnico) {
        this.proCorreoLtecnico = proCorreoLtecnico;
    }

    public String getProCorreoPatrocinador() {
        return proCorreoPatrocinador;
    }

    public void setProCorreoPatrocinador(String proCorreoPatrocinador) {
        this.proCorreoPatrocinador = proCorreoPatrocinador;
    }
    
    
}
