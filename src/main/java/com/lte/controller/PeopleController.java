package com.lte.controller;

import com.lte.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: laite
 * @Date: 2022/3/19 - 03 - 19 - 16:21
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
// @EnableConfigurationProperties(PeopleProperties.class)
public class PeopleController {

    // @Autowired
    // PeopleProperties peopleProperties;

    @Autowired
    People people;
    @RequestMapping("/getPeople")
    public People getPeople(){

        return people;
    }
}
