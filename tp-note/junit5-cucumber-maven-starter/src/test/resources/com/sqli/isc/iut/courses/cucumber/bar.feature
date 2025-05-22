Feature: Bar

Background: Le Juste
    Given 'MR. Pignon' go into the 'Le Juste'
    And 'MR. Leblanc' go into the 'Le Juste'
    And the 'Le Juste' has only 10 seats

Scenario: Bar is almost full
    When 9 seats are already taken
    Then 'MR. Pignon' cannot enter the 'Le Juste'
    And 'MR. Leblanc' cannot enter the 'Le Juste'

Scenario: Classic night at the bar
    When 8 seats are already taken
    Then 'MR. Pignon' can enter the 'Le Juste'
    And 'MR. Leblanc' can enter the 'Le Juste'
    Then the person after 'MR. Pignon' and 'MR. Leblanc' cannot enter the 'Le Juste'
    And the 'Le Juste' is full
    Then 'MR. Pignon' order a cocktail of the month for 10€
    Then 'MR. Leblanc' order a cocktail of the month for 10€
    Then they agree that 'MR. Leblanc' will pay the bill
    Then 'MR. Pignon' finish his cocktail
    Then 'MR. Leblanc' finish his cocktail
    And the bill is checked
    Then 'MR. Leblanc' pay 20€
    Then 'MR. Pignon' is happy because they consumed only one cocktail because 'MR. Pignon' has a liver problem

Scenario: Too much cocktails
    When 3 seats are already taken
    Then 'MR. Pignon' can enter the 'Le Juste'
    And 'MR. Leblanc' can enter the 'Le Juste'
    Then 'MR. Pignon' order a cocktail of the month for 10€
    Then 'MR. Leblanc' order a cocktail of the month for 10€
    Then each one of them pay their own bill
    Then 'MR. Pignon' finish his cocktail
    Then 'MR. Leblanc' finish his cocktail
    Then 'MR. Pignon' check his bill
    And 'MR. Pignon' pay 10€
    Then 'MR. Leblanc' insisits to drink another cocktail
    Then 'MR. Leblanc' order two cocktail of the month for 10€
    And 'MR. Leblanc' will pay the bill
    Then 'MR. Pignon' finish his cocktail
    Then 'MR. Leblanc' finish his cocktail
    Then 'MR. Leblanc' check his bill
    And 'MR. Leblanc' pay 20€
    Then 'MR. Pignon' is sad because they consumed too much cocktails and he will have a bad night of sleep
    
    