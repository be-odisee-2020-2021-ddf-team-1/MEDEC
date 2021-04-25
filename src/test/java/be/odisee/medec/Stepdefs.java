package be.odisee.medec;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
    @Given("^de planner bevindt zich op de planning pagina van toestel \"([^\"]*)\"$")
    public void dePlannerBevindtZichOpDePlanningPaginaVanToestel(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^de planner klikt op de \"([^\"]*)\" knop$")
    public void dePlannerKliktOpDeKnop(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^de planner wordt doorgestuurd naar de pagina waar hij een nieuwe activiteit kan inplannen$")
    public void dePlannerWordtDoorgestuurdNaarDePaginaWaarHijEenNieuweActiviteitKanInplannen() {
    }

    @Given("^de planner bevindt zich op de planning pagina waar hij een nieuwe activiteit kan inplannen$")
    public void dePlannerBevindtZichOpDePlanningPaginaWaarHijEenNieuweActiviteitKanInplannen() {
    }

    @And("^de planner \"([^\"]*)\" als type activiteit kiest$")
    public void dePlannerAlsTypeActiviteitKiest(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^de planner vult \"([^\"]*)\" in het veld startdatum$")
    public void dePlannerVultInHetVeldStartdatum(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^de planner vult \"([^\"]*)\" in het veld einddatum$")
    public void dePlannerVultInHetVeldEinddatum(String arg0) throws Throwable {
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
    public void dePlannerSluitDeBrowser() {
    }
}
