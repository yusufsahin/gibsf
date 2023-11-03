package com.example.sf400contactmanager.controller;

import com.example.sf400contactmanager.service.impl.ContactServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("/contacts")
    @ResponseBody
    public String getContacts()
    {
        return  contactService.getContactsAsString();
    }
}
