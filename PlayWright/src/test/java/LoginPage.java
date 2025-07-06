import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;



    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.locator("#login2").click();
        page.locator("#loginusername").fill(username);
        page.locator("#loginpassword").fill(password);
        page.locator("button:has-text(' Log in')").click();
    }
}
