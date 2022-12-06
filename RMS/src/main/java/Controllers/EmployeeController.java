package Controllers;

import Models.User;
import Services.EmployeeService;
import Services.RegistrationService;


public class EmployeeController
{
    private static EmployeeService employeeService;

    public static void removeEmployee(int index)
    {
        EmployeeService.removeEmployee(index);
    }
    public EmployeeController()
    {
        employeeService = new EmployeeService();
    }


    public static boolean addEmployee(User employee)
    {
        return employeeService.addEmployeeInfo(employee);
    }
}
