package com.skills.validations;

import com.skills.entity.Student;
import com.skills.exceptions.InvalidDataException;

public class StudentValidation {
    public static void validate(Student s) throws InvalidDataException {
        if (s.getId() <= 0)
            throw new InvalidDataException("Invalid ID");
        if (s.getName().isEmpty())
            throw new InvalidDataException("Name required");
        if (s.getMarks() < 0 || s.getMarks() > 100)
            throw new InvalidDataException("Marks 0-100 only");
    }
}