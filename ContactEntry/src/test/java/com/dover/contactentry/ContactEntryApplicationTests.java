package com.dover.contactentry;

import com.dover.controller.ContactEntryRepository;
import com.dover.datamodel.Address;
import com.dover.datamodel.ContactEntry;
import com.dover.datamodel.Name;
import com.dover.datamodel.Phone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ContactEntryApplicationTests {

	@Autowired
	private ContactEntryRepository contactEntryRepository;

	private static List<ContactEntry> testContactEntryList = new ArrayList<>();

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() {
		for (ContactEntry setupContactEntry : contactEntryRepository.findAll()) {
			testContactEntryList.add(setupContactEntry);
		}
	}

	@Test
	public void testGetContacts () {
		Assert.assertTrue(testContactEntryList.size()>0);
	}

	@Test
	public void testGetContactsByID () {
		Optional<ContactEntry> localContactEntry = contactEntryRepository.findById(103);
		Assert.assertEquals(Optional.ofNullable(localContactEntry.get().getId()), Optional.ofNullable(103));
	}

	@Test
	public void testCreateContact(){
		contactEntryRepository.save(new ContactEntry(301, new Name("Harry", "W", "King"), new Address("2 Main Street", "Dover", "NH", "03820"), new Phone("6236828771", "mobile"), "harry.king@mail.com"));
		Assert.assertEquals(Optional.ofNullable(contactEntryRepository.findById(301).get().getPhone().getNumber()), Optional.ofNullable("6236828771"));
	}

	@Test
	public void testUpdateContact(){
		Assert.assertEquals(Optional.ofNullable(contactEntryRepository.findById(106).get().getName().getLast()), Optional.ofNullable("Captain"));
		Assert.assertEquals(Optional.ofNullable(contactEntryRepository.findById(106).get().getEmail()), Optional.ofNullable("bruce.captain@mail.com"));

		contactEntryRepository.save(new ContactEntry(106, new Name("Bruce", "S", "Wayne"), new Address("14 Contral Street", "Portsmouth", "NH", "03801"), new Phone("6036082544", "home"), "bruce.wayne@mail.com"));
		Assert.assertEquals(Optional.ofNullable(contactEntryRepository.findById(106).get().getName().getLast()), Optional.ofNullable("Wayne"));
		Assert.assertEquals(Optional.ofNullable(contactEntryRepository.findById(106).get().getEmail()), Optional.ofNullable("bruce.wayne@mail.com"));
	}

	@Test
	public void testDleteContact(){
		contactEntryRepository.deleteById(103);
		Assert.assertFalse(contactEntryRepository.findById(103).isPresent());
	}

	@Test
	public void testGetContactsByPhoneType(){
		boolean homePhone = false;
		for (ContactEntry localContactEntry:testContactEntryList) {
			if("home".equalsIgnoreCase(localContactEntry.getPhone().getType()))
			{
				homePhone = true;
			}
		}
		Assert.assertTrue(homePhone);
	}

}
