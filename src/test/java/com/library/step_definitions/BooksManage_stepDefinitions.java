package com.library.step_definitions;

import com.library.pages.BooksManagePage;
import com.library.pages.LoginPage;
import com.library.utils.ConfigurationReader;
import com.library.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class BooksManage_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    BooksManagePage booksManagePage= new BooksManagePage();
    @Given("I am at the Books Management page")
    public void i_am_at_the_books_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryUrl"));
        loginPage.login("librarian");
        booksManagePage.clickBooksTab();
    }

    @When("user select  page number")
    public void user_select_page_number() {
        booksManagePage.clickPage(5);
    }

    @Then("should display only selected number of pages")
    public void should_display_only_selected_number_of_pages() {
        Assert.assertTrue(booksManagePage.page5Verify());
    }

}
