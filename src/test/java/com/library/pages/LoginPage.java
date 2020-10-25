package com.library.pages;

import com.library.utils.ConfigurationReader;
import com.library.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    private WebElement emailEnter;

    @FindBy(id = "inputPassword")
    private WebElement passwordEnter;

    public void login(){
        emailEnter.sendKeys(ConfigurationReader.getProperty("librarianEmail"));
        passwordEnter.sendKeys(ConfigurationReader.getProperty("librarianPassword"), Keys.ENTER);
    }

    public void login(String roles){
        if (roles.equalsIgnoreCase("librarian")) {
            emailEnter.sendKeys(ConfigurationReader.getProperty("librarianEmail"));
            passwordEnter.sendKeys(ConfigurationReader.getProperty("librarianPassword"), Keys.ENTER);
        }else if (roles.equalsIgnoreCase("student")){
            emailEnter.sendKeys(ConfigurationReader.getProperty("studentEmail"));
            passwordEnter.sendKeys(ConfigurationReader.getProperty("studentPassword"), Keys.ENTER);
        }else {
            System.out.println("Login fail, enter <librarian> or <student>");
        }
    }
}
