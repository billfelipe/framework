package com.billfelipe.service;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import com.billfelipe.model.entity.Example;

@RequestScoped
public class ExampleService extends Service<Example> {

	public void onExampleEventFired(@Observes(notifyObserver = Reception.ALWAYS) final Example example) {
		log.info("event observed at the service");
		dao.merge(example);
	}

}
