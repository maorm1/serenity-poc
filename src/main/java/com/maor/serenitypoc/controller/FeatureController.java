package com.maor.serenitypoc.controller;

import com.maor.serenitypoc.feature.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature")
@RequiredArgsConstructor
public class FeatureController {

	private final FeatureService featureService;

	@GetMapping
	public String runFeature() {
		return featureService.runFeature();
	}
}
