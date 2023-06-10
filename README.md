
# Feku Json
<p>
  <img alt="Github: JayManale" src="https://img.shields.io/github/last-commit/jaymanale/FekuJson" />
</p>

Free Simple fake API for Testing and Prototyping.

![FekuJson](https://github.com/jaymanale/FekuJson/assets/5653906/86817329-2483-4575-ae65-9c2c5e8f5e47)


## When to use
Feku Json is a free online REST API that you can use whenever you need some fake data to test things locally.

## Postman API

Let go to [API](https://documenter.getpostman.com/view/305770/2s93eSabYH)


## Resources
Feku Json comes with a set of 3 resources:

[/users](https://documenter.getpostman.com/view/305770/2s93eSabYH#31f128f2-1cc0-4a42-9887-b3c84f0ea1e5) - 10 users

[/products](https://documenter.getpostman.com/view/305770/2s93eSabYH#47ad5018-e3d7-45f8-ba43-ef08f7694835) - 50 Products

[/books](https://documenter.getpostman.com/view/305770/2s93eSabYH#890178a2-a735-4133-bae3-866cc1969068) - 100 books

## Parameters

| First Header (Optional) | Second Header                                            |
|-------------------------|----------------------------------------------------------|
| `pageNumber`            | specify the current page [ default `0` ]                 |
| `pageSize`              | results per page [ default `10` per page ]               |
| `sortBy`                | sort results by a certain field [ default `'id'` field ] |
| `sortDir`               | set the sort order to `asc` or `desc`  [default asc]     |

## Routes
All HTTP methods are supported. You can use http or https for your requests.

1. GET    &emsp;&emsp; &emsp;    [/products](https://documenter.getpostman.com/view/305770/2s93eSabYH#47ad5018-e3d7-45f8-ba43-ef08f7694835)

    Request :
     ```yaml
     var requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };
      
    fetch("https://fekujson-production.up.railway.app/api/v1/products", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
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

2. GET    &emsp;&emsp;&emsp;    [/products/1](https://documenter.getpostman.com/view/305770/2s93eSabYH#104e97fc-e1c8-42ea-bef6-f20743739db0)

    Request :
    
     ```yaml
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
   };
   
   fetch("https://fekujson-production.up.railway.app/api/v1/products/10", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
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

3. PUT    &emsp;&emsp;&emsp;     [/products/1](https://documenter.getpostman.com/view/305770/2s93eSabYH#30669c92-cb42-41b7-bf90-7625824432de)

    Request :
    ```yaml
    var raw = "{\r\n    \"productName\": \"Awesome Paper Bottle\",\r\n    \"material\": \"wool\",\r\n    \"price\": \"43.72\",\r\n    \"department\": \"Baby, Kids & Music\",\r\n    \"color\": \"blue\",\r\n    \"promotionCode\": \"GoodPromo368049\"\r\n}";

   var requestOptions = {
      method: 'PUT',
      body: raw,
      redirect: 'follow'
   };
   
   fetch("https://fekujson-production.up.railway.app/api/v1/products/1", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
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


4. DELETE    &emsp;&emsp;&emsp;     [/products/1](https://documenter.getpostman.com/view/305770/2s93eSabYH#80645b32-2a17-4a61-bda0-f808d93d2074)

      Request :

    ```yaml
   var requestOptions = {
      method: 'DELETE',
      redirect: 'follow'
   };
   
   fetch("https://fekujson-production.up.railway.app/api/v1/products/2", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
    ```

   Response :

    ```json
    {
      "message":"Product with ID : 2 Deleted Successfully."  
    }
    ```

5. GET (With Parameters)   &emsp;&emsp;&emsp;     [/products/](https://documenter.getpostman.com/view/305770/2s93eSabYH#df9e31af-9d9e-40d5-b568-7104c07cdcb5)
  
   Request :

   ```yaml
   var requestOptions = {
       method: 'GET',
       redirect: 'follow'
   };
   
   fetch("https://fekujson-production.up.railway.app/api/v1/products/?sortBy=productName&sortDir=asc&pageNumber=1&pageSize=5", requestOptions)
       .then(response => response.text())
       .then(result => console.log(result))
       .catch(error => console.log('error', error));
  
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
