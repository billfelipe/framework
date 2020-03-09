package com.billfelipe.web.view;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.billfelipe.model.entity.Example;

@RequestScoped
@Named
public class ExampleView {

	@Inject
	private Logger log;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<Example> exampleEventSrc;

	private Example newExample;

	@Produces
	@Named
	public Example getNewExample() {
		return this.newExample;
	}

	@PostConstruct
	public void initNewExample() {
		this.newExample = new Example();
	}

	public void createExample() {
		log.info("Creating new example");
		exampleEventSrc.fire(newExample);
		facesContext.addMessage("home", new FacesMessage("message sent"));
		initNewExample();
	}

}
