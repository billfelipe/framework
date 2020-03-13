package com.billfelipe.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Documento;

@RequestScoped
public class DocumentoService extends Service<Documento> {

	public void cadastrar(final Documento documento) {
		dao.merge(documento);
		log.info(documento.getNome() + " persistido com sucesso");
	}

	@Produces
	@Named(value = "documentos")
	public Collection<Documento> getAll(){
		return dao.getResultList(Documento.class, Documento.GET_ALL_SEM_CADASTRO);
	}
}
