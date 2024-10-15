package com.ohgiraffers.section01.model.dto;

public class DepartmentDTO {

    private String deptCode;
    private String deptTitle;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String deptCode, String deptTitle) {
        this.deptCode = deptCode;
        this.deptTitle = deptTitle;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptTitle() {
        return deptTitle;
    }

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptTitle='" + deptTitle + '\'' +
                '}';
    }
}
