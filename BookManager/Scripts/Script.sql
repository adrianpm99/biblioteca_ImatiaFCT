CREATE TABLE lending (
    lendingId INTEGER PRIMARY KEY AUTOINCREMENT,
    userId INT NOT NULL REFERENCES user(userId),
    lendingDate DATE NOT NULL,
    lendingDeadLine DATE NOT NULL,
    lendingReturnDate DATE
);
