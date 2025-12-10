package org.reeves;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.reeves.util.Util;

@EqualsAndHashCode
@Getter
@ToString
public class Department {
    private String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName.trim());
            this.departmentId = String.format("D%02d", nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    /**
     * checks if a department name is valid or not (should only contain letters or space)
     * @param departmentName department nam to be verified
     * @return whether the department name is valid
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()){
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
}
