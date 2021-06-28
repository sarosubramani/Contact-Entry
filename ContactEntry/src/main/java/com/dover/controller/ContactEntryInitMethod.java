package com.dover.controller;

import com.dover.datamodel.Address;
import com.dover.datamodel.ContactEntry;
import com.dover.datamodel.Name;
import com.dover.datamodel.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ContactEntryInitMethod {

    @Autowired
    private ContactEntryRepository contactEntryRepository;

    @PostConstruct
    public void loadData()
    {
        contactEntryRepository.save(new ContactEntry(101, new Name("John", "F", "Wick"), new Address("11 Floral Ave", "Dover", "NH", "03820"), new Phone("6036828771", "mobile"), "john.wick@mail.com"));
        contactEntryRepository.save(new ContactEntry(102, new Name("Harry", "W", "Potter"), new Address("5 Old English Village", "Dover", "NH", "03820"), new Phone("6036628771", "home"), "harry.potter@mail.com"));
        contactEntryRepository.save(new ContactEntry(103, new Name("Doug", "N", "George"), new Address("234 Central Ave", "Dover", "NH", "03820"), new Phone("6036828211", "mobile"), "doug.george@mail.com"));
        contactEntryRepository.save(new ContactEntry(104, new Name("Bruce", "L", "Willis"), new Address("10 Portland Ave", "Dover", "NH", "03820"), new Phone("6036522011", "home"), "bruce.willis@mail.com"));
        contactEntryRepository.save(new ContactEntry(105, new Name("Luke", "S", "Captain"), new Address("10 Woodbury Ave", "Portsmouth", "NH", "03801"), new Phone("6036082011", "home"), "luke.captain@mail.com"));
        contactEntryRepository.save(new ContactEntry(106, new Name("Bruce", "S", "Captain"), new Address("14 Contral Street", "Portsmouth", "NH", "03801"), new Phone("6036082544", "home"), "bruce.captain@mail.com"));
    }

    @PreDestroy
    public void removeData()
    {
        contactEntryRepository.deleteAll();
    }

}
