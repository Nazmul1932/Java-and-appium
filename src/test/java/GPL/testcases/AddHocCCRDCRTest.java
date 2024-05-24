package GPL.testcases;

import GPL.pages.AddHocCCRDCRPage;
import GPL.pages.LoginLogoutPage;
import GPL.utilities.DriverSetUp;
import GPL.utils.Settings;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddHocCCRDCRTest extends DriverSetUp {

    private final LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    private final AddHocCCRDCRPage addHoCcrDcr = new AddHocCCRDCRPage();

    @Test
    public void testAddHocCCR() throws InterruptedException {
        performLogin();
        navigateToMenuPage();
        startTourAndAllowLocation();
        navigateToAddHocCCR();
        selectChemistAndSubmitCCR();
        navigateBackToMain();
        performLogout();
    }
    @Test
    public void testAddHocDCR() throws InterruptedException{
        performLogin();
        navigateToMenuPage();
        startTourAndAllowLocation();
        navigateToAddHocDCR();
        fillAndSubmitDCR();
        navigateBackToMainFORDCR();
        performLogout();
    }
    private void performLogin() throws InterruptedException {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
    }
    private void performLogout() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
    private void navigateToMenuPage() {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
    }
    private void startTourAndAllowLocation() throws InterruptedException {
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickStartTour);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.allowLocation);
    }
    private void navigateToAddHocCCR() {
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickCCR);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickPlusForAdhocCCR);
    }
    private void navigateToAddHocDCR() {
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickDCR);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickAddHocDcr);
    }
    private void selectChemistAndSubmitCCR() throws InterruptedException {
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectChemistSearchField);
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSelectedChemist);
        addHoCcrDcr.scrollToElement();
        addHoCcrDcr.scrollToElement();
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickSubmitCCR);
        CCRAssertions();
        addHoCcrDcr.takeScreenShot("CCR submitted successfully");
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickOk);
    }
    private void CCRAssertions(){
        String successMessage = addHoCcrDcr.getText(addHoCcrDcr.getSuccessMessageForCCR);
        Assert.assertEquals(successMessage, "CCR has been submitted successfully");
    }
    private void fillAndSubmitDCR() throws InterruptedException {
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
        DCRAssertions();
        addHoCcrDcr.takeScreenShot("DCR submitted successfully");
        addHoCcrDcr.waitAndClick(addHoCcrDcr.clickOk);
    }
    private void DCRAssertions() {
        String successMessage = addHoCcrDcr.getText(addHoCcrDcr.getSuccessMessageForDCR);
        Assert.assertEquals(successMessage, "DCR Uploaded Successfully");
    }
    private void navigateBackToMain() throws InterruptedException {
        navigateBack(addHoCcrDcr.clickBackButton1, addHoCcrDcr.clickBackButton2, addHoCcrDcr.clickBackButton3);
    }
    private void navigateBackToMainFORDCR() throws InterruptedException {
        navigateBack(addHoCcrDcr.backBtn1, addHoCcrDcr.backBtn2);
    }
    private void navigateBack(By... buttons) throws InterruptedException {
        for (By button : buttons) {
            addHoCcrDcr.waitAndClick(button);
        }
        Thread.sleep(1000);
    }

}
