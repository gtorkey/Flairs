package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P001_createAdmin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D001_createAdmin {
    P001_createAdmin createAdmin = new P001_createAdmin();
    SoftAssert soft = new SoftAssert();
    Faker fake = new Faker();
    String username = fake.name().username();
    int recordsBeforeAdd;
    int recordsAfterAdd;
    int recordsAfterDelete;

    @Given("Navigate to Dashboard URL")
    public void navigateToDashboardURL() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("login to the system with username:{string} and password:{string}")
    public void loginToTheSystemWithUsernameAndPassword(String username, String pass) {
        createAdmin.userName.sendKeys(username);
        createAdmin.password.sendKeys(pass);
        createAdmin.loginButton.click();
    }

    @And("go to admin panel")
    public void goToAdminPanel() {
        createAdmin.admin.click();
    }

    @And("Get number of records")
    public void getNumberOfRecords() {
        recordsBeforeAdd = Integer.parseInt(createAdmin.numberOfRecords.getText().replaceAll("[^0-9]",""));
        System.out.println("Record Before add is: "+recordsBeforeAdd);
    }

    @When("crete new admin")
    public void creteNewAdmin() throws InterruptedException {
        createAdmin.addAdminButton.click();
        WebElement selectUserRole = createAdmin.selectTags.get(0);
        selectUserRole.click();
        createAdmin.selectAdmin.click();
        createAdmin.employeeName.sendKeys("le pham");
        Thread.sleep(2000);
        createAdmin.employeeName.sendKeys(Keys.ARROW_DOWN);
        createAdmin.employeeName.sendKeys(Keys.ENTER);
        WebElement selectStatus = createAdmin.selectTags.get(1);
        selectStatus.click();
        createAdmin.selectEnabled.click();
        createAdmin.adminUserName.sendKeys(username);
        createAdmin.adminPassword.sendKeys("123456789Aa@");
        createAdmin.confirmPassword.sendKeys("123456789Aa@");
        createAdmin.saveButton.click();


    }

    @Then("admin added successfully and number of records should increased by 1")
    public void adminAddedSuccessfullyAndNumberOfRecordsShouldIncreasedBy() {
        soft.assertTrue(createAdmin.successMassage.isDisplayed());
        soft.assertTrue(createAdmin.numberOfRecords.isDisplayed());
        recordsAfterAdd = Integer.parseInt(createAdmin.numberOfRecords.getText().replaceAll("[^0-9]",""));
        System.out.println("Record After add is: "+recordsAfterAdd);
        soft.assertEquals(recordsAfterAdd,recordsBeforeAdd+1);
        soft.assertAll();



    }

    @And("Search with the new username")
    public void searchWithTheNewUsername() {
        createAdmin.userNameSearch.sendKeys(username);
        createAdmin.searchButton.click();
        soft.assertEquals(createAdmin.numberOfRecords.getText(),"(1) Record Found");
        soft.assertAll();
    }

    @And("Delete the admin")
    public void deleteTheAdmin() {
        createAdmin.deleteIcon.click();
        createAdmin.confirmDelete.click();
    }

    @Then("admin deleted successfully and number of records should decrease by 1")
    public void adminDeletedSuccessfullyAndNumberOfRecordsShouldDecreaseBy() {
        soft.assertTrue(createAdmin.successMassage.isDisplayed());
        createAdmin.admin.click();
        recordsAfterDelete = Integer.parseInt(createAdmin.numberOfRecords.getText().replaceAll("[^0-9]",""));
        System.out.println("Record After delete is: "+recordsAfterDelete);
        soft.assertEquals(recordsAfterDelete,recordsBeforeAdd);
        soft.assertAll();
    }
}
