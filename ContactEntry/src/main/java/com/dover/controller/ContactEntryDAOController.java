package com.dover.controller;

import com.dover.datamodel.ContactEntry;
import com.dover.datamodel.PhoneDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ContactEntryDAOController {

    private static final Logger log = LoggerFactory.getLogger(ContactEntryDAOController.class);

    @Autowired
    private ContactEntryRepository contactEntryRepository;

    @GetMapping("/dao/contacts")
    public @ResponseBody Iterable<ContactEntry> getContacts()
    {
        return contactEntryRepository.findAll();
    }

    @GetMapping("/dao/contacts/{id}")
    public @ResponseBody
    Optional<ContactEntry> getContactByID(@PathVariable Integer id)
    {
        Optional<ContactEntry> localContactEntry = contactEntryRepository.findById(id);
        if(!localContactEntry.isPresent()) {
            throw new UserNotFoundException("ID not found");
        }

        return localContactEntry;
    }

    @PostMapping("/dao/contacts")
    public void createContact( @RequestBody ContactEntry localContactEntry)
    {
        contactEntryRepository.save(localContactEntry);
    }

    @PutMapping("/dao/contacts/{id}")
    public void updateContact(@RequestBody ContactEntry localContactEntry, @PathVariable Integer id) {
        if(contactEntryRepository.existsById(id))
        {
            contactEntryRepository.save(localContactEntry);
        }
    }

    @DeleteMapping("/dao/contacts/{id}")
    public void deleteContact(@PathVariable Integer id) {
        if(contactEntryRepository.existsById(id))
        {
            contactEntryRepository.deleteById(id);
        }
        else
        {
            throw new UserNotFoundException("ID not found");
        }
    }

    @GetMapping("/dao/contacts/phone/{type}")
    public @ResponseBody List<PhoneDetails> getContactsByPhoneType(@PathVariable String type)
    {
        List<PhoneDetails> localPhoneDetailsList = new ArrayList<>();
        PhoneDetails localPhoneDetails;

        for (ContactEntry localContactEntry : contactEntryRepository.findAll()) {
            localPhoneDetails = new PhoneDetails();
            if(type.equalsIgnoreCase(localContactEntry.getPhone().getType())){
                localPhoneDetails.setName(localContactEntry.getName());
                localPhoneDetails.setPhone(localContactEntry.getPhone().getNumber());
                localPhoneDetailsList.add(localPhoneDetails);
            }
        }

        Comparator<PhoneDetails> sortByLastName = (ph1, ph2) -> {
            if(ph1.getName().getLast().compareToIgnoreCase(ph2.getName().getLast()) > 1)
                return 1;
            else
                return -1;
        };

        Comparator<PhoneDetails> sortByFirstName = (ph1, ph2) -> {
            if(ph1.getName().getFirst().compareToIgnoreCase(ph2.getName().getFirst()) > 1)
                return 1;
            else
                return -1;
        };

        Collections.sort(localPhoneDetailsList, sortByLastName.thenComparing(sortByFirstName));

        return localPhoneDetailsList;
    }

}