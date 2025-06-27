CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    is_issued BOOLEAN DEFAULT FALSE
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE issued_books (
    book_id INT REFERENCES books(book_id),
    user_id INT REFERENCES users(user_id),
    issue_date DATE,
    return_date DATE,
    PRIMARY KEY (book_id, user_id, issue_date)
);