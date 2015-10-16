Given Physical Product Processor is given
When I process payment for physical product
Then Packing slip generated
Then Commission payment generated

Given Processor is given
When I process payment for membership
Then Membership activated