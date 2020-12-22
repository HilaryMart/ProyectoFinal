package com.utp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="consolidado")
public class Consolidado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer n;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String marca;
	@Column
	private String funcion;
	@Column
	private String peso;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fregistro;
	@Temporal(TemporalType.TIMESTAMP)
	private Date factualizar;
	
	
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	
	public Date getFregistro() {
		return fregistro;
	}
	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}
	public Date getFactualizar() {
		return factualizar;
	}
	public void setFactualizar(Date factualizar) {
		this.factualizar = factualizar;
	}
	@Override
	public String toString() {
		return "Consolidado [n=" + n + ", nombre=" + nombre + ", descripcion=" + descripcion + ", marca=" + marca
				+ ", funcion=" + funcion + ", peso=" + peso + ", fregistro=" + fregistro + ", factualizar="
				+ factualizar + "]";
	}

	
	
}
