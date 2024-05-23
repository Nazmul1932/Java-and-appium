package GPL.testcases;

import GPL.pages.BasePage;
import GPL.pages.OrderPage;
import GPL.pages.LoginLogoutPage;
import GPL.utilities.DriverSetUp;
import org.testng.annotations.Test;
import GPL.utils.Settings;

    public class OrderTest extends DriverSetUp {

        LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
        OrderPage orderPage = new OrderPage();
    @Test
    public void orderCreate() throws InterruptedException{
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
        orderPage.waitAndClick(orderPage.orderMenuButton);
        orderPage.waitAndClick(orderPage.selectChemistField);
        orderPage.waitAndClick(orderPage.clickChemist);
        orderPage.waitAndClick(orderPage.clickPlusIconOfDeliveryDate);
        orderPage.waitAndClick(orderPage.clickTodayDate());
        orderPage.waitAndClick(orderPage.clickOkButton);
        orderPage.scrollToElement();
        Thread.sleep(1000);
        orderPage.waitAndClick(orderPage.clickPlusIconOfAddProduct);
        orderPage.setText(orderPage.setQuantityOfProduct, "15");
        Thread.sleep(1000);
        orderPage.waitAndClick(orderPage.clickAddButton);
        Thread.sleep(1000);
        orderPage.scrollToElement();
        Thread.sleep(1000);
        orderPage.waitAndClick(orderPage.clickCreateOrderButton);
        Thread.sleep(1000);
        orderPage.takeScreenShot("Order Created Successfully");
        orderPage.waitAndClick(orderPage.clickOkButtonOfOrderConfirmation);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
}
