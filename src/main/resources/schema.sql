CREATE TABLE discipline (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            title VARCHAR(255) NOT NULL
);

CREATE TABLE student (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE enrollment (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            student_id BIGINT NOT NULL,
                            discipline_id BIGINT NOT NULL,
                            FOREIGN KEY (student_id) REFERENCES student(id),
                            FOREIGN KEY (discipline_id) REFERENCES discipline(id)
);
