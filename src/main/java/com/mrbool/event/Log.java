package com.mrbool.event;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.ControllerMatched;
import javax.mvc.event.ViewEngineSelected;

@RequestScoped
public class Log {

	public void log(@Observes ControllerMatched event) {
		System.out.println("Match: " + event.getResourceInfo().getResourceMethod());
	}

	public void log(@Observes ViewEngineSelected event) {
		System.out.println("Match: " + event.getEngine().getName());
	}

}
