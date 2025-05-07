# 🤖 AliExpress Testing Suite — Robot Framework + Selenium

Welcome to the **AliExpress Functional Test Suite** powered by **Robot Framework** and **SeleniumLibrary**.

This test suite validates key functionalities of the [AliExpress](https://www.aliexpress.com/) homepage and product workflows including search, filter, cart operations, login, language settings, and more.

---

## 🔧 Tech Stack

- ✅ **Robot Framework**
- ✅ **SeleniumLibrary**
- ✅ **Python 3.10+**
- ✅ **ChromeDriver / WebDriver Manager**

---

## 🚀 How to Run

```bash
cd AliExpress-TestSuite
robot TestSuite.robot

💡 Ensure Chrome and ChromeDriver are properly installed or use WebDriver Manager to auto-download drivers.

🧪 Test Scenarios
🟢 Scenario 1: Product Search Functionality
Given the user is on the homepage

When the user searches for "smart watch"

And clicks the search button

Then relevant product results should appear

🟡 Scenario 2: Filter by Category
Search for a product (e.g., "smart watch")

Click search

Apply a filter (e.g., price range 580 - 1249)

Results should update to reflect the applied filter

Filter section should visually reflect the selection

🛒 Scenario 3: Add Item to Cart
Search for a product

Click on a product from the results

Click "Add to Cart" on the product page

Cart icon should reflect item addition

Navigate to cart page and confirm the item is listed

🌐 Scenario 4: Change Website Language
Open language settings

Select a different language (e.g., Arabic)

Verify the UI reflects the selected language

🔐 Scenario 5: User Login
Click "Sign In" on homepage

Enter valid credentials

Submit login

Should redirect to user dashboard

Welcome message or user-specific info should be visible

💰 Scenario 6: Change Currency
Open currency selector in top bar

Choose different currency (e.g., USD)

Product prices should update across site

✨ Bonus: Scenario 7 - Product Image Zoom
On a product page

Hover over or click the product image

Image should zoom or open in lightbox/zoom view

✈️ Bonus: Scenario 8 - Change Shipping Destination
Open shipping location selector (top bar)

Select different country (e.g., UAE instead of Egypt)

Shipping details and prices should reflect new country
