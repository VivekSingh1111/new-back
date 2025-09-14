package org.codingwallah.emproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
        private Long id;
        private String name;
        private String phone;
        private String email;
}
