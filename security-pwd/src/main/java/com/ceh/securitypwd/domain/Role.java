package com.ceh.securitypwd.domain;

import com.ceh.securitypwd.annotation.Table;
import lombok.Data;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@Table(name = "role")
@Data
public class Role {
    private Long id;
    private String roleName;
}
