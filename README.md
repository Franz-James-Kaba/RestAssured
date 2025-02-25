# 🛠️ REST Assured API Testing with Reqres

Welcome to the **REST Assured API Testing** repository! 🚀 Here, we use [Reqres](https://reqres.in/) as our mock API to perform automated testing of CRUD (Create, Read, Update, Delete) operations using **REST Assured** in Java.

## 📌 Technologies Used
- **Java** (Junit/TestNG for testing)
- **REST Assured** (for API automation)
- **Maven** (for dependency management)
- **Reqres API** (mock API for testing)

---

## 📦 Setup Instructions

### 🔧 Prerequisites
Ensure you have the following installed:
- [Java (JDK 8+)](https://www.oracle.com/java/technologies/javase-downloads.html) ☕
- [Maven](https://maven.apache.org/install.html) 📦
- [An IDE like IntelliJ or Eclipse](https://www.jetbrains.com/idea/download/) 🖥️

### 📥 Clone the Repository
```sh
 git clone https://github.com/yourusername/rest-assured-tests.git
 cd rest-assured-tests
```

### 🏗️ Install Dependencies
Run the following command to install all required dependencies:
```sh
mvn clean install
```

---

## 🚀 Running Tests
Run the test cases using the Maven command:
```sh
mvn test
```

---

## 🌐 API Endpoints Tested
We are using [Reqres](https://reqres.in/) as the API for testing the following CRUD operations:

### ✅ **Create User (POST)**
```java
@Test
public void testCreateUser() {
    given().
            contentType(ContentType.JSON).
            body("{\"name\":\"John Doe\", \"job\":\"QA Engineer\"}").
    when().
            post("https://reqres.in/api/users").
    then().
            statusCode(201).
            body("name", equalTo("John Doe"));
}
```

### 📥 **Get User (GET)**
```java
@Test
public void testGetUser() {
    when().
            get("https://reqres.in/api/users/2").
    then().
            statusCode(200).
            body("data.id", equalTo(2)).
            body("data.email", equalTo("janet.weaver@reqres.in"));
}
```

### ✏️ **Update User (PUT)**
```java
@Test
public void testUpdateUser() {
    given().
            contentType(ContentType.JSON).
            body("{\"name\":\"John Doe\", \"job\":\"Senior QA Engineer\"}").
    when().
            put("https://reqres.in/api/users/2").
    then().
            statusCode(200).
            body("job", equalTo("Senior QA Engineer"));
}
```

### ❌ **Delete User (DELETE)**
```java
@Test
public void testDeleteUser() {
    when().
            delete("https://reqres.in/api/users/2").
    then().
            statusCode(204); // No content response
}
```

---

## 🏆 Why Use Reqres?
✔️ Free, public API for testing
✔️ Supports CRUD operations
✔️ Provides realistic responses
✔️ Ideal for testing **REST Assured** automation

---

## 📜 License
This project is open-source and available under the **MIT License**.

