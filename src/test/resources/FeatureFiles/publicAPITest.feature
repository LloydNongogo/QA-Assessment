
Feature: Produce API data

  Scenario: Retrieve API data from public PAI

    Given Perform an API request to produce a list of all dog breeds.
    Given Verify retriever breed is within the list.
    Given Verify a list of sub-breeds for retriever.
    Given Verify you can retrieve a random image or link for the sub-breed golden


