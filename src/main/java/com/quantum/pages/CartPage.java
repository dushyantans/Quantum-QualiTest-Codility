package com.quantum.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class CartPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	@FindBy(locator = "css=tr[class='woocommerce-cart-form__cart-item cart_item']")
	private List<QAFExtendedWebElement> itemsListInTheCart;

	@FindBy(locator = "css=[class=product-price] [class='woocommerce-Price-amount amount']")
	private List<QAFExtendedWebElement> priceList;

	@FindBy(locator = "css=[aria-label='Remove this item']")
	private List<QAFExtendedWebElement> deleteIcons;
	
	@FindBy(locator = "css=[class=restore-item]")
	private QAFExtendedWebElement undoBtn;

	public void verifyTotalItemsInTheCart(int num) {
		driver.navigate().refresh();
		assertEquals(itemsListInTheCart.size(), num);
	}

	public void findLowestPriceItem() {
		double[] priceValueList = new double[priceList.size()];
		for (int i = 0; i < priceList.size(); i++) {
			String price = priceList.get(i).getText().replace("$", "");
			priceValueList[i]=Double.parseDouble(price);
		}
//		int index = -1;

//		double min = priceValueList.get(0);
//		for (int i = 1; i < priceValueList.size(); i++) {
//			if (priceValueList.get(i) < min) {
//				min = priceValueList.get(i);
//				index =i;
//			}
//		}
		double min = priceValueList[0];
	       int index=0;

	       for(int i = 0; i < priceValueList.length; i++)
	       {
	            if(min > priceValueList[i])
	            {
	                min = priceValueList[i];
	                index=i;
	            }
	        }
	       ConfigurationManager.getBundle().setProperty("lowestPriceIndex", index);
	}
	
	public void deleteLowestPriceItem() {
		deleteIcons.get(ConfigurationManager.getBundle().getInt("lowestPriceIndex")).click();
		undoBtn.waitForPresent(2000);
	}
}
