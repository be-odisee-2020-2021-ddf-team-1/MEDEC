Feature: Activiteit inplannen

  Een planner moet een activiteit kunnen inplannen

  Scenario: De planner navigeert naar de pagina waar hij een nieuwe activiteit kan inplannen
    Given de planner bevindt zich op de planning pagina van toestel "CD122"
    When de planner klikt op de "Plan nieuwe activiteit" knop
    Then de planner wordt doorgestuurd naar de pagina waar hij een nieuwe activiteit kan inplannen

  Scenario: De planner vult de gegevens in van een nieuwe activiteit
    Given de planner bevindt zich op de planning pagina waar hij een nieuwe activiteit kan inplannen
    And de planner "opleiding" als type activiteit kiest
    And de planner vult "15/06/2021 15:00:00" in het "startdatum" veld
    And de planner vult "15/06/2021 19:00:00" in het "einddatum" veld
    And de planner "Jan" als medewerker kiest
    And de planner klikt op de "Save" knop
    Then de planner een ingeplande opleiding ziet met de volgende gegevens
      | label       | data                |
      | Startdatum: | 15/06/2021 15:00:00 |
      | Einddatum:  | 15/06/2021 19:00:00 |
      | Medewerker: | Jan                 |
    And De planner sluit de browser