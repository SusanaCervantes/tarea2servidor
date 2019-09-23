/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Susana
 */
@Entity
@Table(name = "ADM_ADMINISTRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByAdmId", query = "SELECT a FROM Administrador a WHERE a.admId = :admId")
    , @NamedQuery(name = "Administrador.findByAdmUsuario", query = "SELECT a FROM Administrador a WHERE a.admUsuario = :admUsuario")
    , @NamedQuery(name = "Administrador.findByAdmContrasena", query = "SELECT a FROM Administrador a WHERE a.admContrasena = :admContrasena")
    , @NamedQuery(name = "Administrador.findByAdmNombre", query = "SELECT a FROM Administrador a WHERE a.admNombre = :admNombre")
    , @NamedQuery(name = "Administrador.findByAdmApellidos", query = "SELECT a FROM Administrador a WHERE a.admApellidos = :admApellidos")
    , @NamedQuery(name = "Administrador.findByAdmCedula", query = "SELECT a FROM Administrador a WHERE a.admCedula = :admCedula")
    , @NamedQuery(name = "Administrador.findByAdmCorreo", query = "SELECT a FROM Administrador a WHERE a.admCorreo = :admCorreo")
    , @NamedQuery(name = "Administrador.findByAdmEstado", query = "SELECT a FROM Administrador a WHERE a.admEstado = :admEstado")
    , @NamedQuery(name = "Administrador.findByNombreApellidos", query = "SELECT a FROM Administrador a WHERE (a.admNombre) like :nombre and (a.admApellidos) like :apellidos", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))
    , @NamedQuery(name = "Administrador.findByAdmVersion", query = "SELECT a FROM Administrador a WHERE a.admVersion = :admVersion")
    , @NamedQuery(name = "Administrador.findByUsuarioContrasena", query = "SELECT a FROM Administrador a WHERE (a.admUsuario) = :usuario and (a.admContrasena) = :contrasena")})

public class Administrador implements Serializable {

    

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADM_ADMINISTRADOR_ADM_ID_GENERATOR", sequenceName = "UNA.ADM_ADMINISTRADOR_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADM_ADMINISTRADOR_ADM_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ADM_ID")
    private Long admId;
    @Basic(optional = false)
    @Column(name = "ADM_USUARIO")
    private String admUsuario;
    @Basic(optional = false)
    @Column(name = "ADM_CONTRASENA")
    private String admContrasena;
    @Column(name = "ADM_NOMBRE")
    private String admNombre;
    @Column(name = "ADM_APELLIDOS")
    private String admApellidos;
    @Basic(optional = false)
    @Column(name = "ADM_CEDULA")
    private String admCedula;
    @Column(name = "ADM_CORREO")
    private String admCorreo;
    @Basic(optional = false)
    @Column(name = "ADM_ESTADO")
    private String admEstado;
    @Version
    @Column(name = "ADM_VERSION")
    private Long admVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admId")
    private List<Proyecto> proyectoList;
    
    public Administrador() {
    }

    public Administrador(Long admId) {
        this.admId = admId;
    }

    public Administrador(Long admId, String admUsuario, String admContrasena, String admCedula, String admEstado) {
        this.admId = admId;
        this.admUsuario = admUsuario;
        this.admContrasena = admContrasena;
        this.admCedula = admCedula;
        this.admEstado = admEstado;
    }
    
    public Administrador(AdministradorDto adm){
        if(adm.getId() != null)
            this.admId = adm.getId();
        
        actualizar(adm);
    }
    
    public void actualizar(AdministradorDto adm){
        this.admNombre = adm.getNombre();
        this.admApellidos = adm.getApellidos();
        this.admUsuario = adm.getUsuario();
        this.admContrasena = adm.getContrasena();
        this.admCedula= adm.getCedula();
        this.admCorreo = adm.getCorreo();
        this.admEstado = adm.getEstado();
        this.admVersion = adm.getVersion();
    }

    public Long getAdmId() {
        return admId;
    }

    public void setAdmId(Long admId) {
        this.admId = admId;
    }

    public String getAdmUsuario() {
        return admUsuario;
    }

    public void setAdmUsuario(String admUsuario) {
        this.admUsuario = admUsuario;
    }

    public String getAdmContrasena() {
        return admContrasena;
    }

    public void setAdmContrasena(String admContrasena) {
        this.admContrasena = admContrasena;
    }

    public String getAdmNombre() {
        return admNombre;
    }

    public void setAdmNombre(String admNombre) {
        this.admNombre = admNombre;
    }

    public String getAdmApellidos() {
        return admApellidos;
    }

    public void setAdmApellidos(String admApellidos) {
        this.admApellidos = admApellidos;
    }

    public String getAdmCedula() {
        return admCedula;
    }

    public void setAdmCedula(String admCedula) {
        this.admCedula = admCedula;
    }

    public String getAdmCorreo() {
        return admCorreo;
    }

    public void setAdmCorreo(String admCorreo) {
        this.admCorreo = admCorreo;
    }

    public String getAdmEstado() {
        return admEstado;
    }

    public void setAdmEstado(String admEstado) {
        this.admEstado = admEstado;
    }

    public Long getAdmVersion() {
        return admVersion;
    }

    public void setAdmVersion(Long admVersion) {
        this.admVersion = admVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admId != null ? admId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Administrador[ admId=" + admId + " ]";
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }
    
}
