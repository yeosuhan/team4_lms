package com.team4.myapp.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler2{

	@Scheduled(cron = "0/10 * 9 * * 2-6")
	public void test() {
		
		System.out.println("스케줄러 1");
		
	}

}
