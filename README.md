# SEMESTER4-SDAT-QAP2-GOLF-CLUB-MANAGEMENT
QAP2 IN SDAT TO CREATE AND MANAGE GOLF-CLUB-MANGEMENT API AND README FILE WHICH EXPLAINS HOW TO CLONE THIS API INTO DOCKER
# GOLF-CLUB MANAGEMENT

This project is a Java-based application for managing a golf club's members and tournaments. It provides a REST API for CRUD operations on members and tournaments, as well as the ability to assign members to tournaments. The application uses MySQL for database management and is containerized with Docker.

## Features

- Manage golf club members:
    - Add, view, update, and delete members.
- Manage tournaments:
    - Add, view, update, and delete tournaments.
- Assign members to tournaments.
- Use Docker for easy deployment.

## Technologies Used

- **Java** (Spring Boot)
- **MySQL** (Database)
- **Hibernate** (ORM)
- **Docker** (Containerization)
- **Postman** (API Testing)

## Getting Started

### Prerequisites

- Install **Docker** and **Docker Compose**.
- Install **Maven**.

### Clone the Repository

```bash
git clone https://github.com/yourusername/golf-club-management.git
cd golf-club-management
```

### Build the Project

Run the following command to build the JAR file:

```bash
mvn clean package
```

### Start the Application with Docker

1. Build and start the containers:
   ```bash
   docker-compose up --build
   ```
2. Verify that the containers are running:
   ```bash
   docker ps
   ```
   You should see two containers:
    - `golf_club_app` (Application container)
    - `golf_club_db` (MySQL database container)

### Access the Application

- Base URL: `http://localhost:8080`
- API Endpoints:
    - **Tournaments**: `/api/tournaments`
    - **Members**: `/api/members`

## Database Initialization

The database is initialized with default schemas and tables upon container startup. Use the `init.sql` file to prepopulate the database with records if needed. To apply the script manually:

1. Log into the database container:
   ```bash
   docker exec -it golf_club_db mysql -u root -p
   ```
2. Apply the script:
   ```sql
   USE golf_club;
   SOURCE /path/to/init.sql;
   ```

## Testing the API

### Using Postman

- Import the API endpoints into Postman.
- Test endpoints:
    - **Get all tournaments**:
      ```
      GET http://localhost:8080/api/tournaments
      ```
    - **Add a tournament**:
      ```
      POST http://localhost:8080/api/tournaments
      Body (JSON):
      {
        "startDate": "2024-06-01",
        "endDate": "2024-06-03",
        "location": "Augusta National Golf Club",
        "entryFee": 100.0,
        "cashPrize": 5000.0
      }
      ```
    - **Assign a member to a tournament**:
      ```
      POST http://localhost:8080/api/tournaments/{tournamentId}/add-member/{memberId}
      ```

### Database Verification

Verify the records in the database by logging into the MySQL container:

```bash
docker exec -it golf_club_db mysql -u root -p
USE golf_club;
SELECT * FROM members;
SELECT * FROM tournaments;
```

## Troubleshooting

### Common Issues

1. **404 Not Found for Endpoints**:

    - Ensure controllers are properly annotated with `@RestController` and `@RequestMapping`.
    - Verify the base URL in the browser or Postman.

2. **Database Not Initialized**:

    - Check if `init.sql` was executed during startup.
    - Reinitialize the database by removing the volume:
      ```bash
      docker-compose down
      docker volume rm golf-clubmanagement_db_data
      docker-compose up --build
      ```

3. **Port Conflicts**:

    - Ensure no other services are running on ports `8080` or `3306`.
    - Modify the `docker-compose.yml` file to use different ports if needed.

## License

This project is licensed under the MIT License.

---

For further assistance, please contact SIREESHA KUPPAMPATI.

