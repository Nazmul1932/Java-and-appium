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
    LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    ChemistCreationAndApprovalPage chemistCreationAndApprovalPage = new ChemistCreationAndApprovalPage();

    private static final Random random = new Random();
    public static String generateRandomFirstName() {
        StringBuilder firstName = new StringBuilder();
        int length = random.nextInt(6) + 5;
        for (int i = 0; i < length; i++) {
            char ch = (char) (random.nextInt(26) + 'a');
            firstName.append(ch);
        }
        return firstName.toString();
    }
    public static String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("+8801");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
    public static String generateRandomAddress() {
        StringBuilder address = new StringBuilder();
        address.append(random.nextInt(100) + 1);
        address.append(", ");
        address.append("Street ");
        address.append(random.nextInt(50) + 1);
        address.append(", ");
        address.append("Dhaka");
        return address.toString();
    }
    String firstName = generateRandomFirstName();
    String phoneNumber = generateRandomPhoneNumber();
    String address = generateRandomAddress();

    @Test
//    @CustomOrder(1)
    public void testChemistCreationFromMPO () throws InterruptedException{
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickChemistIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPlusAddNewChemistIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickAllowPermissionForLocation);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setChemistName,firstName);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setProprietorName,firstName);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setMobileNumber,phoneNumber);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.setAddress1,address);
        Thread.sleep(1000);
        chemistCreationAndApprovalPage.scrollToElement();
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickCustomerTypeDropdown);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickCustomerType);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickDropdownOfMarket);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickMarket);
        chemistCreationAndApprovalPage.scrollToElement();
        Thread.sleep(1000);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPlusIconForTerritoryDropdown);
        chemistCreationAndApprovalPage.setTextByLocator(chemistCreationAndApprovalPage.clickSearchFieldOfTerritoryDropdown, "KHL213");
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickedSearchedTerritory);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPlusIconForTerritoryDropdown);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickedAnotherTerritory);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickSelectRouteButton);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.selectRoute);
        chemistCreationAndApprovalPage.scrollToElement();
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickAddPhotoIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickPermissionForCamera);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickCameraIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickDoneForCamera);
        Thread.sleep(1000);
        chemistCreationAndApprovalPage.scrollToElement();
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickSubmitButton);
        chemistCreationAndApprovalPage.takeScreenShot("Chemist Created Successfully");
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickOkButtonOfChemistAddModal);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickBackIcon);
        chemistCreationAndApprovalPage.waitAndClick(chemistCreationAndApprovalPage.clickBackIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
    @Test
//    @CustomOrder(2)
    public void testChemistApprovalFromAM() throws InterruptedException{
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.AM_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
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
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }

}
