package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverOnElementAndClick(homePage.desktopTab);
        //call selectMenu method and pass the menu = “Show All Desktops”
        homePage.click(homePage.desktopTab, "Show AllDesktops");
        //Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = homePage.getVerificationText(homePage.desktopText);
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnElementAndClick(homePage.laptopAndNoteBookTabe);
        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.click(homePage.desktopTab, "Show AllLaptops & Notebooks");
        //Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = homePage.getVerificationText(homePage.laptopAndNoteBookText);
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //Mouse hover on “Components” Tab and click
        homePage.mouseHoverOnElementAndClick(homePage.componentTab);
        //call selectMenu method and pass the menu = “Show All Components”
        homePage.click(homePage.desktopTab, "Show AllComponents");
        //Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = homePage.getVerificationText(homePage.componentText);
        Assert.assertEquals(actualText, expectedText);
    }
}
