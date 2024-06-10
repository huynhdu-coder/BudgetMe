# BudgetMe - Spring Boot Microservices

Welcome to BudgetMe, your personal financial budgeting app designed to help you manage your finances effortlessly. With BudgetMe, you can keep track of your expenses, visualize your spending habits, and make informed decisions about your money.

## Team Members
- **Utshav Khatiwada**
- **Dai Huynh**
- **Simon Manzler**
- **Benjamin Siener**
- **Nolan Huff**

## Functional Requirements
As a user
I want to create an account and customize my financial preferences
So that I can have a personalized budgeting experience

Requirement 1: Inputting Total Money and Expenses

Given a user is logged in and on the dashboard page
When the user inputs their total available money and lists their planned expenses (e.g., Bread: $10, Apple: $20)
Then the system should display the total money and itemized expenses correctly on the dashboard

Requirement 2: Customization of Financial Preferences

Given a user has successfully created an account
When the user logs in for the first time and answers questions about their financial goals, monthly income, and savings targets
Then the system should save these preferences and customize the dashboard to reflect these goals

## Features

### Landing Page
Our clean and intuitive landing page provides a brief overview of what BudgetMe is all about. From here, you can easily sign in or sign up to start managing your finances.

### First Time Sign-In
When you sign in for the first time, BudgetMe will ask you a few questions to understand your financial goals and preferences. This helps us tailor the app to better suit your needs.

### Dashboard
Once signed in, you'll be greeted with a comprehensive dashboard where you can input your total money and itemize your planned expenses.

### Expense Input
On the dashboard, you can input your total available money and list what you plan to spend it on. For example:
- **Total Input:** $1500
- **Bread:** $10
- **Apple:** $20

### Visualize Your Spending
BudgetMe features a dynamic chart at the bottom of the dashboard, which visualizes your spending as percentages of your total budget. For example, if you spend $10 on bread and $20 on apples from a total of $1500:
- **Bread:** (10 / 1500) * 100 = 0.67%
- **Apple:** (20 / 1500) * 100 = 1.33%

This helps you see at a glance where your money is going and adjust your spending habits accordingly.

## Story Board
1. After a user downloads BudgetMe successfully, a page with "Sign In" and "Log In" buttons occurs. The user registers for a new account and answers a few financial questions.
![Landing Page](https://github.com/huynhdu-coder/BudgetMe/blob/master/src/main/resources/LandingPage.PNG)

2. After passing the user authentication, a landing page with a welcoming message explains our goals, missions, and purposes.
![First Login Page](https://github.com/huynhdu-coder/BudgetMe/blob/master/src/main/resources/FirstLoginPage.PNG)

3. A dashboard occurs where the user can input their total money and itemize their planned expenses. 
![Dashboard](https://github.com/huynhdu-coder/BudgetMe/blob/master/src/main/resources/Dashboard.PNG)

## Class Diagram 
![Class Diagram](https://github.com/huynhdu-coder/BudgetMe/raw/master/src/main/resources/Diagram.drawio.png)
### Class Descriptions


#### BudgetMe
Represents the main class of the BudgetMe app. It contains methods for signing up, signing in, initializing the budget, and visualizing spending.

#### User
Represents a user of the app. It contains fields for the username and password.

#### Expense
Represents an expense item. It contains fields for the name of the expense and the amount.

#### Dashboard
Represents the dashboard of the app. It contains a list of expenses and the total amount of money available.


## JSON Schema
JSON Schema for the simple GET endpoint will be as follows: 
```json
{
  "budget": 1500,
  "expense": [
    {
      "name": "Bread",
      "price": 10,
      "category": "Food"
    },
    {
      "name": "Apple",
      "price": 20,
      "category": "Food"
    }
  ]
}
```

## Scrum roles

Product Owner/Scrum Master/DevOps/GitHub Administrator - Dai Huynh

UI Specialist - Benjamin Siener

Business Logic and Persistence Specialist - Simon Manzler

Developer - Utshav Khatiwada

Developer - Nolan Huff

## Milestones

[Milestone 1](https://github.com/huynhdu-coder/BudgetMe/milestone/1)

## Weekly Standup Meeting

[We meet 10:00 AM Eastern on Saturday on Teams](https://teams.microsoft.com/l/meetup-join/19%3ameeting_ODE1MGUwYTctYmZlNy00MDYzLWIyM2UtMTU5OTA3ZGI3N2Ex%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%22f17bfd08-cac7-4db5-b02d-5d84e54e7513%22%7d)
