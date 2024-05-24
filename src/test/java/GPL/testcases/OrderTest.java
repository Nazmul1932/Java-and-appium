package GPL.testcases;

import GPL.pages.BasePage;
import GPL.pages.OrderPage;
import GPL.pages.LoginLogoutPage;
import GPL.utilities.DriverSetUp;
import org.testng.annotations.Test;
import GPL.utils.Settings;

public class OrderTest extends DriverSetUp {

        private final LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
        private final OrderPage orderPage = new OrderPage();
    @Test
    public void orderCreate() throws InterruptedException{
        loginAsUser(Settings.MPO_ID, Settings.PASSWORD);
        createOrder();
        logoutUser();
    }
    private void loginAsUser(String userId, String password) throws InterruptedException {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, userId);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, password);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
    }
    private void createOrder() throws InterruptedException {
        orderPage.waitAndClick(orderPage.orderMenuButton);
        orderPage.waitAndClick(orderPage.selectChemistField);
        orderPage.waitAndClick(orderPage.clickChemist);
        setDeliveryDate();
        addProductToOrder();
        submitOrder();
    }
    private void setDeliveryDate() throws InterruptedException {
        orderPage.waitAndClick(orderPage.clickPlusIconOfDeliveryDate);
        orderPage.waitAndClick(orderPage.clickTodayDate());
        orderPage.waitAndClick(orderPage.clickOkButton);
        orderPage.scrollToElement();
        Thread.sleep(1000);
    }
    private void addProductToOrder() throws InterruptedException {
        orderPage.waitAndClick(orderPage.clickPlusIconOfAddProduct);
        orderPage.setText(orderPage.setQuantityOfProduct, "15");
        Thread.sleep(1000);
        orderPage.waitAndClick(orderPage.clickAddButton);
        Thread.sleep(1000);
        orderPage.scrollToElement();
        Thread.sleep(1000);
    }
    private void submitOrder() throws InterruptedException {
        orderPage.waitAndClick(orderPage.clickCreateOrderButton);
        Thread.sleep(1000);
        orderPage.takeScreenShot("Order Created Successfully");
        orderPage.waitAndClick(orderPage.clickOkButtonOfOrderConfirmation);
        Thread.sleep(1000);
    }
    private void logoutUser() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
}
