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
    private final LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    private final RXUploadPage rxUpload = new RXUploadPage();
    @Test
    public void testRxUpload () throws InterruptedException
    {
        loginAsUser(Settings.MPO_ID, Settings.PASSWORD);
        uploadRxDocument();
        logoutUser();
    }
    private void loginAsUser(String userId, String password) throws InterruptedException {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, userId);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, password);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
    }
    private void uploadRxDocument() throws InterruptedException {
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
        Thread.sleep(1000);
        rxUpload.scrollToElement();
        Thread.sleep(1000);
        rxUpload.waitAndClick(rxUpload.clickUploadRxButton);
        rxUpload.takeScreenShot("RX document upload Successfully");
        rxUpload.waitAndClick(rxUpload.clickOKButton);
        rxUpload.waitAndClick(rxUpload.clickBackButton);
    }
    private void logoutUser() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
}
