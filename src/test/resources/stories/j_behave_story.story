Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check if paking slip was genereated
When payment is for a physical product
Then generate a packing slip for shipping

Scenario: Check if packing slip has been duplicated
When payment is for a book
Then duplicate packing slip for the royalty department


When payment is for a physical product or a book
Then generate a commission payment to the agent.

When payment is for a membership
Then activate that membership

When payment is for upgrading membership
Then upgrade has been applied.

When payment is for upgrading membership
Then e-mail the owner with upgrade subject

When payment is for a membership
Then e-mail the owner with activation subject

When payment is for the video “Learning to Ski"
Then “First Aid” video must be added to packing slip