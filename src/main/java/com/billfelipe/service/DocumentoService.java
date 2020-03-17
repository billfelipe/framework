package com.billfelipe.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Documento;

@SessionScoped
public class DocumentoService extends Service<Documento> implements Serializable {

	public void cadastrar(final Documento documento) {
		dao.persist(documento);
	}

	@Produces
	@Named(value = "documentosSemProvaAssociada")
	public Collection<Documento> getAll() {
		return (List<Documento>) dao.getResultList(Documento.class, Documento.GET_DOCUMENTOS_SEM_PROVA_ASSOCIADA);
	}
}
