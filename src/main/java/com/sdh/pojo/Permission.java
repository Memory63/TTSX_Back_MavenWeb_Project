package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName t_premission
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/28 15:46
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private Integer id;
    private String permissionName;
    private Date createTime;
}
