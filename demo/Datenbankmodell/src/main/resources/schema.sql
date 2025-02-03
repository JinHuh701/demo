-- Table for Users
CREATE TABLE users (
    id SERIAL PRIMARY KEY, -- Unique ID for each user
    username VARCHAR(50) UNIQUE NOT NULL, -- Username (unique)
    email VARCHAR(100) UNIQUE NOT NULL, -- Email (unique)
    password_hash VARCHAR(255) NOT NULL, -- Hashed password for security
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the user was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Timestamp when the user was last updated
);

-- Table for Posts
CREATE TABLE posts (
    id SERIAL PRIMARY KEY, -- Unique ID for each post
    user_id INT NOT NULL, -- ID of the user who created the post
    content TEXT NOT NULL, -- Content of the post
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the post was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the post was last updated
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- Link to the user who created the post
);

-- Table for Likes
CREATE TABLE likes (
    id SERIAL PRIMARY KEY, -- Unique ID for each like
    user_id INT NOT NULL, -- ID of the user who liked the post
    post_id INT NOT NULL, -- ID of the post that was liked
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the like was created
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE, -- Link to the user who liked the post
    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE, -- Link to the post that was liked
    UNIQUE(user_id, post_id) -- Ensure a user can like a post only once
);

-- Table for Comments
CREATE TABLE comments (
    id SERIAL PRIMARY KEY, -- Unique ID for each comment
    user_id INT NOT NULL, -- ID of the user who wrote the comment
    post_id INT NOT NULL, -- ID of the post the comment belongs to
    content TEXT NOT NULL, -- Content of the comment
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the comment was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the comment was last updated
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE, -- Link to the user who wrote the comment
    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE -- Link to the post the comment belongs to
);

-- Table for Notifications
CREATE TABLE notifications (
    id SERIAL PRIMARY KEY, -- Unique ID for each notification
    user_id INT NOT NULL, -- ID of the user who receives the notification
    type VARCHAR(50) NOT NULL, -- Type of notification (e.g., 'new_like', 'new_comment')
    content TEXT NOT NULL, -- Content of the notification
    is_read BOOLEAN DEFAULT FALSE, -- Whether the notification has been read
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp when the notification was created
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- Link to the user who receives the notification
);