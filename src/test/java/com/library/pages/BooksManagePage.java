package com.library.pages;

import com.library.utils.BrowserUtilities;
import com.library.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BooksManagePage {
    public BooksManagePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),8);

    @FindBy(xpath = "//span[.='Books']")
    private WebElement booksTab;

    @FindBy(xpath = "//div[@id='tbl_books_paginate']//a[.=5]")
    private WebElement page5;

    @FindBy(xpath = "//div[@id='tbl_books_paginate']//a[.=5]/..")
    private WebElement page5Verify;

    @FindBy(xpath = "//select[@class='form-control select2']")
    private WebElement bookCategoriesSelector;

    @FindBy(xpath = "//tbody//td[5]")
    private List<WebElement> categoryList;

    @FindBy(name = "tbl_books_length")
    private WebElement recordsPerPageSelector;

    @FindBy(xpath = "//tbody//tr")
    private List<WebElement>recodeList;

    @FindBy(xpath = "//a[.=' Add Book']")
    private WebElement addBookButton;

    @FindBy(css = "div.modal-header")
    public WebElement addBookForm;

    public void click_addBook(){
        BrowserUtilities.waitClickOnElement(addBookButton);
    }

    public void clickBooksTab(){
        BrowserUtilities.waitClickOnElement(booksTab);
    }

    public void clickPage(){
        BrowserUtilities.scrollTo(page5);
        BrowserUtilities.waitClickOnElement(page5);
    }

    public void clickPage(int pageNumber){
        String xpath = "//div[@id='tbl_books_paginate']//a[.="+(pageNumber+"")+"]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        BrowserUtilities.scrollTo(element);
        BrowserUtilities.waitClickOnElement(element);
    }

    public boolean page5Verify(){
        BrowserUtilities.wait(1);
        String str = page5Verify.getAttribute("class");
        return str.contains("active");
    }

    public void select_bookCategories(String categories){
        Select select = new Select(bookCategoriesSelector);
        select.selectByVisibleText(categories);
    }

    public ArrayList<String> verify_categoryList(){

        BrowserUtilities.wait(1);
        //wait.until(ExpectedConditions.visibilityOfAllElements(categoryList));
        ArrayList<String>arrayList = new ArrayList<>();
        for (WebElement each: categoryList){
            arrayList.add(each.getText());
        }


        return arrayList;
    }

    public void select_recordsPerPage(int num){
        Select select = new Select(recordsPerPageSelector);
        select.selectByVisibleText((num+""));
    }

    public ArrayList<String> verify_recordOfPage(){
        BrowserUtilities.wait(1);
        ArrayList<String>arrayList = new ArrayList<>();
        for (WebElement each :recodeList){
            arrayList.add(each.getText());
        }
        return arrayList;
    }

    public boolean addBookForm(){

       BrowserUtilities.wait(1);
        return addBookForm.isDisplayed();
    }
}
