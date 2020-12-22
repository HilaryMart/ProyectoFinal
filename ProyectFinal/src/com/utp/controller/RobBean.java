package com.utp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.utp.dao.robDAO;
import com.utp.model.Consolidado;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class RobBean {
	
	public String nuevo() {
		Consolidado c= new Consolidado();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("consolidado", c);
		return  "Consolidado.xhtml";
	}
	
	public String guardar (Consolidado consolidado) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		consolidado.setFregistro(new java.sql.Date(fechaActual.getTime()));
		
		robDAO clienteDAO= new robDAO();
		clienteDAO.guardar(consolidado);
		return  "Consolidado.xhtml";
	}

	public List<Consolidado> obtenerConsolidado() {
		robDAO robDAO = new robDAO();


		return robDAO.obtenerConsolidado();
	}

	public String editar(Integer n) {
		robDAO clienteDAO = new robDAO();
		Consolidado c = new Consolidado();
		c = robDAO.buscar(n);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "Consolidado.xhtml";
	}

	public String actualizar(Consolidado consolidado) {
		//guarda la fecha de actualizacion
		Date fechaActual= new Date();
		consolidado.setFactualizar(new java.sql.Date(fechaActual.getTime()));
		
		robDAO robeDAO = new robDAO();
		robDAO.editar(consolidado);
		return "Consolidado.xhtml";
	}

	// eliminar un cliente
	public String eliminar(Integer n) {
		robDAO robDAO = new robDAO();
		robDAO.eliminar(n);
		System.out.println("Cliente eliminado..");
		return "Consolidado.xhtml";
	}

}

