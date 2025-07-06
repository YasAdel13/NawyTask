import com.microsoft.playwright.Page;

public class CreateOrderPage {
    private final Page page;

    public CreateOrderPage(Page page) {
        this.page = page;
    }


    public void CreateOrder(String name ,String country,String city, int card , int month , int year) {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("yasmine adel", "Yas1381995");
        page.locator("a:has-text('Monitors')").click();

        page.waitForSelector("a:has-text('Apple monitor 24')",
                new Page.WaitForSelectorOptions().setTimeout(60000)
        );
        page.locator("a:has-text('Apple monitor 24')").click();

        page.waitForSelector("h2:has-text('Apple monitor 24')");
        page.onceDialog(dialog -> dialog.accept());

        page.locator("a:has-text('Add to cart')").click();
        page.waitForTimeout(2000);
        page.locator("#cartur").click();


        page.waitForSelector("button:has-text('Place Order')");
        page.locator("button:has-text('Place Order')").click();


        page.locator("#name").fill(name);
        page.locator("#country").fill(country);
        page.locator("#city").fill(city);
        page.locator("#card").fill(String.valueOf(card));
        page.locator("#month").fill(String.valueOf(month));
        page.locator("#year").fill(String.valueOf(year));

        page.locator("button:has-text('Purchase')").click();
        page.locator("button:has-text('OK')").click();

    }


}
