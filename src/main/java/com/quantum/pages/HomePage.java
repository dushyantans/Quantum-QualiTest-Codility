package com.quantum.pages;

import java.util.List;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(locator = "css=a[href*=add-to-cart]")
	private List<QAFExtendedWebElement> addToCartButtons;
	
	@FindBy(locator = "css=a[title='View cart']")
	private QAFExtendedWebElement viewCartBtn;
	
	
	public void addItemsToCart(int num) {
		for(int i=0;i<num;i++) {
			addToCartButtons.get(i).click();
		}
	}
	
	public void clickViewCart() {
		driver.executeScript("arguments[0].click()",viewCartBtn);
		System.out.println("Done");
	}

}
