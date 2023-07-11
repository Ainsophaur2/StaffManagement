package com.dhu.staffmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class IndexInfo {
    private int PersonnelNumber;
    private int FinanceNumber;
    private int AdministrationNumber;
    private int TechnologyNumber;
    private int MaleNums;
    private int FemaleNums;
    private List AgeLevel;

}
