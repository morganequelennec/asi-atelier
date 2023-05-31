# Use the official PostgreSQL 14 base image for Windows
FROM postgres:14.0

# Set the environment variables
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD login123

# Create the four databases and grant access to the user
ENV POSTGRES_DB CardGameCard
ENV POSTGRES_DB_2 CardGameGame
ENV POSTGRES_DB_3 CardGameTransaction
ENV POSTGRES_DB_4 CardGameUser

# Copy the SQL initialization scripts to the Docker image
COPY init.sql /docker-entrypoint-initdb.d/

# Expose the PostgreSQL port
EXPOSE 5432