package com.robin.e_commerceapp.entity.service;

import java.io.Serializable;
import java.util.Date;


public class TapusuPven implements Serializable {
    private static final long serialVersionUID = 1L;

    protected TapusuPvenPK tapusuPvenPK;

    private String nombre;

    private String tipusua;

    private String centro;

    private String puesto;

    private String estado;

    private Date fecCrea;

    private String usuCrea;

    private String cuser;

    private Date fecModi;

    private String codEmp;

    private String perfilBase;

    private String ciudad;

    private String indPermisos;

    private String almacenFerias;

    private String centroCosto;


    private String email;


    private String clave;

    public TapusuPven() {
    }

    public TapusuPven(TapusuPvenPK tapusuPvenPK) {
        this.tapusuPvenPK = tapusuPvenPK;
    }

    public TapusuPven(String noCia, String usuario) {
        this.tapusuPvenPK = new TapusuPvenPK(noCia, usuario);
    }

    public TapusuPvenPK getTapusuPvenPK() {
        return tapusuPvenPK;
    }

    public void setTapusuPvenPK(TapusuPvenPK tapusuPvenPK) {
        this.tapusuPvenPK = tapusuPvenPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipusua() {
        return tipusua;
    }

    public void setTipusua(String tipusua) {
        this.tipusua = tipusua;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Date fecCrea) {
        this.fecCrea = fecCrea;
    }

    public String getUsuCrea() {
        return usuCrea;
    }

    public void setUsuCrea(String usuCrea) {
        this.usuCrea = usuCrea;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public Date getFecModi() {
        return fecModi;
    }

    public void setFecModi(Date fecModi) {
        this.fecModi = fecModi;
    }

    public String getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(String codEmp) {
        this.codEmp = codEmp;
    }

    public String getPerfilBase() {
        return perfilBase;
    }

    public void setPerfilBase(String perfilBase) {
        this.perfilBase = perfilBase;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getIndPermisos() {
        return indPermisos;
    }

    public void setIndPermisos(String indPermisos) {
        this.indPermisos = indPermisos;
    }

    public String getAlmacenFerias() {
        return almacenFerias;
    }

    public void setAlmacenFerias(String almacenFerias) {
        this.almacenFerias = almacenFerias;
    }

    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tapusuPvenPK != null ? tapusuPvenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TapusuPven)) {
            return false;
        }
        TapusuPven other = (TapusuPven) object;
        if ((this.tapusuPvenPK == null && other.tapusuPvenPK != null) || (this.tapusuPvenPK != null && !this.tapusuPvenPK.equals(other.tapusuPvenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TapusuPven[ tapusuPvenPK=" + tapusuPvenPK + " ]";
    }
}
