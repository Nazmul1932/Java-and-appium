package GPL.testcases;

import GPL.pages.AddHocCCRDCRPage;
import GPL.pages.LoginLogoutPage;
import GPL.utilities.DriverSetUp;
import GPL.utils.Settings;
import org.testng.annotations.Test;

public class AddHocCCRDCRTest extends DriverSetUp {

    LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    AddHocCCRDCRPage addHoCcrDcr = new AddHocCCRDCRPage();

    @Test
    public void testAddHocCCR() throws InterruptedException {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);

        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickStartTour);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.allowLocation);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickCCR);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickPlusForAdhocCCR);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectChemistSearchField);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectedChemist);
        addHoCcrDcr.scrollToElement();
        addHoCcrDcr.scrollToElement();
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSubmitCCR);
        addHoCcrDcr.takeScreenShot("CCR submitted successfully");
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickOk);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickBackButton1);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickBackButton2);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickBackButton3);

        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
    @Test
    public void testAddHocDCR() throws InterruptedException{
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);

        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickStartTour);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.allowLocation);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickDCR);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickAddHocDcr);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectDoctorField);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectedDoctor);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectShiftField);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickMorningShift);
        addHoCcrDcr.setTextByLocator(addHoCcrDcr.setSeenRx, "5");
        addHoCcrDcr.setTextByLocator(addHoCcrDcr.setGPLProductsOnRx, "7");
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickPlusForVisitedWith);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectedVisitWith);
        addHoCcrDcr.scrollToElement();
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickAddRx);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.allowToRecordImages);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickCameraIcon);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickDoneSign);
        Thread.sleep(1000);
        addHoCcrDcr.scrollToElement();
        addHoCcrDcr.waitAndClick(addHoCcrDcr.submitDCR);
        addHoCcrDcr.takeScreenShot("DCR submitted successfully");
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickOk);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.backBtn1);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.backBtn2);

        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
}
