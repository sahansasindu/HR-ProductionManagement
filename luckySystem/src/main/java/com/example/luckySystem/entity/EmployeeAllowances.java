package com.example.luckySystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Component

@Entity(name="employeeallowances")
public class EmployeeAllowances {

    @Id
    @Column(name="employee_allowances_id",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long EmployeeAllowancesID;

    @ManyToOne
    @JoinColumn(name = "emp_id",referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "alow_id",referencedColumnName = "allowances_id")
    private Allowances allowances;

    @Column(name="allowances_type",length = 50,nullable = false)
    private String allowances_type;

    @Column(name="allowances_amount",nullable = false)
    private double allowances_amount;
}
