INSERT INTO patient(name , gender , dob , email , blood_group)
VALUES
    ('Aarav Sharma', 'MALE', '1990-05-10','aarav.sharma@example.com', 'O_POSITIVE'),
    ('Dika Patel', 'FEMALE','1995-08-20','diya.patel@example.com', 'A_POSITIVE'),
    ('Dishant Verma', 'MALE', '1988-03-15', 'dishant.verma@example.com', 'A_POSITIVE'),
    ('Neha Iver', 'FEMALE', '1992-12-01','neha.iyer@example.com', 'AB_POSITIVE'),
    ('Kabir Singh', 'MALE', '1993-07-11', 'kabir.singh@example.com', 'O_POSITIVE');

INSERT INTO doctor (name, specialization, email, gender, pno, qualification)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com', 'Male', '9876543210', 'MBBS'),
    ('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com', 'Female', '9876543211', 'MBBS'),
    ('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com', 'Male', '9876543212', 'MBBS');


INSERT INTO
    appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
    ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
    ('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
    ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
    ('2025-07-05 16:15:00', 'Consultation', 1, 4),
    ('2025-07-06 08:30:00','Allergy Treatment', 2, 5);


INSERT INTO
    insurance (company_name, policy_number, valid_till, patient_id)
VALUES
    ('LIC India', 'LIC-001-2024', '2027-12-31', 1),
    ('Star Health', 'STAR-002-2024', '2026-06-30', 2),
    ('HDFC Ergo', 'HDFC-003-2024', '2028-03-15', 3),
    ('Bajaj Allianz', 'BAJAJ-004-2024', '2027-08-20', 4),
    ('New India', 'NIA-005-2024', '2026-11-10', 5);


INSERT INTO
    department (dept_name)
VALUES
    ('Cardiology'),
    ('Dermatology'),
    ('Orthopedics'),
    ('General Medicine'),
    ('Emergency');

INSERT INTO
    doctor_id (departments_id, doctor_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 1),
    (4, 2),
    (5, 3);
