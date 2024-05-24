package GPL.testcases;

import GPL.CustomOrder;
import GPL.pages.ChemistCreationAndApprovalPage;
import GPL.pages.LoginLogoutPage;
import GPL.utilities.DriverSetUp;
import GPL.utils.Settings;
import org.testng.annotations.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Random;


public class ChemistCreationAndApprovalTest extends DriverSetUp
{
    private final LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    private final ChemistCreationAndApprovalPage chemistCreationAndApprovalPage = new ChemistCreationAndApprovalPage();
    private static final Random random = new Random();

    private static String generateRandomFirstName() {
        return random.ints(97, 123)
                .limit(random.nextInt(6) + 5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    private static String generateRandomPhoneNumber() {
        return "+8801" + random.ints(0, 10)
                .limit(9)
                .mapToObj(Integer::toString)
                .reduce("", String::concat);
    }
    private static String generateRandomAddress() {
        return String.format("%d, Street %d, Dhaka", random.nextInt(100) + 1, random.nextInt(50) + 1);
    }

    private final String firstName = generateRandomFirstName();
    private final String phoneNumber = generateRandomPhoneNumber();
    private final String address = generateRandomAddress();

    @Test
    public void testChemistCreationFromMPO() throws InterruptedException{
        loginAsUser(Settings.MPO_ID, Settings.PASSWORD);
        navigateToChemistCreationPage();
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickAllowPermissionForLocation);
        fillChemistDetails();
        selectChemistOptions();
        uploadChemistPhoto();
        submitChemistCreationForm();
        logoutUser();
    }
    @Test
    public void testChemistApprovalFromAM() throws InterruptedException {
        loginAsUser(Settings.AM_ID, Settings.PASSWORD);
        approveChemistRequest();
        logoutUser();
    }
    private void loginAsUser(String userId, String password) throws InterruptedException {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, userId);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, password);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
    }
    private void navigateToChemistCreationPage() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickChemistIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPlusAddNewChemistIcon);
    }
    private void fillChemistDetails() throws InterruptedException {
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setChemistName, firstName);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setProprietorName, firstName);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setMobileNumber, phoneNumber);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setAddress1, address);
        Thread.sleep(1000);
        chemistCreationAndApprovalPage.scrollToElement();
    }
    private void selectChemistOptions() throws InterruptedException {
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickCustomerTypeDropdown);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickCustomerType);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickDropdownOfMarket);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickMarket);
        chemistCreationAndApprovalPage.scrollToElement();
        Thread.sleep(1000);
        selectTerritory();
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickSelectRouteButton);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.selectRoute);
        chemistCreationAndApprovalPage.scrollToElement();
    }
    private void selectTerritory() throws InterruptedException {
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPlusIconForTerritoryDropdown);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.clickSearchFieldOfTerritoryDropdown, "KHL213");
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickedSearchedTerritory);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPlusIconForTerritoryDropdown);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickedAnotherTerritory);
    }
    private void uploadChemistPhoto() throws InterruptedException {
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickAddPhotoIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPermissionForCamera);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickCameraIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickDoneForCamera);
        Thread.sleep(1000);
        chemistCreationAndApprovalPage.scrollToElement();
    }
    private void submitChemistCreationForm() throws InterruptedException {
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickSubmitButton);
        chemistCreationAndApprovalPage.takeScreenShot("Chemist Created Successfully");
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickOkButtonOfChemistAddModal);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickBackIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickBackIcon);
        Thread.sleep(1000);
    }
    private void approveChemistRequest() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickApprovalIcon);
        Thread.sleep(1000);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickFirstRequestOfChemist);
        Thread.sleep(1000);
        chemistCreationAndApprovalPage.scrollToElement();
        chemistCreationAndApprovalPage.scrollToElement();
        chemistCreationAndApprovalPage.scrollToElement();
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickApprovalButton);
        chemistCreationAndApprovalPage.takeScreenShot("Chemist Approved Successfully");
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickOkOfSuccessButton);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickBackButton);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.getClickBackButton2);
        Thread.sleep(1000);
    }
    private void logoutUser() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }

}
