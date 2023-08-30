# Jenn's Design Document

## Instructions

## The Dinner Decider Design

## 1. Problem Statement

Each week I spend a couple hours working to plan our meals for the week. The 
Dinner Decider will take that responsibility from me by creating a weekly meal 
plan that suits everyone's preferences. It will pull 8 meals from the meals 
database, allowing 1 chosen meal to be voted off by the family. This will free up
time in my weekend to be spent on other activities. 


## 2. Top Questions to Resolve in Review

List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.

1.  How do I attach photos to an object?   
2.  What will I do when there is a tie on which meal to vote off?  
3.  

## 3. Use Cases

This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.

U1. As a customer, I want to receive 8 meals, fitting specific 
parameters, when I ask the app to generate a meal plan.

U2. As a customer, I want to view my meal plan when I log into the
meal plan page.
    
U3. As a customer, I want to be able to vote for 1 meal to remove 
from the weekly meal plan. 

U4. As a customer, I want to be able to request a specific meal and 
have it included in the generated weekly meal plan. 

## 4. Project Scope

Clarify which parts of the problem you intend to solve. It helps reviewers know
what questions to ask to make sure you are solving for what you say and stops
discussions from getting sidetracked by aspects you do not intend to handle in
your design.

### 4.1. In Scope

Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?

* Auto generating weekly meal plans. 
* Allowing family members to vote off a meal. 
* Allowing family members to view weekly meal plans. 
* Allowing family members to request specific dinners. 

### 4.2. Out of Scope

Based on your problem description in Sections 1 and 3, are there any aspects
you are not planning to solve? Do potential expansions or related problems occur
to you that you want to explicitly say you are not worrying about now? Feel free
to put anything here that you think your team can't accomplish in the unit, but
would love to do with more time.

* It will not provide recipes. 
* It will not provide grocery lists. 
* It will not provide a ratings system yet. 

# 5. Proposed Architecture Overview

*Describe broadly how you are proposing to solve for the requirements you
described in Section 3.*

*This may include class diagram(s) showing what components you are planning to
build.*

*You should argue why this architecture (organization of components) is
reasonable. That is, why it represents a good data flow and a good separation of
concerns. Where applicable, argue why this architecture satisfies the stated
requirements.*

I will use API Gateway and Lambda to create four endpoints (GenerateMealPlan, 
ViewMealPlan, RequestAMeal, VoteOffAMeal). 

I will store meals in a DynamoDB table where they will be chosen at random, checked
to make sure they meet specific criteria and then added to an ArrayList of meal options
for the week. 

# 6. API

## 6.1. Public Models

Define the data models your service will expose in its responses via your
*`-Model`* package.

```
// MealModel
String mealId; 
String mealName;
Enum protein; 
Enum servedWith;      
String imageURL; 
```

## 6.2. Create Weekly Meal Plan Endpoint

*Describe the behavior of the first endpoint you will build into your service
API. This should include what data it requires, what data it returns, and how it
will handle any known failure cases. You should also include a sequence diagram
showing how a user interaction goes from user to website to service to database,
and back. This first endpoint can serve as a template for subsequent endpoints.
(If there is a significant difference on a subsequent endpoint, review that with
your team before building it!)*

*(You should have a separate section for each of the endpoints you are expecting
to build...)*

* Accepts a `POST` request to `java.MealPlan`  
* Accepts data to create a weekly meal plan. Returns a new ArrayList or Set of MealModel's. 

## 6.3 Get the Weekly Meal Plan Endpoint

* Accepts a `GET` request to `java.MealPlan` 
* Accepts nothing and returns the ArrayList of MealModel's. 

## 6.4 Vote for a Meal Endpoint

* Accepts a `POST` request to `java.MealPlan/id`
* Accepts a string and returns a number

## 6.5 Request a Meal Endpoint

* Accepts a `POST` request to `java.MealPlan`
* Accepts a String and returns string

# 7. Tables

## 7.1. `Meals`

```
mealId // partition key, string
mealName // string
protein // string
servedWith // string
imageURL // string 
```

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*

Users will have 4 options, View Menus, Request a Meal, Vote off a Meal, Generate 
Meal Plan. Each of those options will take them to another page where they will be able 
to view, submit their request, select a meal or generate the weekly plan. 
images/example_design_document/Dinner Decider Mockup.pdf