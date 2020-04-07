package com.billfelipe.framework.web;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class BaseView {

	@Inject
	private Logger log;

	@Inject
	private FacesContext facesContext;


	protected void pushMessage(final String message) {
		log.info(message);
		facesContext.addMessage("home", new FacesMessage(message));
	}

}
