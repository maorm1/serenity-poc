package com.maor.serenitypoc.controller;

import com.maor.serenitypoc.feature.FeatureService;
import com.maor.serenitypoc.feature.ValidateFeatureAccess;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature")
@RequiredArgsConstructor
public class FeatureController {

	private final ValidateFeatureAccess validateFeatureAccess;
	private final FeatureService featureService;

	@GetMapping("/{userId}")
	public String runFeature(@PathVariable long userId) {
		validateFeatureAccess.forUser(userId);
		return featureService.runFeature();
	}
}
