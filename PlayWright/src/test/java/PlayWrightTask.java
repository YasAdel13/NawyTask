import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class PlayWrightTask {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeEach
    void setup (){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.demoblaze.com");
    }

    @AfterEach
    void tearDown(){
        browser.close();
        playwright.close();
    }

    @Test
    void registerWithValidData() {
        RegisterPage registerPage = new RegisterPage(page);
        registerPage.register("yasmine adel", "Yas1381995");
    }

    @Test
    void loginWithValidData() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("yasmine adel", "Yas1381995");
    }

    @Test
    void logout() {
        LogoutPage logoutPage = new LogoutPage(page);
        logoutPage.logout();
    }

    @Test
    void CreateAnOrder(){
        CreateOrderPage createOrderPage = new CreateOrderPage(page);
        createOrderPage.CreateOrder("yasmine","Egypt","cairo",1381995,5,2025);

    }
}
