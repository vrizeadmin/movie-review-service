-- Create the user table
CREATE TABLE users (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       CONSTRAINT username_unique UNIQUE (username)
);

-- Create the token table
CREATE TABLE token (
                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        token VARCHAR(255) NOT NULL,
                        token_type VARCHAR(50) NOT NULL,
                        revoked BOOLEAN NOT NULL DEFAULT false,
                        expired BOOLEAN NOT NULL DEFAULT false,
                        user_id UUID REFERENCES users(id) ON DELETE CASCADE
);