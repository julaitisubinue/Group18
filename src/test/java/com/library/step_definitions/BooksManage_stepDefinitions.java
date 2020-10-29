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

////////////////////////AC1///////////////////////////////
    @Then("user select {string} from Book Category")
    public void user_select_from_book_category(String string) {
        booksManagePage.select_bookCategories(string);
    }

    @Then("The table should display only {string} books")
    public void the_table_should_display_only_books(String string) {
        for (String each:booksManagePage.verify_categoryList()) {
            Assert.assertEquals(string, each);
        }

    }

    ////////////////////////AC2/////////////////////
    @Given("user select view {int} records per page")
    public void user_select_view_records_per_page(Integer int1) {
        booksManagePage.select_recordsPerPage(int1);
    }

    @Then("only {int} records are displayed on page")
    public void only_records_are_displayed_on_page(int int1) {
        Assert.assertEquals(int1,booksManagePage.verify_recordOfPage().size());
    }

    //////////////////////AC3//////////////////////////////////////
    @When("user click {string} button")
    public void userClickButton(String button) {
        booksManagePage.click_blueButtons(button);
    }

    @Then("The {string} form is displayed")
    public void the_form_is_displayed(String formName) {
      Assert.assertTrue(booksManagePage.verify_fromDisplay(formName));
    }

}
