# 🍎 Fruits API — Java

A simple Java project that demonstrates how to consume a public REST API and work with external data.

This project uses the **Fruityvice API**, a web service that provides information about different types of fruits. You can query the API to retrieve interesting data about a fruit of your choice.

## 🌐 Fruityvice API

The [Fruityvice API](https://www.fruityvice.com/) provides fruit-related information such as:

* 🍎 Fruit name
* 🧬 Scientific name
* 🌱 Family
* 🌿 Genus
* 📊 Nutritional information
* 🔢 Sugar, protein, carbohydrates, and other nutritional values

## 🎯 Purpose

The project demonstrates how Java applications can:

* Consume a REST API
* Send HTTP requests
* Retrieve JSON data
* Parse API responses
* Work with external web services
* Display structured API data

## 🛠️ Technologies

* **Java**
* **REST API**
* **Fruityvice API**
* **JSON**
* **HTTP Requests**

## 🚀 Getting Started

### Prerequisites

Make sure you have Java installed on your system.

Check your Java installation:

```bash
java -version
```

### Clone the Repository

```bash
git clone https://github.com/malcommathela/Fruits_API-Java.git
cd Fruits_API-Java
```

### Run the Project

Compile and run the Java application according to the project's source structure.

```bash
javac *.java
java Main
```

> The exact command may vary depending on the project's Java package and entry-point structure.

## 🔄 How It Works

The application follows a simple flow:

```text
User
 │
 ▼
Java Application
 │
 │ HTTP Request
 ▼
Fruityvice API
 │
 │ JSON Response
 ▼
Java Application
 │
 ▼
Fruit Information
```

For example, the application can request information about a specific fruit and process the JSON response returned by the API.

## 📌 Example

A fruit request can return information similar to:

```json
{
  "name": "Banana",
  "family": "Musaceae",
  "genus": "Musa",
  "nutritions": {
    "calories": 96,
    "fat": 0.2,
    "sugar": 17.2,
    "carbohydrates": 22,
    "protein": 1.0
  }
}
```

The Java application can then extract and display the required fields.

## 📚 What I Learned

This project provides practical experience with:

* RESTful APIs
* HTTP communication
* JSON data handling
* Java API integration
* External service consumption
* Working with structured data from web services

## 🔮 Possible Improvements

Future improvements could include:

* [ ] Add a graphical user interface
* [ ] Allow users to search for fruits interactively
* [ ] Display nutritional information in a formatted table
* [ ] Add error handling for unavailable fruits
* [ ] Add API response caching
* [ ] Add unit tests
* [ ] Build a Spring Boot REST application around the API

## 📄 License

This project is available under the MIT License.

---

**Built with Java ☕ and the Fruityvice API 🍎**
