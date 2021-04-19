package be.odisee.medec;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Stepdefs {

    WebDriver driver;
    @Given("^de planner bevindt zich op de planning pagina van toestel \"([^\"]*)\"$")
    public void dePlannerBevindtZichOpDePlanningPaginaVanToestel(String toestelNaam) throws Throwable {
        //throw new PendingException();
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080/planning/"+toestelNaam+".html");

    }

    @When("^de planner klikt op de \"([^\"]*)\" knop$")
    public void dePlannerKliktOpDeKnop(String knopNaam) throws Throwable {

        //throw new PendingException();
        driver.findElement(By.name(knopNaam)).click();
    }

    @Then("^de planner wordt doorgestuurd naar de pagina waar hij een nieuwe activiteit kan inplannen$")
    public void dePlannerWordtDoorgestuurdNaarDePaginaWaarHijEenNieuweActiviteitKanInplannen() {
        driver.navigate().to("http://localhost:8080/planning/Nieuw.html");
    }

    @Given("^de planner bevindt zich op de planning pagina waar hij een nieuwe activiteit kan inplannen$")
    public void dePlannerBevindtZichOpDePlanningPaginaWaarHijEenNieuweActiviteitKanInplannen() {
        //        driver.navigate().to("http://localhost:8080/planning/nieuweActiviteit.html");
    }

    @And("^de planner \"([^\"]*)\" als type activiteit kiest$")
    public void dePlannerAlsTypeActiviteitKiest(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^de planner \"([^\"]*)\" als medewerker kiest$")
    public void dePlannerAlsMedewerkerKiest(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^de planner een ingeplande opleiding ziet met de volgende gegevens$")
    public void dePlannerEenIngeplandeOpleidingZietMetDeVolgendeGegevens() {
    }

    @And("^De planner sluit de browser$")
    public void dePlannerSluitDeBrowser() throws Throwable{
        driver.quit();
    }

    ///////////// Planning Aanmaken /////////////////////////
    @Given("^de planner bevindt zich op de planning pagina waar hij een nieuwe planning kan maken$")
    public void dePlannerBevindtZichOpDePlanningPaginaWaarHijEenNieuwePlanningKanMaken() {
        driver.navigate().to("http://localhost:8080/planning/CreatePlanning.html");
    }

    @Then("^de planner moet een planning met naam \"([^\"]*)\" kunnen zien in de lijst van alle planningen$")
    public void dePlannerMoetEenPlanningMetNaamKunnenZienInDeLijstVanAllePlanningen(String planninNaam) throws Throwable {
        // wacht tot de planning pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Welcome To an overview of all Plannings"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Did not find this text: "+planninNaam+"\n",bodyText.contains(planninNaam));
    }

    @Then("^de planner moet een planning met naam \"([^\"]*)\" niet kunnen zien in de lijst van alle planningen$")
    public void dePlannerMoetEenPlanningMetNaamNietKunnenZienInDeLijstVanAllePlanningen(String planninNaam) throws Throwable {
        // wacht tot de planning pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Welcome To an overview of all Plannings"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertFalse("Expected not to find planning with name : "+planninNaam+"\n",bodyText.contains(planninNaam));
    }

    @Given("^de planner bevindt zich op de pagina met de lijst van alle planningen$")
    public void dePlannerBevindtZichOpDePaginaMetDeLijstVanAllePlanningen() {
        driver.navigate().to("http://localhost:8080/planning.html");
    }

    @When("^de planner selecteert de planning met naam \"([^\"]*)\"$")
    public void dePlannerSelecteertDePlanningMetNaam(String planningNaam) throws Throwable {
        // Link test van planninglijst moet de toestelnaam zijn
        driver.findElement(By.linkText(planningNaam)).click();
    }

    @Then("^de planner wordt doorgestuurd naar de detailspagina van planning met naam \"([^\"]*)\"$")
    public void dePlannerWordtDoorgestuurdNaarDeDetailspaginaVanPlanningMetNaam(String planningNaam) throws Throwable {
        // TODO get planning id where naam = planningNaam
        int id = 0;
        driver.navigate().to("http://localhost:8080/planning/Detailsplanning/"+id+".html");
    }

    @Given("^de planner bevindt zich op de detailspagina van planning met naam \"([^\"]*)\"$")
    public void dePlannerBevindtZichOpDeDetailspaginaVanPlanningMetNaam(String arg0) throws Throwable {
        // TODO get planning id where naam = planningNaam
        int id = 0;
        driver.navigate().to("http://localhost:8080/planning/Detailsplanning/"+id+".html");
    }

    @Then("^de planner moet een aangevulde formulier kunnen zien met waarde \"([^\"]*)\" in het naamveld$")
    public void dePlannerMoetEenAangevuldeFormulierKunnenZienMetWaardeInHetNaamveld(String planningNaam) throws Throwable {
        var element = driver.findElement(By.id("name"));
        Assert.assertSame("Did not find this text: " + planningNaam + "\n", element.getText(), planningNaam);

    }

    @Then("^de planner moet de bevestiging \"([^\"]*)\" kunnen zien$")
    public void dePlannerMoetDeBevestigingKunnenZien(String bevestigingTekst) throws Throwable {
/*        // wacht tot de bevestigings pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Welcome To an overview of all Plannings"));*/
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

    @When("^de planner vult \"([^\"]*)\" in het \"([^\"]*)\" veld$")
    public void dePlannerVultInHetVeld(String value, String veld) throws Throwable {
        driver.findElement(By.id(veld)).sendKeys(value);
    }
}
