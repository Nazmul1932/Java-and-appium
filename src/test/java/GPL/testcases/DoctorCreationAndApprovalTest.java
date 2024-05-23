package GPL.testcases;

import GPL.pages.DoctorCreationPage;
import GPL.pages.LoginLogoutPage;
import GPL.utilities.DriverSetUp;
import GPL.utils.Settings;
import org.testng.annotations.Test;
import java.util.Random;

public class DoctorCreationAndApprovalTest extends DriverSetUp
{
    LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    DoctorCreationPage doctorCreationPage = new DoctorCreationPage();
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
    public static String generateRandomEmail(String firstName) {
        String domain = "yopmail.com";
        return firstName.toLowerCase() + random.nextInt(100) + "@" + domain;
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
    String email = generateRandomEmail(firstName);
    String phoneNumber = generateRandomPhoneNumber();
    String address = generateRandomAddress();



    @Test
    public void testDoctorCreationAndApproval() throws InterruptedException
    {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoctorIcon);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickPlusAddNewButton);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickAllowLocationPermission);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setDoctorName, firstName);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setEmail, email);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setMobileNumber, phoneNumber);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setDoctorBusinessAddress, address);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setDoctorProfessionalAddress, address);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setAddress1, address);
        doctorCreationPage.scrollToElement();
        doctorCreationPage.waitAndClick(doctorCreationPage.clickPlusIconOfTerritorySelect);
        doctorCreationPage.setTextByLocator(doctorCreationPage.clickAndSearchField, "KHL213");
        doctorCreationPage.waitAndClick(doctorCreationPage.clickSearchedTerritory);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickPlusIconOfTerritorySelect);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickAnotherTerritory);
        Thread.sleep(1000);
        doctorCreationPage.scrollToElement();
        Thread.sleep(1000);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDesignationDropdown);
        doctorCreationPage.setTextByLocator(doctorCreationPage.clickAndSearchFieldForDesignation, "ACMO");
        Thread.sleep(1000);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickForSelectDesignation);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoneForDesignation);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickSpecialityDropdown);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickForSelectSpeciality);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickBrandDropdown);
        doctorCreationPage.waitAndClick(doctorCreationPage.selectBrand);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoneForBrand);
        doctorCreationPage.scrollToElement();
        doctorCreationPage.waitAndClick(doctorCreationPage.clickCameraIconField);
        doctorCreationPage.waitAndClick(doctorCreationPage.allowPermissionForTakePhoto);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickCameraIcon);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoneIconForPhoto);
        Thread.sleep(1000);
        doctorCreationPage.scrollToElement();
        Thread.sleep(1000);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickSubmitButton);
        Thread.sleep(1000);
    }
}
