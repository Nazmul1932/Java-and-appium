package GPL.testcases;

import GPL.pages.DoctorCreationPage;
import GPL.pages.LoginLogoutPage;
import GPL.utilities.DriverSetUp;
import GPL.utils.Settings;
import org.testng.annotations.Test;
import java.util.Random;

public class DoctorCreationAndApprovalTest extends DriverSetUp
{
    private final LoginLogoutPage loginLogoutPage = new LoginLogoutPage();
    private final DoctorCreationPage doctorCreationPage = new DoctorCreationPage();
    private static final Random random = new Random();

    private static String generateRandomFirstName() {
        return random.ints(97, 123)
                .limit(random.nextInt(6) + 5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    public static String generateRandomEmail(String firstName) {
        return firstName.toLowerCase() + random.nextInt(100) + "@" + "yopmail.com";
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
    private final String email = generateRandomEmail(firstName);
    private final String phoneNumber = generateRandomPhoneNumber();
    private final String address = generateRandomAddress();

    @Test
    public void testDoctorCreationAndApproval() throws InterruptedException
    {
        performLogin();
        navigateToDoctorCreation();
        fillDoctorDetails();
        submitDoctorCreationForm();
        logoutUser();
    }
    private void performLogin() throws InterruptedException {
        loginLogoutPage.setTextByLocator(loginLogoutPage.userName, Settings.MPO_ID);
        loginLogoutPage.setTextByLocator(loginLogoutPage.passWord, Settings.PASSWORD);
        loginLogoutPage.waitAndClick(loginLogoutPage.loginButton);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickMenuPage);
    }
    private void navigateToDoctorCreation() throws InterruptedException {
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoctorIcon);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickPlusAddNewButton);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickAllowLocationPermission);
    }
    private void fillDoctorDetails() throws InterruptedException {
        doctorCreationPage.setTextByLocator(doctorCreationPage.setDoctorName, firstName);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setEmail, email);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setMobileNumber, phoneNumber);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setDoctorBusinessAddress, address);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setDoctorProfessionalAddress, address);
        doctorCreationPage.setTextByLocator(doctorCreationPage.setAddress1, address);
        scrollToElement();
        selectTerritories();
        selectDesignation();
        selectSpecialityAndBrand();
        uploadPhoto();
    }
    private void selectTerritories() throws InterruptedException {
        doctorCreationPage.waitAndClick(doctorCreationPage.clickPlusIconOfTerritorySelect);
        doctorCreationPage.setTextByLocator(doctorCreationPage.clickAndSearchField, "KHL213");
        doctorCreationPage.waitAndClick(doctorCreationPage.clickSearchedTerritory);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickPlusIconOfTerritorySelect);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickAnotherTerritory);
        scrollToElement();
    }
    private void selectDesignation() throws InterruptedException {
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDesignationDropdown);
        doctorCreationPage.setTextByLocator(doctorCreationPage.clickAndSearchFieldForDesignation, "ACMO");
        Thread.sleep(1000);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickForSelectDesignation);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoneForDesignation);
    }
    private void selectSpecialityAndBrand() throws InterruptedException {
        doctorCreationPage.waitAndClick(doctorCreationPage.clickSpecialityDropdown);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickForSelectSpeciality);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickBrandDropdown);
        doctorCreationPage.waitAndClick(doctorCreationPage.selectBrand);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoneForBrand);
        scrollToElement();
    }
    private void uploadPhoto() throws InterruptedException {
        doctorCreationPage.waitAndClick(doctorCreationPage.clickCameraIconField);
        doctorCreationPage.waitAndClick(doctorCreationPage.allowPermissionForTakePhoto);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickCameraIcon);
        doctorCreationPage.waitAndClick(doctorCreationPage.clickDoneIconForPhoto);
        scrollToElement();
    }
    private void submitDoctorCreationForm() throws InterruptedException {
        doctorCreationPage.waitAndClick(doctorCreationPage.clickSubmitButton);
        Thread.sleep(1000);
    }
    private void scrollToElement() throws InterruptedException {
        doctorCreationPage.scrollToElement();
        Thread.sleep(1000);
    }
    private void logoutUser() throws InterruptedException {
        loginLogoutPage.waitAndClick(loginLogoutPage.clickThreeParallelIcon);
        Thread.sleep(1000);
        loginLogoutPage.waitAndClick(loginLogoutPage.clickLogoutButton);
        Thread.sleep(1000);
    }
}
