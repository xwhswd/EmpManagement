package com.iweb.arui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long id;
    private String empName;
    private String identityCard;
    private String phoneNumber;
    private String sex;
    private Post post;
    private Department department;
}
