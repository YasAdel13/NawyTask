package com.serenitydojo.platwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@UsePlaywright (ASimplePlayWrightTest.CustomOption.class)
public class ASimplePlayWrightTest {

    public static class CustomOption implements OptionsFactory {
        @Override
        public Options getOptions(){
            return new Options().setHeadless(false).setLaunchOptions(new BrowserType.LaunchOptions().setArgs(Arrays
                    .asList("--no-sandbox")));
        }

    }

//    Playwright playwright;
//    Browser browser;
//    Page page;
//
//    @BeforeEach
//    void setup (){
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(Arrays
//                .asList("--no-sandbox")));
//
//         page = browser.newPage();
//    }
//
//    @AfterEach
//    void teardown(){
//        browser.close();
//        playwright.close();
//    }
//



    @Test
    void LogInWithValidData (Page page) throws InterruptedException {

        page.navigate("https://www.demoblaze.com");
        page.locator("#login2").click();
        page.locator("#loginusername").fill("yasmine adel");
        page.locator("#loginpassword").fill("Yas1381995");
        page.locator("button:has-text(' Log in')").click();
    }

    @Test
    void RegisterWithValidData (Page page) {

        page.navigate("https://www.demoblaze.com");
        page.locator("#signin2").click();
        page.locator("#sign-username").fill("yasmine adel");
        page.locator("#sign-password").fill("Yas1381995");
        page.locator("button:has-text('Sign up')").click();
    }



    @Test
    void ShouldShowThePageTitle (Page page) {

        page.navigate("https://practicesoftwaretesting.com/");
        String title = page.title();
        //Assertions.assertTrue(title.contains("Practice software testing"));
        Assertions.assertTrue(title.toLowerCase().contains("practice software testing"));

    }

    @Test
    void ShouldSearchByKeyWord(Page page){
        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("[placeholder=Search]").fill("[pliers");
        page.locator("button:has-text('Search')").click();
        int matchingSearchResult = page.locator(".card-img-top").count();
        Assertions.assertTrue(matchingSearchResult > 0);
    }
}
