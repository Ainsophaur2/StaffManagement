package com.dhu.staffmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Finance implements Serializable {
    private int baseId;
    private int salary;
    private String position;
    private Base base;
}
