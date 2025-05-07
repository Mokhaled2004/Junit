# 🛒 FakeStoreAPI - Postman Collection

This Postman collection is designed for comprehensive testing of the [Fake Store API](https://fakestoreapi.com/). It includes user, product, cart, and authentication endpoints along with negative test cases to validate error handling.



## 📁 Collection Contents

########## 👤 Users ##########
### Create User
- Expected:       200 OK, response has user ID
- Actual:         200 OK, incorrect user ID returned

### Get All Users
- Expected:       200 OK, array of users
- Actual:         200 OK, non-empty array returned

### NT1 For Create User (invalid username type)
- Expected:       400 Bad Request
- Actual:         200 OK 

### NT2 For Create User (missing fields)
- Expected:       400 Bad Request
- Actual:         200 OK

### NT1 For Get All Users (wrong path `/userss`)
- Expected:       404 Not Found
- Actual:         404 Not Found


########## 🔐 Authentication ##########
### Login User
- Expected:       200 OK, token returned
- Actual:         200 OK with token

### NT1 For Login User (missing password)
- Expected:       400 Bad Request
- Actual:         400 Bad Request

### NT2 For Login User (wrong password)
- Expected:       401 Unauthorized
- Actual:         401 Unauthorized


########## 🛍️ Products ##########
### Get All Products
- Expected:       200 OK, array of products
- Actual:         200 OK, non-empty array returned

### Get Product by ID
- Expected:       200 OK, title field exists
- Actual:         200 OK, product details returned

### NT1 For Get All Products (`/Products`)
- Expected:       404 Not Found
- Actual:         200 OK

### NT1 For Get Product by ID (-5)
- Expected:       400 Bad Request
- Actual:         200 OK


########## 🛒 Carts ##########
### Create Cart
- Expected:       201 Created, cart with ID
- Actual:         200 OK, cart details returned

### Get a Single Cart by ID
- Expected:       200 OK, user id and products exists
- Actual:         200 OK, cart details

### Delete a Cart
- Expected:       200 OK
- Actual:         200 OK, cart details

### Get All Carts
- Expected:       200 OK, list of carts
- Actual:         200 OK, non-empty array returned

### NT1 For Create Cart (missing products)
- Expected:       400 Bad Request
- Actual:         200 OK

### NT2 For Create Cart (empty body)
- Expected:       400 Bad Request
- Actual:         200 OK

### NT1 For Create Cart (invalid userid type)
- Expected:       400 Bad Request
- Actual:         200 OK

### NT1 For Get a Single Cart by ID (`abc`)
- Expected:       400 Bad Request
- Actual:         400 Bad Request

### NT1 For Get a Single Cart by ID (-2)
- Expected:       400 Bad Request
- Actual:         200 OK

### NT1 For Delete a Cart (no ID)
- Expected:       404 Not Found
- Actual:         404 Not Found

### NT1 For Delete a Cart (-3)
- Expected:       400 Bad Request
- Actual:         200 OK

### NT1 For Get All Carts (`/CARTS`)
- Expected:       404 Not Found
- Actual:         200 OK



## 🚀 Getting Started

### Prerequisites
- [Postman](https://www.postman.com/downloads/)
- Internet access

### How to Use
1. Open Postman.
2. Click **Import** > **File** and upload `fakeStoreAPI.postman_collection.json`.
3. Click **Import** and start running requests.



## 🧪 Example Tests

**Create User** tests:
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has user ID", function () {
    let jsonData = pm.response.json();
    pm.expect(jsonData.id).to.exist;
});


**Negative Test for Create Cart (Missing Products):**
```javascript
pm.test("Status code is 400 for missing required field", function () {
    pm.response.to.have.status(400);
});



## 🔗 API Base URL

https://fakestoreapi.com/



## 🔄 Collection Link

Access it directly via Postman:  
[FakeStoreAPI Collection](https://lrmo55.postman.co/workspace/LRMO-Workspace~ff2da1bd-c25c-40fc-8a49-5bc922ff75d5/collection/40499382-307270b7-c3c1-4a28-8a29-40e7a40a25aa?action=share&source=collection_link&creator=40499382)

