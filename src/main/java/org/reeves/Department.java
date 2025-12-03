package org.reeves;

public class Department {
    String departmentId;
    String departmentName;
    static int nextId;

    /**
     * checks if a department name is valid or not (should only contain letters or space)
     * @param departmentName department nam to be verified
     * @return whether the department name is valid
     */
    static boolean isDepartmentNameValid(String departmentName) {
        return true;
    }
}
