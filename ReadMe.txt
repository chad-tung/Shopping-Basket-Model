You have been asked to model a shopping basket.

You must be able to:

add items to the shopping basket,
remove items from the shopping basket,
empty the shopping basket.
Additionally, you must be able to calculate the total value of the shopping basket. This should account for:

buy-one-get-one-free discounts on items,
10% off on totals greater than £20 (after previous discount is applied),
2% off on total for customers with loyalty cards (after all other discounts are applied).
You must be able to validate that the code works through passing tests.

What we will be looking for:
Evidence of 'solid' coding techniques and test driven development.


Reflection:

What was done well:
I felt that I tested well, and that I was disciplined in the TDD.
I split up the classes well
Was mostly SOLID and DRY

What could have been done better:
In hindsight, I should have had subclasses of items, as not everything in stores should be discountable. (ie giftcards etc. Only thought of this when doing the automatedcheckout tests.)

Should have had a discountable interface.

Probably shouldn't have left the responsibility of applying the buy one get one free objects to the basket. That's the till's/checkouts responsibility. I suppose if it's internet shopping, then that's maybe okay, but even then, normally discounts only really happen upon checkout.
