package com.dover.controller;

import com.dover.datamodel.ContactEntry;
import org.springframework.data.repository.CrudRepository;

public interface ContactEntryRepository extends CrudRepository<ContactEntry, Integer> {

}
