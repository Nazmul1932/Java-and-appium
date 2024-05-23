package GPL.testcases;

import GPL.pages.BasePage;
import GPL.pages.OrderPage;
import GPL.pages.LoginLogoutPage;
import GPL.pages.RXUploadPage;
import GPL.utilities.DriverSetUp;
import org.testng.annotations.Test;
import GPL.utils.Settings;

public class RXUploadTest extends DriverSetUp
{
    LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    RXUploadPage rxUpload = new RXUploadPage();
    @Test
    public void testRxUpload () throws InterruptedException
    {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(2000);
        rxUpload.waitAndClick(rxUpload.rxUploadMenu);
        rxUpload.waitAndClick(rxUpload.clickUploadRXButton);
        Thread.sleep(1000);
        rxUpload.waitAndClick(rxUpload.clickDoctorDropdown);
        rxUpload.waitAndClick(rxUpload.selectDoctor);
        rxUpload.waitAndClick(rxUpload.clickAddRXButton);
        rxUpload.waitAndClick(rxUpload.clickAllowWarningApp);
        Thread.sleep(1000);
        rxUpload.waitAndClick(rxUpload.clickCameraIcon);
        Thread.sleep(1000);
        rxUpload.waitAndClick(rxUpload.clickDoneButton);
        Thread.sleep(2000);
        rxUpload.scrollToElement();
        Thread.sleep(2000);
        rxUpload.waitAndClick(rxUpload.clickUploadRxButton);
        rxUpload.takeScreenShot("RX document upload Successfully");
        rxUpload.waitAndClick(rxUpload.clickOKButton);
        rxUpload.waitAndClick(rxUpload.clickBackButton);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(2000);
    }
}
