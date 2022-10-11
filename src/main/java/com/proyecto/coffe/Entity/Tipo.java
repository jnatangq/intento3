package com.proyecto.coffe.Entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tipos")
public class Tipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private String umedida;

    private String contcafe;

    private String contazucar;

    public Tipo() {

    }

    public Tipo(String tipo, String umedida, String contcafe, String contazucar) {
        this.tipo = tipo;
        this.umedida = umedida;
        this.contcafe = contcafe;
        this.contazucar = contazucar;
    }

    @ManyToMany(mappedBy = "tipos", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }

    public String getContcafe() {
        return contcafe;
    }

    public void setContcafe(String contcafe) {
        this.contcafe = contcafe;
    }

    public String getContazucar() {
        return contazucar;
    }

    public void setContazucar(String contazucar) {
        this.contazucar = contazucar;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tipo other = (Tipo) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tipo{" + "tipo=" + tipo + ", contazucar=" + contazucar + '}';
    }

}


      