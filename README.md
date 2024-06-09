# BudgetMe - Spring Boot Microservices

Welcome to BudgetMe, your personal financial budgeting app designed to help you manage your finances effortlessly. With BudgetMe, you can keep track of your expenses, visualize your spending habits, and make informed decisions about your money.

## Team Members
- **Utshav Khatiwada**
- **Dai Huynh**
- **Simon Manzler**
- **Benjamin Siener**
- **Nolan Huff**

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

## Class Diagram 
![Untitled Diagram.drawio.png](..%2F..%2F..%2FDownloads%2FUntitled%20Diagram.drawio.png)
### Class Descriptions

#### BudgetMe
Represents the main class of the BudgetMe app. It contains methods for signing up, signing in, initializing the budget, and visualizing spending.

#### User
Represents a user of the app. It contains fields for the username and password.

#### Expense
Represents an expense item. It contains fields for the name of the expense and the amount.

#### Dashboard
Represents the dashboard of the app. It contains a list of expenses and the total amount of money available.
