package com.ranga.spring.data;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditAware implements AuditorAware<String> {

	public String getCurrentAuditor() {
		return "Ranga Bhupal";
	}

}
