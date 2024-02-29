package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContr {

    @Autowired
    private SelectUser selectUser;

    @RequestMapping(value = "/{uuid}")
    public User helloSpringBoot(@PathVariable String uuid){
        return selectUser.getUserByUuid(uuid);
    }

}
