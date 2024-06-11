package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage lapAndNotePage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //Mouse hover on Currency Dropdown and click
        homePage.clickOn(homePage.currencyDropdown);
        //Mouse hover on £Pound Sterling and click
        homePage.clickOn(homePage.£Pound);
        //Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnElementAndClick(homePage.laptopAndNoteBookTabe);
        //Click on “Show All Laptops & Notebooks”
        homePage.clickOn(homePage.showAllLaptopAndNotebook);
        //Verify the Product will arrange in Descending order.
        List<Double> actualText = lapAndNotePage.getProductPricesInDefaultFilterAndSortByDescendingOrder();
        //Select Sort By position "Price high to low"
        lapAndNotePage.select(lapAndNotePage.selectFilter, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        Thread.sleep(2000);
        List<Double> expectedText = lapAndNotePage.getProductPriceAfterFilterHighToLow();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on Currency Dropdown and click
        homePage.clickOn(homePage.currencyDropdown);
        //Mouse hover on £Pound Sterling and click
        homePage.clickOn(homePage.£Pound);
        //Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnElementAndClick(homePage.laptopAndNoteBookTabe);
        //Click on “Show All Laptops & Notebooks”
        homePage.clickOn(homePage.showAllLaptopAndNotebook);
        //Select Sort By "Price (High > Low)"
        lapAndNotePage.select(lapAndNotePage.selectFilter, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        //Select Product “Sony VAIO”
        lapAndNotePage.clickOn(lapAndNotePage.sonyVAIO);
        //Verify the text “Sony VAIO”
        String expectedText = "Sony VAIO";
        String actualText = lapAndNotePage.getVerificationText(lapAndNotePage.sonyVAIOText);
        Assert.assertEquals(actualText, expectedText);
        //Click on ‘Add To Cart’ button
        lapAndNotePage.clickOn(lapAndNotePage.addToCartButton);
        //Verify the message “Success: You have added Sony VAIO to your shopping cart!”
        expectedText = "Success: You have added Sony VAIO to your shopping cart!";
        actualText = lapAndNotePage.getVerificationText(lapAndNotePage.successText).substring(0, 56);
        Assert.assertEquals(actualText, expectedText);
        //Click on link “shopping cart” display into success message
        lapAndNotePage.clickOn(lapAndNotePage.shoppingCartButton);
        //Verify the text "Shopping Cart"
        expectedText = "Shopping Cart";
        actualText = lapAndNotePage.getVerificationText(lapAndNotePage.shoppingCartText).substring(0, 13);
        Assert.assertEquals(actualText, expectedText);
        //Verify the Product name "Sony VAIO"
        expectedText = "Sony VAIO";
        actualText = lapAndNotePage.setVerifyTheTextSonyVIAO();
        Assert.assertEquals(actualText, expectedText);
        //Change Quantity "2"
        lapAndNotePage.changeTheQty2();
        //Click on “Update” Tab
        lapAndNotePage.clickOnUpdateButton();
        //Verify the message “Success: You have modified your shopping cart!”
        expectedText = "Success: You have modified your shopping cart!";
        actualText = lapAndNotePage.verifyUpdatedCart();
        Assert.assertEquals(actualText, expectedText);
        //Verify the Total £1,472.45
        expectedText = "£1,472.45";
        actualText = lapAndNotePage.verifyTheTotal();
        Assert.assertEquals(actualText, expectedText);
        //Click on “Checkout” button
        lapAndNotePage.clickOnCheckout();
        //Verify the text “Checkout”
        expectedText = "Checkout";
        actualText = lapAndNotePage.verifyTheTextCheckout();
        Assert.assertEquals(actualText, expectedText);
        //Verify the Text “New Customer”
        expectedText = "New Customer";
        actualText = lapAndNotePage.verifyTheTextNewCustomer();
        Assert.assertEquals(actualText, expectedText);
        //Click on “Guest Checkout” radio button
        lapAndNotePage.clickOnGuestCheckout();
        //Click on “Continue” tab
        lapAndNotePage.clickOnContinue();
        //Fill the mandatory fields
        lapAndNotePage.enterFirstName();
        lapAndNotePage.enterLastName();
        lapAndNotePage.enterEmail();
        lapAndNotePage.enterTelephone();
        lapAndNotePage.enterAddress1();
        lapAndNotePage.enterCity();
        lapAndNotePage.enterPostcode();
        lapAndNotePage.enterState();
        //Click on “Continue” Button
        lapAndNotePage.clickOnContinueButton();
        //Add Comments About your order into text area
        lapAndNotePage.enterComment();
        lapAndNotePage.clickOnContinueAfterComment();
        //Check the Terms & Conditions check box
        lapAndNotePage.clickCheckBox();
        Thread.sleep(1000);
        lapAndNotePage.setContinueClicking();
        lapAndNotePage.clickOnConfirmButton();
        //Verify the message “Your order has been placed!”
        expectedText = "Your order has been placed!";
        actualText = lapAndNotePage.verifyOrderPlaced();
        Assert.assertEquals(actualText, expectedText);
    }
}
