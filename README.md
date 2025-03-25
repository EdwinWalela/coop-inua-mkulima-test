# Inua Mkulima API

REST API for the Inua Mkulima Proram

## Tech Stack
- Java (SpringBoot REST API)
- Postgres v13 (Database)
- Docker

## Run Locally

Start database service

```
docker-compose up
```

## Run API

Using InteliJ, start the application

## API Documentation

### Create User

POST /api/user

Request Body 

```json
{
    "emailAddress":"edwin@mail.com",
    "password":"123456"
}
```

### Create Product

POST /api/product

sample request body

```json
{
    "name":"Animal feed",
    "description":"10 kg animal feed for cows",
    "quantity":70,
    "price":4050.0
}
```

### Get Products

GET /api/product?page=0&limit=10

sample response

```json
[
    {
        "id": 1,
        "name":"Animal feed",
        "description":"10 kg animal feed for cows",
       "quantity":70,
       "price":4050.0,
        "createdAt": "2025-03-25T11:11:27.277+00:00"
    }
]
```

### Add Item to User cart

POST /api/cart

request body

```json
{
    "userId":1,
    "productId":1,
    "quantity": 3
}
```

### Get User Cart

GET /api/cart/:userId

sample response 
```json
{
    "items": [
        {
            "id": 1,
            "product": {
              "id": 1,
              "name":"Animal feed",
              "description":"10 kg animal feed for cows",
              "price":4050.0
            },
            "quantity": 2
        }
    ],
    "totalAmount": 8100.0
}
```