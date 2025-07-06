import com.microsoft.playwright.Page;

public class LogoutPage {
    private final Page page;

    public LogoutPage(Page page) {
        this.page = page;
    }

    public void logout() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("yasmine adel", "Yas1381995");
        page.waitForSelector("#logout2");
        page.locator("#logout2").click();
    }
}
