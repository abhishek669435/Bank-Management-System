Bank Management System (ATM Simulator)

A Java Swing based ATM banking simulation that allows users to perform basic banking operations such as deposit, withdrawal, fast cash, balance enquiry, mini statement, and PIN change. The system uses MySQL database with JDBC connectivity to store and manage transaction records.

Features

Login using PIN

Deposit Money

Withdraw Money

Fast Cash Withdrawal

Balance Enquiry

Mini Statement

Change PIN

Transaction history stored in MySQL

Technologies Used
Technology	Purpose
Java	Core Programming Language
Swing	GUI Development
MySQL	Database
JDBC	Database Connectivity
VS Code	Development Environment
Project Structure
bank.management.system
│
├── Login.java
├── Transactions.java
├── Deposit.java
├── Withdraw.java
├── FastCash.java
├── BalanceEnquiry.java
├── MiniStatement.java
├── PinChange.java
├── Conn.java
│
└── icons
    └── atm.png
Database Setup

Create a MySQL database:

create database banksystem;
use banksystem;

Create transaction table:

create table bank(
    pin varchar(10),
    date varchar(50),
    type varchar(20),
    amount varchar(20)
);
How to Run the Project
1. Compile the project
javac bank/management/system/*.java
2. Run the application
java bank.management.system.Login
System Workflow
Login
   ↓
ATM Transactions Screen
   ↓
Deposit / Withdraw / Fast Cash
   ↓
Balance Enquiry / Mini Statement
   ↓
Exit

All transactions are stored in the MySQL database.

Example Transaction Query
insert into bank(pin,date,type,amount)
values('1234',now(),'Deposit','5000');
Future Improvements

Add account registration system

Implement stronger security authentication

Convert the system into a web application

Add receipt generation feature

Author
Abhishek Sahay
