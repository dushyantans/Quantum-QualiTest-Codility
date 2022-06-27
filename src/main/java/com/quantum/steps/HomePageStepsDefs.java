package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.HomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class HomePageStepsDefs {

	@Then("I add (.d*) randon items to cart")
	public void iAddRandomItemsToCart(int num) {
		new HomePage().addItemsToCart(num);
	}
	
	@When("I view my cart")
	public void iViewMyCart() {
		new HomePage().clickViewCart();
	}
}
