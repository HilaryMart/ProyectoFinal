package com.utp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.utp.model.Consolidado;
import com.utp.model.JPAutil;

public class robDAO {
	static EntityManager entity = JPAutil.getEntityManagerFactory().createEntityManager();

	// guardar cliente
	public void guardar(Consolidado consolidado) {
		entity.getTransaction().begin();
		entity.persist(consolidado);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	// editar cliente
	public static void editar(Consolidado consolidado) {
		entity.getTransaction().begin();
		entity.merge(consolidado);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}

	// buscar cliente
	public static Consolidado buscar(Integer n) {
		Consolidado c = new Consolidado();
		c = entity.find(Consolidado.class, n);
		// JPAUtil.shutdown();
		return c;
	}

	// eliminar cliente
	public void eliminar(Integer n) {
		Consolidado c = new Consolidado();
		c = entity.find(Consolidado.class, n);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos los cliente
	public List<Consolidado> obtenerConsolidado() {
		List<Consolidado> listaConsolidado = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Consolidado c");
		listaConsolidado = q.getResultList();
		return listaConsolidado;
	}

}

