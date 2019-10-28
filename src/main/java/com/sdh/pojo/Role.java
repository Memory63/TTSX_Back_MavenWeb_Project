package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName t_role
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/28 15:44
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String roleName;
    private Date createTime;
}
