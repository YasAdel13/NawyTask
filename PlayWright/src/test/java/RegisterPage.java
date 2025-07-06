

import com.microsoft.playwright.Page;

public class RegisterPage {
    private final Page page;


    public RegisterPage(Page page) {
        this.page = page;
    }

    public void register(String username, String password) {
        page.locator("#signin2").click();
        page.locator("#sign-username").fill(username);
        page.locator("#sign-password").fill(password);
        page.locator("button:has-text('Sign up')").click();
    }
}
