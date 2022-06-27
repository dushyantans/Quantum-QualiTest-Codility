package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.CartPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class CartPageStepsDefs {

	@Then("I find total (.d*) items listed in my cart")
	 public void iFindTotalItemsListedInMyCart(int num) {
		new CartPage().verifyTotalItemsInTheCart(num);
	}
	
	@When("I search for lowest price item")
	public void iSearchForLowestPriceItem() {
		new CartPage().findLowestPriceItem();
	}
	
	@When("I am able to remove the lowest price item from my cart")
	public void iAmAbleToRemoveTheLowestPriceFromCart() {
		new CartPage().deleteLowestPriceItem();
	}

}
