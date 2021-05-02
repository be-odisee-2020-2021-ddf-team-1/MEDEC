package be.odisee.medec;

import be.odisee.medec.domain.Planning;
import be.odisee.medec.service.PlannerService;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Stepdefs {

    private WebDriver driver;
    private PlannerService plannerService;

    public void Init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("^de planner bevindt zich op de planning pagina waar hij een nieuwe planning kan maken$")
    public void dePlannerBevindtZichOpDePlanningPaginaWaarHijEenNieuwePlanningKanMaken() {
        Init();
        driver.navigate().to("http://localhost:8080/planning/CreatePlanning");
    }
    @Given("^de planner bevindt zich op de pagina met de lijst van alle planningen$")
    public void dePlannerBevindtZichOpDePaginaMetDeLijstVanAllePlanningen() {
        Init();
        driver.navigate().to("http://localhost:8080/planning/Overview");
    }
    @When("^de planner klikt op de details knop van planning met naam \"([^\"]*)\"$")
    public void dePlannerKliktOpDeDetailsKnopVanPlanningMetNaam(String planningNaam) throws Throwable {
        driver.findElement(By.id(planningNaam)).click();
    }
/*
    @When("^de planner vult \"([^\"]*)\" in het \"([^\"]*)\" veld$")
    public void dePlannerVultInHetVeld(String value, String veld) throws Throwable {
        driver.findElement(By.id(veld)).sendKeys(value);
    }*/
    @When("^de planner klikt op de \"([^\"]*)\" knop$")
    public void dePlannerKliktOpDeKnop(String knopNaam) throws Throwable {
       if (knopNaam.equals("submit")){
            driver.findElement(By.name(knopNaam)).click();
        }
        else{
        Thread.sleep(500);
        driver.findElement(By.id(knopNaam)).click();
        }

    }
    @When("^de planner vult \"([^\"]*)\" in het name veld$")
    public void dePlannerVultInHetNameVeld(String value) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(value);
    }
    @When("^de planner terug keert naar de details pagina$")
    public void dePlannerTerugKeertNaarDeDetailsPagina() {
        driver.navigate().back();
    }
    @Then("^de planner moet een planning met naam \"([^\"]*)\" kunnen zien in de lijst van alle planningen$")
    public void dePlannerMoetEenPlanningMetNaamKunnenZienInDeLijstVanAllePlanningen(String planninNaam) throws Throwable {
        // wacht tot de planning pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Welcome To an overview of all Plannings"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Did not find this text: "+planninNaam+"\n",bodyText.contains(planninNaam));
    }
    @Then("^de planner wordt doorgestuurd naar de detailspagina van planning met naam \"([^\"]*)\"$")
    public void dePlannerWordtDoorgestuurdNaarDeDetailspaginaVanPlanningMetNaam(String planningNaam) throws Throwable {
        // wacht tot de details pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Welcome To Planning"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Geen planning net naam  : "+planningNaam+"\n",bodyText.contains(planningNaam));
    }
    @Then("^de planner moet een aangevulde formulier kunnen zien met waarde \"([^\"]*)\" in het naamveld$")
    public void dePlannerMoetEenAangevuldeFormulierKunnenZienMetWaardeInHetNaamveld(String planningNaam) throws Throwable {
        driver.navigate().refresh();
        var inputValue = driver.findElement(By.id("name")).getAttribute("value");
        Assert.assertEquals("Both strings are not identical", planningNaam, inputValue);

    }
    @Then("^de planner moet de bevestiging \"([^\"]*)\" kunnen zien$")
    public void dePlannerMoetDeBevestigingKunnenZien(String bevestigingTekst) throws Throwable {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Did not find this text: "+bevestigingTekst+"\n",bodyText.contains(bevestigingTekst));
    }
    @Then("^de planner moet geen planning met naam \"([^\"]*)\" kunnen zien in de lijst van alle planningen$")
    public void dePlannerMoetGeenPlanningMetNaamKunnenZienInDeLijstVanAllePlanningen(String planningNaam) throws Throwable {
        // wacht tot de planning pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Welcome To an overview of all Plannings"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertFalse("Expected not to find planning with name : "+planningNaam+"\n",bodyText.contains(planningNaam));
    }
    @Then("^de planner moet \"([^\"]*)\" op het scherm kunnen zien als validatiefout$")
    public void dePlannerMoetOpHetSchermKunnenZienAlsValidatiefout(String foutmelding) throws Throwable {
        // wacht tot de planning pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Create a new planning"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Geen fout melding met inhoud  : "+foutmelding+"\n",bodyText.contains(foutmelding));
    }
    @And("^de planner sluit de browser$")
    public void dePlannerSluitDeBrowser() {
        driver.quit();
    }

}
