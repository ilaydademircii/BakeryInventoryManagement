# Bakery Inventory Management System

## About the Project

This project is a **Bakery Inventory Management System** developed using **Java Swing**, **MySQL**, and designed with the **Model-View-Controller (MVC)** architecture along with the **Command Design Pattern**.
It is intended to support bakery operations such as customer and product management, inventory tracking, sales processing, and payment monitoring in a structured and scalable way.

## Features

* **Customer Management**

  * Add new customers
  * Delete existing customers
  * List all customers
* **Inventory Management**

  * Add ingredient types
  * Add ingredients
  * Add recipe cards for bakery products
* **Product Management**

  * Add new bakery products
* **Sales and Payment**

  * Perform sales by selecting customers and products
  * Record customer payments
  * View customer payment history
  * List all customers with remaining balances

## Technologies Used

* **Java (Swing)** – for GUI
* **MySQL** – for data storage
* **JDBC** – for database connectivity
* **MVC Architecture** – to separate business logic, UI, and data access layers
* **Command Design Pattern** – to encapsulate operations like save, delete, update, and execute them flexibly

## Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/ilaydademircii/BakeryInventoryManagement.git
   ```

2. **Set up the MySQL database**

   * Create a new MySQL database
   * Run any included SQL scripts (if provided) to generate the required tables
   * Update the database configuration (host, port, username, password) in the project source code

3. **Run the project**

   * Open the project in your Java IDE (e.g., IntelliJ IDEA, Eclipse)
   * Build and run the application

## Usage

* Use the graphical interface to:

  * Add, delete, and view customers
  * Manage ingredient categories and individual items
  * Create and assign recipe cards
  * Add bakery products
  * Perform sales operations by selecting customers and products
  * Record payments and check outstanding balances
  * View customer payment history

## Architecture Overview

This application uses:

* **MVC Pattern:**

  * `Model` classes handle data logic and interaction with the database
  * `View` classes provide the user interface using Java Swing
  * `Controller` classes manage user input and coordinate between the Model and View
* **Command Pattern:**

  * Encapsulates actions such as adding, deleting, listing, and updating into separate command classes
  * Provides flexibility and scalability by decoupling operations from UI logic

## Contributing

If you'd like to contribute to the project, feel free to fork the repository, make your changes, and submit a pull request.
