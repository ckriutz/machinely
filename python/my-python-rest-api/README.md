# my-python-rest-api/README.md

# Employee REST API

This project is a simple REST API for managing employee records using Flask and PostgreSQL. It allows you to create, retrieve, and search for employees using a stored procedure.

## Project Structure

```
my-python-rest-api
├── src
│   ├── app.py            # Entry point of the application
│   ├── models.py         # Defines the Employee model
│   ├── routes.py         # API endpoints for employee management
│   └── templates
│       └── index.html    # Simple HTML page for testing the API
├── requirements.txt       # Project dependencies
└── README.md              # Project documentation
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd my-python-rest-api
   ```

2. **Create a virtual environment:**
   ```
   python -m venv venv
   source venv/bin/activate  # On Windows use `venv\Scripts\activate`
   ```

3. **Install dependencies:**
   ```
   pip install -r requirements.txt
   ```

4. **Set up the PostgreSQL database:**
   Ensure that your PostgreSQL database is running and the `employee` table is created according to the provided schema.

5. **Run the application:**
   ```
   python src/app.py
   ```

6. **Access the API:**
   Open your browser and navigate to `http://localhost:5000` to access the simple web interface for testing the API endpoints.

## API Endpoints

- **Create Employee**
  - `POST /employees`
  - Request Body: `{ "name": "John Doe", "position": "Developer", "start_date": "2023-01-01", "end_date": null }`

- **Retrieve Employees**
  - `GET /employees`
  
- **Search Employees by Name**
  - `GET /employees/search?name=<wildcard_name>`

## Usage Examples

- To create a new employee, fill out the form on the web page and submit.
- To retrieve all employees, navigate to the appropriate endpoint in your browser or use a tool like Postman.

## License

This project is licensed under the MIT License.