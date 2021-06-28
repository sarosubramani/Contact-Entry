# Contact-Entry
Contact Entry System

#Using Postman to test the application once deployed
Following are the URLs

Create Contact
http://localhost:8080/dao/contacts

#sample json request
{
    "id": 201,
    "name": {
        "first": "John",
        "middle": "S",
        "last": "White"
    },
    "address": {
        "street": "321 Central Avenue",
        "city": "Portsmouth",
        "state": "NH",
        "zip": "03822"
    },
    "phone": {
        "number": "403 692 4777",
        "type": "Home"
    },
    "email": "joshwhite@gmail.com"
}

Get all contacts
http://localhost:8080/dao/contacts

Get contact by ID
http://localhost:8080/dao/contacts/201

Update contact by ID
http://localhost:8080/dao/contacts/201

#sample json request
{
    "id": 201,
    "name": {
        "id": 5,
        "first": "Josh",
        "middle": "S",
        "last": "White"
    },
    "address": {
        "id": 4,
        "street": "9 Portland Avenue",
        "city": "Dover",
        "state": "NH",
        "zip": "03820"
    },
    "phone": {
        "id": 6,
        "number": "6036628771",
        "type": "home"
    },
    "email": "josh.white@mail.com"
}

Delete contact by ID
http://localhost:8080/dao/contacts/201

Get contacts by phone type
http://localhost:8080/dao/contacts/phone/home

# H2 Databse in-memory
When application is started, databse comes loaded with data (@PostConstruct is used to create table rows)
when the application is terminated, data will be destroyed (@PreDestroy is used)

#How to access H2 console 
Console URL
http://localhost:8080/h2-console/

Properties for the above H2 console
File path within workspace where data is stored = ./data/contactentry
Username = sa
Password = password

