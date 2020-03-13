package com.billfelipe.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.billfelipe.glasgow.model.Documento;
import com.billfelipe.glasgow.model.Prova;

@SessionScoped
public class DocumentoService extends Service<Documento> implements Serializable {

	private List<Documento> documentosNaoCadastrados;

	@PostConstruct
	public void onEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Documento documento) {
		log.info("evento observado");
		this.documentosNaoCadastrados = null;
	}

	@PostConstruct
	public void onEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Prova prova) {
		event.fire(prova.getDocumento());
	}

	public void cadastrar(final Documento documento) {
		dao.merge(documento);
		event.fire(documento);
		log.info(documento.getNome() + " persistido com sucesso");
	}

	@Produces
	@Named(value = "documentosNaoCadastrados")
	public Collection<Documento> getAll() {
		if (this.documentosNaoCadastrados == null) {
			this.documentosNaoCadastrados = (List<Documento>) dao.getResultList(Documento.class,
					Documento.GET_ALL_SEM_CADASTRO);
		}
		return this.documentosNaoCadastrados;
	}
}
