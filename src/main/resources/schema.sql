CREATE TABLE questions (
    question_id INT NOT NULL,
    question VARCHAR(250) NOT NULL,
    option_a VARCHAR(250) NOT NULL,
    option_b VARCHAR(250) NOT NULL,
    option_c VARCHAR(250) NOT NULL,
    option_d VARCHAR(250) NOT NULL,
    option_e VARCHAR(250),
    correct_answer VARCHAR(10) NOT NULL
);