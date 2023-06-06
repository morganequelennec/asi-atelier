-- Create the CardGameGame database
CREATE DATABASE CardGameGame;

-- Connect to the CardGameCard database
\c CardGameGame

-- Create the cardschem schema
CREATE SCHEMA cardschem;

-- Grant access to the user
GRANT ALL PRIVILEGES ON DATABASE CardGameGame TO postgres;
GRANT ALL PRIVILEGES ON SCHEMA cardschem TO postgres;