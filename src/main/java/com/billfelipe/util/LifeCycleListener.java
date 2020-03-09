package com.billfelipe.util;

import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class LifeCycleListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		log.info("STARTING PHASE: " + event.getPhaseId());
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		log.info("ENDING FASE: " + event.getPhaseId());
	}

}
