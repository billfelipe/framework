//package com.billfelipe.web.session;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//
//import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
//import javax.enterprise.event.Observes;
//import javax.enterprise.inject.Produces;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import com.billfelipe.glasgow.model.Example;
//
//@SessionScoped
//public class ExampleSession implements Serializable {
//
//	@Inject
//	private Logger log;
//
//	private List<Example> examples;
//
//	@Produces
//	@Named
//	public List<Example> getExamples() {
//		return this.examples;
//	}
//
//	@PostConstruct
//	public void init() {
//		this.examples = new ArrayList<Example>();
//	}
//
//	public void onExampleEventFired(@Observes final Example example) {
//		this.examples.add(example);
//		log.info("example added through observer");
//	}
//
//}
