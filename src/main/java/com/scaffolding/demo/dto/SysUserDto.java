package com.scaffolding.demo.dto;

import com.scaffolding.demo.result.PageParam;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 22:53
 */
@Data
public class SysUserDto extends PageParam {

    private String username;

    private String startTime;

    private String endTime;
}
