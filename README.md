# E-Commerce Application

This is a simple e-commerce application built in Java. It allows users to browse products, add them to a shopping cart, and complete the checkout process. The application supports various product types, including shippable and expirable items, and manages customer balances during transactions.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Setup and Installation](#setup-and-installation)

## Features

- **Product Management:** Supports different product types, including shippable and expirable items.
- **Shopping Cart:** Users can add products to their cart and view the total cost, including shipping fees for shippable items.
- **Checkout Process:** Validates purchases based on stock availability, product expiration, and customer balance.
- **Payment Processing:** Deducts the total amount from the customer's balance and updates product stock upon successful payment.

## Requirements

- Java 8 or higher

## Setup and Installation

Clone the repository:

```sh
git clone <your-repo-url>
```

Compile the project (from the project root):

```sh
javac -d target/classes src/main/java/org/eCommerce/services/*.java src/main/java/org/eCommerce/models/*.java src/main/java/org/eCommerce/*.java
```

Run the application:

```sh
java -cp target/classes org.eCommerce.Main
```

## Usage

The application demonstrates the following scenarios in the `Main` class:

1. **Successful checkout**
2. **Checkout with insufficient balance**
3. **Checkout with expired product**

You can modify `Main.java` to try other scenarios or add new features as needed.

---

Feel free to reach out if you have any questions or suggestions! 