Feature: Planning Aanmaken
  Een Planner moet een planning voor een bepaalde toestel kunnen aanmaken, bekijken,
  aanpassen en verwijderen.

  Scenario: Planning aanmaken
    Given de planner bevindt zich op de planning pagina waar hij een nieuwe planning kan maken
    When de planner vult "PlanningCD122" in het name veld
    And de planner klikt op de "submit" knop
    # wordt planner doorgestuurd naar lijst van alle planningen nadat de planning aangemaakt wordt?
    Then de planner moet een planning met naam "PlanningCD122" kunnen zien in de lijst van alle planningen
    And de planner sluit de browser

  Scenario: Planning aanmaken met onjuiste gegevens
    Given de planner bevindt zich op de planning pagina waar hij een nieuwe planning kan maken
    When de planner vult "" in het name veld
    And de planner klikt op de "submit" knop
    Then de planner moet "Name cannot be empty" op het scherm kunnen zien als validatiefout
    And de planner sluit de browser

  Scenario: Planning bekijken ,aanpassen en verwijderen
    Given de planner bevindt zich op de pagina met de lijst van alle planningen
    When de planner klikt op de details knop van planning met naam "PlanningCD122"
    Then de planner wordt doorgestuurd naar de detailspagina van planning met naam "PlanningCD122"
    # Planning aanpassen
    When de planner klikt op de "edit" knop
    Then de planner moet een aangevulde formulier kunnen zien met waarde "PlanningCD122" in het naamveld
    # Planning verwijderen
    When de planner terug keert naar de details pagina
    And de planner klikt op de "delete" knop
    Then de planner moet geen planning met naam "PlanningCD122" kunnen zien in de lijst van alle planningen
    And de planner sluit de browser

