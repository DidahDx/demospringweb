#Demo SpringBoot

## Setup Postgres
- install postgres `sudo docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine`
- `sudo docker exec -it <container_id_replace_here> bin/bash`
- `psql -U postgres`
- `CREATE DATABASE demodb;`
- Connect to database `\c demodb`

## Setup Flyway
- used for database migration
- create directory under resources db/migration/V1__TableName.sql