# SEMESTER4-SDAT-QAP2-GOLF-CLUB-MANAGEMENT
QAP2 IN SDAT TO CREATE AND MANAGE GOLF-CLUB-MANGEMENT API AND README FILE WHICH EXPLAINS HOW TO CLONE THIS API INTO DOCKER
# Golf Club Tournament API

This project is a REST API for managing golf club members and tournaments. It is built with Node.js, Express, and MySQL, and runs inside Docker containers for easy deployment.

## GitHub Repository
You can find the project repository here:
[GitHub: Golf Club Tournament API](SEMESTER4-SDAT-QAP2--GOLF-CLUB-MANAGEMENT)

## Features
- Add, update, and delete members.
- Add, update, and delete tournaments.
- Search for members and tournaments using various criteria.
- Associate members with tournaments.

## Supported Search APIs
1. **Search Members**:
   - By Name: `GET /members?name=<name>`
   - By Membership Type: `GET /members?membershipType=<type>`
   - By Phone Number: `GET /members?phoneNumber=<number>`
   - By Membership Start Date: `GET /members?startDate=<start_date>`

2. **Search Tournaments**:
   - By Start Date: `GET /tournaments?startDate=<start_date>`
   - By Location: `GET /tournaments?location=<location>`
   - Find All Members in a Tournament: `GET /tournaments/<tournament_id>/members`

## Running the Project in Docker

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   cd your-repo-name
