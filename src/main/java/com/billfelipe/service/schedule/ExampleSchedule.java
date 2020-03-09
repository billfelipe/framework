package com.billfelipe.service.schedule;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class ExampleSchedule {

	//@Schedule(minute = "*", hour = "*")
	public void run() {
		System.out.println("scheduled");
	}

}
