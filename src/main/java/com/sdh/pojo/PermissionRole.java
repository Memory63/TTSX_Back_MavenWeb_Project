package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PermissionRole
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/28 15:49
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRole {
    private Integer id;
    private Integer pid;
    private Integer rid;
}
