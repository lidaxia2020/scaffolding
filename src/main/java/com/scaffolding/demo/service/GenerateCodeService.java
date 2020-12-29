package com.scaffolding.demo.service;

import com.scaffolding.demo.dto.GenerateCodeDto;
import com.scaffolding.demo.result.RestResult;


/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 14:22
 */
public interface GenerateCodeService {

    RestResult generateCode(GenerateCodeDto generateCodeDto, String realPath);

}
