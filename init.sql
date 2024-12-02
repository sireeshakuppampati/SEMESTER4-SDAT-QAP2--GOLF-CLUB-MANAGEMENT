-- Create the golf_club database if it doesn't exist
CREATE DATABASE IF NOT EXISTS golf_club;

-- Use the golf_club database
USE golf_club;

-- Create a new user 'golf_user' with a password (change as necessary)
CREATE USER IF NOT EXISTS 'golf_user'@'%' IDENTIFIED BY 'golf_user_password';

-- Grant all privileges on the golf_club database to the 'golf_user'
GRANT ALL PRIVILEGES ON golf_club.* TO 'golf_user'@'%';

-- Flush privileges to ensure the new permissions take effect
FLUSH PRIVILEGES;

-- Create the members table
CREATE TABLE IF NOT EXISTS members (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
                                       email VARCHAR(100) NOT NULL UNIQUE,
                                       membership_start_date DATE NOT NULL
);

-- Optional: You can add sample data if needed
INSERT INTO members (name, email, membership_start_date)
VALUES
    ('John Doe', 'john@example.com', '2024-01-01'),
    ('Jane Smith', 'jane@example.com', '2024-02-15');
