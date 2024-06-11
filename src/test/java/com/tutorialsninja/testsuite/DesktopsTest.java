package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
/**
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBeticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73
 */
public class DesktopsTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        homePage.mouseHoverOnElementAndClick(homePage.desktopTab);
        //1.2 Click on “Show All Desktops”
        homePage.click(homePage.desktopTab, "Show AllDesktops");
        List<String> actualText = desktopPage.getProductNamesInDefaultFilterAndSortByDescendingOrder();
        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectFilter("https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");
        Thread.sleep(2000);
        List<String> expectedText = desktopPage.getProductNamesAfterFilterZtoA();
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //Mouse hover on Currency Dropdown and click
        homePage.clickOn(homePage.currencyDropdown);
        //Mouse hover on £Pound Sterling and click
        homePage.clickOn(homePage.£Pound);
        //Mouse hover on Desktops Tab.
        homePage.mouseHoverOnElement(homePage.desktopTab);
        //Click on “Show All Desktops”
        homePage.clickOn(homePage.showAllDesktop);
        //Select Sort By position "Name: A to Z"
        desktopPage.select(desktopPage.selectFilter, "https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC");
        //Select product “HP LP3065”
        desktopPage.clickOn(desktopPage.hPLP3065);
        //Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = desktopPage.getVerificationText(desktopPage.hPLP3065Text);
        Assert.assertEquals(actualText, expectedText);
        //2.8 Select Delivery Date "2023-11-27"
        desktopPage.selectDate("2023", "November", "27");
        //Click on “Add to Cart” button
        desktopPage.clickOn(desktopPage.addToCartButton);
        //Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        expectedText = "Success: You have added HP LP3065 to your shopping cart!";
        actualText = desktopPage.getVerificationText(desktopPage.successMessage).substring(0, 56);
        Assert.assertEquals(actualText, expectedText);
        //Click on link “shopping cart” display into success message
        desktopPage.clickOn(desktopPage.shoppingCartLink);
        //Verify the text "Shopping Cart"
        expectedText = "Shopping Cart";
        actualText = desktopPage.getVerificationText(desktopPage.shoppingCartLinkText).substring(0, 13);
        Assert.assertEquals(actualText, expectedText);
        //Verify the Product name "HP LP3065"
        expectedText = "HP LP3065";
        actualText = desktopPage.getVerificationText(desktopPage.gethPLP3065Text);
        Assert.assertEquals(actualText, expectedText);
        //Verify the Delivery Date "2023-11-27"
        expectedText = "Delivery Date:2023-11-27";
        actualText = desktopPage.getVerificationText(desktopPage.dateText);
        Assert.assertEquals(actualText, expectedText);
        //Verify the Model "Product21"
        expectedText = "Product 21";
        actualText = desktopPage.getVerificationText(desktopPage.model21Text);
        Assert.assertEquals(actualText, expectedText);
        //Verify the Todat "£74.73"
        expectedText = "£74.73";
        actualText = desktopPage.getVerificationText(desktopPage.totalAmountTxxt);
        Assert.assertEquals(actualText, expectedText);
    }
}
