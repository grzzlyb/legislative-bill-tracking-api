# Spring REST Legislative Bill Tracking API

The legislative bills tracking API built on top of Spring framework typically web scrapes the information about legislative bills and includes endpoints that allow users to retrieve the bill names and their current statuses.

## Installation
* Download the code
* Import as existing maven project
* Run on Tomcat 9.0.x server

## Endpoints

* `GET /api/bills`: This endpoint returns a list of all legislative bills, along with their current status and other metadata. The response format could be in JSON, XML or any other format that suits your needs. 

```
    {
        "billName": "Amendments to IT Rules, 2021",
        "billStatus": "Draft"
    },
    {
        "billName": "Draft Digital Personal Data Protection Bill, 2022",
        "billStatus": "Draft"
    },
    {
        "billName": "Draft Indian Telecommunication Bill, 2022",
        "billStatus": "Draft"
    }
    ...
```

* `GET /api/bills/{billStatus}`: This endpoint returns a list of legislative bills with a specific status. For example, **GET /bills/status/introduced** could return all bills that have been introduced but not yet passed.

```
    {
        "billName": "The Constitution (Scheduled Tribes) Order (Second Amendment) Bill, 2022",
        "billStatus": "Passed"
    },
    {
        "billName": "The Constitution (Scheduled Tribes) Order (Fourth Amendment) Bill, 2022",
        "billStatus": "Passed"
    },
    {
        "billName": "The New Delhi International Arbitration Centre (Amendment) Bill, 2022",
        "billStatus": "Passed"
    },
    ...
  ```
  
* Error handling support added for `BAD_REQUEST` & `NOT_FOUND` status codes

```
{
    "status": 404,
    "message": "Bills not found.",
    "timeStamp": 1678629528500
}
```
