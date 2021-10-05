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

	private String testUrl = "https://reqres.in/api";

	private Actor bob = Actor.named("Bob the First");

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
