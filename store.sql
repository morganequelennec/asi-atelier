-- Create the CardGameTransaction database
CREATE DATABASE CardGameTransaction;

-- Connect to the CardGameCard database
\c CardGameTransaction

-- Create the cardschem schema
CREATE SCHEMA cardschem;

-- Grant access to the user
GRANT ALL PRIVILEGES ON DATABASE CardGameTransaction TO postgres;
GRANT ALL PRIVILEGES ON SCHEMA cardschem TO postgres;