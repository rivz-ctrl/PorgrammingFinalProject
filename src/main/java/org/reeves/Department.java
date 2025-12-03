package org.reeves;

public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId;

    /**
     * checks if a department name is valid or not (should only contain letters or space)
     * @param departmentName department nam to be verified
     * @return whether the department name is valid
     */
    static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()){
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
