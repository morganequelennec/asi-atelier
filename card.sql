-- Create the CardGameCard database
CREATE DATABASE CardGameCard;

-- Connect to the CardGameCard database
\c CardGameCard

-- Create the cardschem schema
CREATE SCHEMA cardschem;

-- Grant access to the user
GRANT ALL PRIVILEGES ON DATABASE CardGameCard TO postgres;
GRANT ALL PRIVILEGES ON SCHEMA cardschem TO postgres;