package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P001_createAdmin {
    public P001_createAdmin(){
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(css = "input[placeholder=\"Username\"]")
    public WebElement userName;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(css = "button[type=\"submit\"]")
    public WebElement loginButton;
    @FindBy(css = "a[href=\"/web/index.php/admin/viewAdminModule\"]")
    public WebElement admin;
    @FindBy(className = "orangehrm-vertical-padding")
    public WebElement numberOfRecords;
    @FindBy(css = "div[class=\"orangehrm-header-container\"] button")
    public WebElement addAdminButton;
    @FindBy(css = "div[class=\"oxd-select-text-input\"]")
    public List<WebElement> selectTags;
    @FindBy(css = "div[role=\"listbox\"] div:nth-of-type(2)")
    public WebElement selectAdmin;
    @FindBy(css = "input[placeholder=\"Type for hints...\"]")
    public WebElement employeeName;
    @FindBy(css = "div[role=\"listbox\"] div:nth-of-type(2)")
    public WebElement selectEnabled;
    @FindBy(css = "div[class=\"oxd-form-row\"] div[class=\"oxd-grid-item oxd-grid-item--gutters\"]:nth-child(4) input")
    public WebElement adminUserName;
    @FindBy(css = ".user-password-row div[class=\"oxd-grid-item oxd-grid-item--gutters user-password-cell\"] input")
    public WebElement adminPassword;
    @FindBy(css = ".user-password-row div[class=\"oxd-grid-item oxd-grid-item--gutters\"] input")
    public WebElement confirmPassword;
    @FindBy(css = "button[type=\"submit\"]")
    public WebElement saveButton;
    @FindBy(css = "div[class=\"oxd-toast oxd-toast--success oxd-toast-container--toast\"]")
    public WebElement successMassage;
    @FindBy(css = ".oxd-table-filter input[class=\"oxd-input oxd-input--active\"]")
    public WebElement userNameSearch;
    @FindBy(css = "button[type=\"submit\"]")
    public WebElement searchButton;
    @FindBy(className = "bi-trash")
    public WebElement deleteIcon;
    @FindBy(css = "button[class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")
    public WebElement confirmDelete;




}
