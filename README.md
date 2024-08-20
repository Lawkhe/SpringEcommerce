# **Ecommerce Spring Boot** 
Se realiza el Backend con autentificación basado en JWT, enfocado a un ecommerce.

## Requisitos

* JDK 17
* MySQL DataBase

# EndPoints API

### **`auth`**
* GET /auth
* POST /register

### **`user`**
* GET /api/users
* GET /api/users/{id}
* POST /api/users
* PUT /api/users/{id}
* DELETE /api/users/{id}

### **`category`**
* GET /api/categories
* GET /api/categories/{id}
* POST /api/categories
* PUT /api/categories/{id}
* DELETE /api/categories/{id}

### **`product`**
* GET /api/products
* GET /api/products/{id}
* POST /api/products
* PUT /api/products/{id}
* DELETE /api/products/{id}

### **`discount`**
* GET /api/discounts
* GET /api/discounts/{id}
* POST /api/discounts
* PUT /api/discounts/{id}
* DELETE /api/discounts/{id}

### **`buy`**
* GET /api/buys
* GET /api/buys/{id}
* GET /api/buys/user/{userId}
* POST /api/buys

### **`audit`**
* GET /api/audits
* POST /api/audits

### **`dashboard`**
* GET /api/dashboard/active-products
* GET /api/dashboard/product-counts
* GET /api/dashboard/top-selling-products
* GET /api/dashboard/top-frequent-users