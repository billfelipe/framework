package com.billfelipe.web.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.billfelipe.glasgow.framework.View;
import com.billfelipe.glasgow.model.Cargo;
import com.billfelipe.service.CargoService;

@Model
public class CadastroCargoView extends View {

	@Inject
	private CargoService cargoService;

	@SessionScoped
	private Cargo cargo;

	@PostConstruct
	public void init() {
		this.cargo = new Cargo();
	}

	@Produces
	@Named("cargo")
	public Cargo getCargo() {
		return this.cargo;
	}

	public void cadastrar() {
		try {
			cargoService.cadastrar(cargo);
			pushMessage(cargo.getNome() + " cadastrado com sucesso");
			init();
		} catch (Exception e) {
			pushMessage(e.getLocalizedMessage());
		}
	}

	public void remover(final Cargo cargo) {
		try {
			cargoService.remover(cargo);
			pushMessage(cargo.getNome() + " removido com sucesso");
		} catch (Exception e) {
			pushMessage(e.getLocalizedMessage());
		}
	}

}
