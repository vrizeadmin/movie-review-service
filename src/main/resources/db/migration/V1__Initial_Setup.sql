CREATE TABLE Movie (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT,
	year_of_release INT NOT NULL,
	duration INT NOT NULL,
	director VARCHAR(255),
	cast TEXT,
	genre VARCHAR(100),
	languages TEXT,
	aggregate_review_ratings FLOAT DEFAULT 0,
	total_reviews INT DEFAULT 0,
	movie_rating VARCHAR(50)
);

CREATE TABLE User (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255) NOT NULL UNIQUE,
	user_type VARCHAR(50) DEFAULT 'Regular',
	total_reviews INT DEFAULT 0,
	status VARCHAR(50) DEFAULT 'Active'
);

CREATE TABLE Review (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT NOT NULL,
	movie_id BIGINT NOT NULL,
	review TEXT,
	rating INT,
	total_likes INT DEFAULT 0,
	total_dislikes INT DEFAULT 0,
	created_program_id INT,
	modified_program_id INT,
	created_user_id INT,
	modified_user_id INT,
	created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	modified_timestamp TIMESTAMP,
	lockid VARCHAR(255),
	FOREIGN KEY (user_id) REFERENCES User(id),
	FOREIGN KEY (movie_id) REFERENCES Movie(id)
);

CREATE TABLE Watchlist (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT NOT NULL,
	movie_id BIGINT NOT NULL,
	watched BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (user_id) REFERENCES User(id),
	FOREIGN KEY (movie_id) REFERENCES Movie(id)
);

CREATE INDEX idx_movie_genre ON Movie (genre);
CREATE INDEX idx_movie_year_of_release ON Movie (year_of_release);
CREATE INDEX idx_review_user_id ON Review (user_id);
CREATE INDEX idx_review_movie_id ON Review (movie_id);
CREATE INDEX idx_watchlist_user_id ON Watchlist (user_id);
CREATE INDEX idx_watchlist_movie_id ON Watchlist (movie_id);