
# Feku Json

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)


Free Simple fake API for Testing and Prototyping.

## When to use
Feku Json is a free online REST API that you can use whenever you need some fake data to test things locally.

## Demo

Let go to [Rapid API](https://rapidapi.com/jaymanale29/api/feku-json1/)


## Resources
Feku Json comes with a set of 2 resources:

[/users](https://rapidapi.com/jaymanale29/api/feku-json1) - 10 users

[/products](https://rapidapi.com/jaymanale29/api/feku-json1) - 50 Products

[/books](https://rapidapi.com/jaymanale29/api/feku-json1) - 100 books

## Parameters

| First Header (Optional) | Second Header                                            |
|-------------------------|----------------------------------------------------------|
| `pageNumber`            | specify the current page [ default `0` ]                 |
| `pageSize`              | results per page [ default `10` per page ]               |
| `sortBy`                | sort results by a certain field [ default `'id'` field ] |
| `sortDir`               | set the sort order to `asc` or `desc`  [default asc]     |

## Routes
All HTTP methods are supported. You can use http or https for your requests.

1. GET    &emsp;&emsp; &emsp;    [/products](https://fekujson.herokuapp.com/api/v1/products)

    Request :
     ```yaml
     const options = {
        method: 'GET',
        headers: {
        'X-RapidAPI-Key': 'YOUR_API_KEY',
        'X-RapidAPI-Host': 'feku-json1.p.rapidapi.com'
    }
    };
    
        fetch('https://feku-json1.p.rapidapi.com/api/v1/products', options)
        .then(response => response.json())
        .then(response => console.log(response))
        .catch(err => console.error(err));
     ```
    Response :
    ```json
      {
    "content": [
        {
            "id": 1,
            "productName": "Intelligent Iron Hat",
            "material": "Marble",
            "price": "91.46",
            "department": "Home, Movies & Sports",
            "color": "yellow",
            "promotionCode": "SpecialSavings420226"
        },
        {
            "id": 2,
            "productName": "Durable Linen Bag",
            "material": "Silk",
            "price": "27.32",
            "department": "Sports",
            "color": "maroon",
            "promotionCode": "AmazingSavings810673"
        },
        {
            "id": 3,
            "productName": "Incredible Iron Bottle",
            "material": "Wool",
            "price": "74.80",
            "department": "Movies, Music & Toys",
            "color": "sky blue",
            "promotionCode": "CoolPromotion107804"
        },
        {
            "id": 4,
            "productName": "Awesome Bronze Watch",
            "material": "Leather",
            "price": "12.54",
            "department": "Computers & Jewelry",
            "color": "maroon",
            "promotionCode": "IncrediblePromo545273"
        },
        {
            "id": 5,
            "productName": "Fantastic Cotton Lamp",
            "material": "Linen",
            "price": "14.43",
            "department": "Games",
            "color": "azure",
            "promotionCode": "KillerCode065452"
        },
        {
            "id": 6,
            "productName": "Sleek Rubber Lamp",
            "material": "Aluminum",
            "price": "82.63",
            "department": "Industrial",
            "color": "sky blue",
            "promotionCode": "SpecialCode776047"
        },
        {
            "id": 7,
            "productName": "Awesome Granite Shoes",
            "material": "Granite",
            "price": "77.23",
            "department": "Electronics & Outdoors",
            "color": "olive",
            "promotionCode": "SweetPrice205512"
        },
        {
            "id": 8,
            "productName": "Heavy Duty Wooden Wallet",
            "material": "Rubber",
            "price": "72.35",
            "department": "Games",
            "color": "sky blue",
            "promotionCode": "SpecialPromotion627361"
        },
        {
            "id": 9,
            "productName": "Durable Granite Wallet",
            "material": "Linen",
            "price": "28.02",
            "department": "Baby & Health",
            "color": "tan",
            "promotionCode": "PremiumSale626165"
        },
        {
            "id": 10,
            "productName": "Awesome Plastic Clock",
            "material": "Copper",
            "price": "55.85",
            "department": "Computers",
            "color": "silver",
            "promotionCode": "AwesomeSale344693"
        }
    ],
    "pageNumber": 0,
    "pageSize": 10,
    "totalElements": 50,
    "totalPages": 5,
    "lastPage": false
   }
    ```

2. GET    &emsp;&emsp;&emsp;    [/products/1](https://fekujson.herokuapp.com/api/v1/products/1)

    Request :
    
     ```yaml
     const options = {
     method: 'GET',
     headers: {
       'X-RapidAPI-Key': 'YOUR_API_KEY',
       'X-RapidAPI-Host': 'feku-json1.p.rapidapi.com'
     }
    };
    
       fetch('https://feku-json1.p.rapidapi.com/api/v1/products/1', options)
       .then(response => response.json())
       .then(response => console.log(response))
       .catch(err => console.error(err));
     ```
    Response :
    
    ```json
    {
        "id": 1,
        "productName": "Durable Iron Watch",
        "material": "Marble",
        "price": "82.17",
        "department": "Computers & Sports",
        "color": "orchid",
        "promotionCode": "SweetPromotion460591"
    }
    ```

3. PUT    &emsp;&emsp;&emsp;     /products/1

    Request :
    ```yaml
     const options = {
     method: 'PUT',
     headers: {
       'content-type': 'application/json',
       'X-RapidAPI-Key': 'YOUR_API_KEY',
       'X-RapidAPI-Host': 'feku-json1.p.rapidapi.com'
     },
     body: '{"productName":"Awesome Paper Bottle","material":"wool","price":"43.72","department":"Baby, Kids & Music","color":"blue","promotionCode":"GoodPromo368049"}'
     };
    
       fetch('https://feku-json1.p.rapidapi.com/api/v1/products/1', options)
       .then(response => response.json())
       .then(response => console.log(response))
       .catch(err => console.error(err));
    ```
    
    Response :
    ```json
    {
        "id": 1,
        "productName": "Awesome Paper Bottle",
        "material": "wool",
        "price": "43.72",
        "department": "Baby, Kids & Music",
        "color": "blue",
        "promotionCode": "GoodPromo368049"
    }
    ```


4. DELETE    &emsp;&emsp;&emsp;     /products/1

      Request :

    ```yaml
   const axios = require("axios");
   
   const options = {
   method: 'DELETE',
   url: 'https://feku-json1.p.rapidapi.com/api/v1/products/1',
   headers: {
   'X-RapidAPI-Key': 'YOUR_API_KEY',
   'X-RapidAPI-Host': 'feku-json1.p.rapidapi.com'
   }
   };
   
   axios.request(options).then(function (response) {
   console.log(response.data);
   }).catch(function (error) {
   console.error(error);
   });
    ```

   Response :

    ```json
    {
      "message":"Product with ID : 5 Deleted Successfully."  
    }
    ```

5. GET (With Parameters)   &emsp;&emsp;&emsp;     /products/
  
   Request :

   ```yaml
   const axios = require("axios");

   const options = {
   method: 'GET',
   url: 'https://feku-json1.p.rapidapi.com/api/v1/products',
   params: {pageNumber: '0', pageSize: '5', sortBy: 'id', sortDir: 'asc'},
   headers: {
   'X-RapidAPI-Key': 'YOUR_API_KEY',
   'X-RapidAPI-Host': 'feku-json1.p.rapidapi.com'
   }
   };
   
   axios.request(options).then(function (response) {
   console.log(response.data);
   }).catch(function (error) {
   console.error(error);
   });
  
   ```
   Response :

    ```json
    
      {
    "content": [
        {
            "id": 1,
            "productName": "Intelligent Iron Hat",
            "material": "Marble",
            "price": "91.46",
            "department": "Home, Movies & Sports",
            "color": "yellow",
            "promotionCode": "SpecialSavings420226"
        },
        {
            "id": 2,
            "productName": "Durable Linen Bag",
            "material": "Silk",
            "price": "27.32",
            "department": "Sports",
            "color": "maroon",
            "promotionCode": "AmazingSavings810673"
        },
        {
            "id": 3,
            "productName": "Incredible Iron Bottle",
            "material": "Wool",
            "price": "74.80",
            "department": "Movies, Music & Toys",
            "color": "sky blue",
            "promotionCode": "CoolPromotion107804"
        },
        {
            "id": 4,
            "productName": "Awesome Bronze Watch",
            "material": "Leather",
            "price": "12.54",
            "department": "Computers & Jewelry",
            "color": "maroon",
            "promotionCode": "IncrediblePromo545273"
        },
        {
            "id": 5,
            "productName": "Fantastic Cotton Lamp",
            "material": "Linen",
            "price": "14.43",
            "department": "Games",
            "color": "azure",
            "promotionCode": "KillerCode065452"
        }
    ],
    "pageNumber": 0,
    "pageSize": 5,
    "totalElements": 50,
    "totalPages": 10,
    "lastPage": false
   }
    
    ```

###
Coded and maintained with ❤️ by - [@JayramManale](https://www.jayrammanale.com/)
© 2022
