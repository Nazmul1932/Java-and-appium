package GPL.testcases;

import GPL.pages.LoginLogoutPage;
import GPL.pages.SpecialOrderPage;
import GPL.utilities.DriverSetUp;
import GPL.utils.Settings;
import org.testng.annotations.Test;

public class SpecialOrderTest extends DriverSetUp
{
    private final LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    private final SpecialOrderPage specialOrderPage = new SpecialOrderPage();

    @Test
    public void testSpecialOrderCreateAndApprovalFromRSMAndZHUser() throws InterruptedException{

        loginAsUser(Settings.AM_ID, Settings.PASSWORD);
        createSpecialOrder();
        logout();

        loginAsUser(Settings.RSM_ID, Settings.PASSWORD);
        approvalFromRSM();
        logout();

        loginAsUser(Settings.ZH_ID, Settings.PASSWORD);
        approvalFromZH();
        logout();
    }
    private void loginAsUser(String userId, String password) throws InterruptedException {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, userId);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, password);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
    }
    private void createSpecialOrder() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
        specialOrderPage.waitAndClick(specialOrderPage.clickRequisitionOrder);
        specialOrderPage.waitAndClick(specialOrderPage.clickSelectDoctorField);
        specialOrderPage.waitAndClick(specialOrderPage.selectDoctor);
        specialOrderPage.waitAndClick(specialOrderPage.clickPlusIconOfDeliveryDate);
        specialOrderPage.waitAndClick(specialOrderPage.clickTodayDate());
        specialOrderPage.waitAndClick(specialOrderPage.clickOKButton);
        specialOrderPage.waitAndClick(specialOrderPage.clickPlusIconOfSelectProduct);
        specialOrderPage.setTextByLocator(specialOrderPage.setQuantityOfProduct, "1");
        Thread.sleep(2000);
        specialOrderPage.waitAndClick(specialOrderPage.clickAddButton);
        Thread.sleep(2000);
        specialOrderPage.scrollToElement();
        specialOrderPage.waitAndClick(specialOrderPage.clickCreateSpecialOrder);
        specialOrderPage.takeScreenShot("Special Order create successfully");
        specialOrderPage.waitAndClick(specialOrderPage.clickConfirmOKButton);
        specialOrderPage.waitAndClick(specialOrderPage.clickBackButton);
    }
    private void logout() throws InterruptedException{
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
    private void approvalFromRSM() throws InterruptedException{
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
        specialOrderPage.waitAndClick(specialOrderPage.clickApprovalIconOfRSM);
        specialOrderPage.waitAndClick(specialOrderPage.clickPendingRequestOfRSM);
        Thread.sleep(1000);
        scrollToElement();
        scrollToElement();
        specialOrderPage.waitAndClick(specialOrderPage.clickApprovalButtonOfRSM);
        specialOrderPage.takeScreenShot("Approval of Special Order from RSM  is successfully");
        specialOrderPage.waitAndClick(specialOrderPage.clickOKButtonOfRSM);
        specialOrderPage.waitAndClick(specialOrderPage.clickBackIcon1OfRSM);
        specialOrderPage.waitAndClick(specialOrderPage.clickBackIcon2OfRSM);
    }
    private void approvalFromZH() throws InterruptedException{
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
        specialOrderPage.waitAndClick(specialOrderPage.clickApprovalOFZH);
        specialOrderPage.waitAndClick(specialOrderPage.clickPendingOFZH);
        Thread.sleep(1000);
        scrollToElement();
        scrollToElement();
        specialOrderPage.waitAndClick(specialOrderPage.clickApproveButtonOfZH);
        specialOrderPage.takeScreenShot("Approval of Special Order from ZH  is successfully");
        specialOrderPage.waitAndClick(specialOrderPage.clickOKButtonOfZH);
        specialOrderPage.waitAndClick(specialOrderPage.clickBackIconOFZH);
        specialOrderPage.waitAndClick(specialOrderPage.clickBackButton2OfZH);
    }
    private void scrollToElement(){
        specialOrderPage.scrollToElement();
    }

}
