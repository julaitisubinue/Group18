package com.vytrack.step_definitions;

import com.vytrack.utils.BrowserUtilities;
import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println("scenario = " + scenario.getSourceTagNames());
        System.out.println(":::Starting Automation :::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Before(value = "@db", order = 0)
    public void dbSetup(){
        System.out.println("::: Contenting to database ::::");
    }

    @After(value = "@db",order = 1)
    public void dbTearDown(){
        System.out.println("::: Disconnecting from the database :::");
    }

    @After
    public void tearDown(){
        BrowserUtilities.wait(3);
       Driver.closeDriver();
        System.out.println("(*___*)End of test execution(*___*)");
    }

}
