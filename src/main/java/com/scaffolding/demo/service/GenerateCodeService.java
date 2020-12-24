package com.scaffolding.demo.service;

import com.scaffolding.demo.dto.GenerateCodeDto;


/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 14:22
 */
public interface GenerateCodeService {

    void generateCode(GenerateCodeDto generateCodeDto, String realPath);

}
