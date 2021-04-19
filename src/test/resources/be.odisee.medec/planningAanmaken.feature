Feature: Planning Aanmaken
  Een Planner moet een planning voor een bepaalde toestel kunnen aanmaken, bekijken,
  aanpassen en verwijderen.

  Scenario: Planning aanmaken
    Given de planner bevindt zich op de planning pagina waar hij een nieuwe planning kan maken
    When de planner vult "PlanningCD122" in het "naam" veld
    And de planner klikt op de "Save" knop
    # wordt planner doorgestuurd naar lijst van alle planningen nadat de planning aangemaakt wordt?
    Then de planner moet een planning met naam "PlanningCD122" kunnen zien in de lijst van alle planningen

  Scenario: Planning aanmaken met onjuiste gegevens
    Given de planner bevindt zich op de planning pagina waar hij een nieuwe planning kan maken
    When de planner vult "PlanningCDXXX" in het "naam" veld
    And de planner klikt op de "Save" knop
    Then de planner moet een planning met naam "PlanningCD122" niet kunnen zien in de lijst van alle planningen

  Scenario: Planning bekijken
    Given de planner bevindt zich op de pagina met de lijst van alle planningen
    When de planner selecteert de planning met naam "PlanningCD122"
    Then de planner wordt doorgestuurd naar de detailspagina van planning met naam "PlanningCD122"

  Scenario: Planning aanpassen
    Given de planner bevindt zich op de detailspagina van planning met naam "PlanningCD122"
    When de planner klikt op de "Edit" knop
    Then de planner moet een aangevulde formulier kunnen zien met waarde "PlanningCD122" in het naamveld

  Scenario: Planning verwijderen
    Given de planner bevindt zich op de detailspagina van planning met naam "PlanningCD122"
    When de planner klikt op de "Delete" knop
    # hoe/waar wordt bevestiging getoond?
    Then de planner moet de bevestiging "Successfully deleted Entry PlanningCD122" kunnen zien
    Then de planner moet geen planning met naam "PlanningCD122" kunnen zien in de lijst van alle planningen

