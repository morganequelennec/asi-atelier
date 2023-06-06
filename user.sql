-- Create the CardGameUser database
CREATE DATABASE CardGameUser;

-- Connect to the CardGameCard database
\c CardGameUser

-- Create the cardschem schema
CREATE SCHEMA cardschem;

-- Grant access to the user
GRANT ALL PRIVILEGES ON DATABASE CardGameUser TO postgres;
GRANT ALL PRIVILEGES ON SCHEMA cardschem TO postgres;