package com.skills.validations;

import com.skills.entity.Employee;
import com.skills.exceptions.InvalidDataException;

public class EmployeeValidation {
    public static void validate(Employee e) throws InvalidDataException {
        if (e.getId() <= 0)
            throw new InvalidDataException("Invalid ID");
        if (e.getName().isEmpty())
            throw new InvalidDataException("Name required");
    }
}