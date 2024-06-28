
package com.example.luckySystem.controller.employee;

import com.example.luckySystem.dto.agent.AgentDTO;
import com.example.luckySystem.dto.employee.EmployeeBirthdayDTO;
import com.example.luckySystem.dto.employee.EmployeeDTO;
import com.example.luckySystem.dto.employee.UpcommingBirthdayDTO;
import com.example.luckySystem.dto.salary.LeaveDto;
import com.example.luckySystem.dto.salary.MedicalDto;
import com.example.luckySystem.dto.user.UserDto;
import com.example.luckySystem.entity.Employee;
import com.example.luckySystem.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hrandproduction")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getEmployee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeDetails() {
        System.out.println("Received request to get all employees.");
        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployee();
        return ResponseEntity.ok().body(employeeDTOS);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestPart("employee") EmployeeDTO employeeDto,
                                                @RequestPart("cv") MultipartFile cv) throws IOException {
        Employee employee = employeeService.addEmployee(employeeDto, cv);
        return ResponseEntity.ok(employee);
    }



    @GetMapping("/employeeCountByDepartment")
    public List<Object[]> getEmployeeCountByDepartment() {
        return employeeService.countActiveEmployeesByDepartment();
    }

    @GetMapping("/totalCount")
    public int getTotalEmployeeCount() {
        return employeeService.getTotalEmployeesCount();
    }


    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDTO employeeDto) {
        System.out.println("Received request to add an employee with ID: " + employeeDto.getEmployeeid());
        Employee employee=employeeService.updateEmployeeDetails(employeeDto);
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/deleteEmployee")
    public boolean deleteEmployee(@RequestBody EmployeeDTO employeeDto) {
        return employeeService.deleteEmployee(employeeDto);
    }

    @GetMapping("/getEmployeeByID/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable String employeeID){
        return employeeService.getEmployeeByEmployeeID(employeeID);
    }

    @GetMapping("/getMedicalData")
    public ResponseEntity<List<MedicalDto>> getMedicalData() {
        List<MedicalDto> agent = employeeService.getMedicalData();
        return ResponseEntity.ok().body(agent);
    }
    @GetMapping("/getLeaveData")
    public ResponseEntity<List<LeaveDto>> getLeaveData() {
        List<LeaveDto> agent=employeeService.getLeaveData();
        return ResponseEntity.ok().body(agent);
    }


    @GetMapping("/todayBirthdays")
    public List<EmployeeBirthdayDTO> getEmployeesWithBirthdaysToday() {
        return employeeService.getEmployeesWithBirthdaysToday();
    }

    @GetMapping("/upcomingBirthdays")
    public List<UpcommingBirthdayDTO> getUpcomingBirthdays() {
        return employeeService.getUpcomingBirthdays();
    }

}
