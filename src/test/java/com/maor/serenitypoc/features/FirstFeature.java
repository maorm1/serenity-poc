package com.maor.serenitypoc.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

@RunWith(SerenityRunner.class)
public class FirstFeature {

	private String featureUrl = "http://localhost:8080/feature";
	private String testUrl = "https://reqres.in/api";

	private Actor bob = Actor.named("Bob the First"); // Has "use feature" user-right enabled
	private Actor bill = Actor.named("Bill the Second"); // Has "use feature" user-right disabled

	@Test

	public void whatINeedToTestPositive() {
		// given that bob can call an api at featureUrl
		// and that bob has the "use feature" user-right enabled

		// when bob attempts to get feature

		// then bob should see that response status 200
	}

	public void whatINeedToTestNegative() {
		// given that bill can call an api at featureUrl
		// and that bill DOES NOT have the "use feature" user-right enabled

		// when bill attempts to get feature

		// then bill should see that response status is not 200
	}

	@Test
	public void sanityTest() {
		givenThat(bob).can(CallAnApi.at(testUrl));

		when(bob).attemptsTo(Get.resource("/users"));

		then(bob).should(
				seeThatResponse("Got status OK",
						response -> response.statusCode(200))
		);

	}
}
