package com.dhu.staffmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Technology implements Serializable {
    private int baseId;
    private int salary;
    private String position;
    private Base base;
}
