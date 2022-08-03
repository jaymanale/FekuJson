
# Feku Json

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)


Free Simple fake API for Testing and Prototyping.

## When to use
Feku Json is a free online REST API that you can use whenever you need some fake data to test things locally.

## Resources
Feku Json comes with a set of 2 resources:

[/users](https://rapidapi.com/jaymanale29/api/feku-json1) - 10 users

[/products](https://rapidapi.com/jaymanale29/api/feku-json1) - 50 users

## Routes
GET and PUT - HTTP methods are supported. You can use http or https for your requests.

1. GET    &emsp;&emsp; &emsp;    [/products](https://fekujson.herokuapp.com/api/v1/products)

    Request :
     ```yaml
     const options = {
        method: 'GET',
        headers: {
        'X-RapidAPI-Key': '2548137a99msh3307ab54622080cp1504d8jsn53b20928f346',
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
    [{
        "id": 1,
        "firstName": "Otha",
        "lastName": "Conn",
        "email": "othaconn@gmail.com",
        "phone": "351.780.8291 x741",
        "website": "othaconn.com"
    }, {
        "id": 2,
        "firstName": "Tobias",
        "lastName": "Effertz",
        "email": "tobiaseffertz@gmail.com",
        "phone": "(076) 299-7527 x131",
        "website": "tobiaseffertz.com"
    }, {
        "id": 3,
        "firstName": "Louann",
        "lastName": "Fisher",
        "email": "louannfisher@gmail.com",
        "phone": "1-439-984-8248 x68577",
        "website": "louannfisher.com"
    }, {
        "id": 4,
        "firstName": "Vincenzo",
        "lastName": "Reilly",
        "email": "vincenzoreilly@gmail.com",
        "phone": "909.740.4064",
        "website": "vincenzoreilly.com"
    }, {
        "id": 5,
        "firstName": "Chase",
        "lastName": "Witting",
        "email": "chasewitting@gmail.com",
        "phone": "968.941.2800 x35809",
        "website": "chasewitting.com"
    }, {
        "id": 6,
        "firstName": "Krystyna",
        "lastName": "Lebsack",
        "email": "krystynalebsack@gmail.com",
        "phone": "(919) 567-5609",
        "website": "krystynalebsack.com"
    }, {
        "id": 7,
        "firstName": "Season",
        "lastName": "Schamberger",
        "email": "seasonschamberger@gmail.com",
        "phone": "754.128.6010 x566",
        "website": "seasonschamberger.com"
    }, {
        "id": 8,
        "firstName": "Felton",
        "lastName": "Kub",
        "email": "feltonkub@gmail.com",
        "phone": "(260) 473-5031",
        "website": "feltonkub.com"
    }, {
        "id": 9,
        "firstName": "Yaeko",
        "lastName": "Hessel",
        "email": "yaekohessel@gmail.com",
        "phone": "245-412-6773 x3036",
        "website": "yaekohessel.com"
    }, {
        "id": 10,
        "firstName": "Susana",
        "lastName": "O'Connell",
        "email": "susanao'connell@gmail.com",
        "phone": "039.163.6571 x6062",
        "website": "susanao'connell.com"
    }]
    ```

2. GET    &emsp;&emsp;&emsp;    [/products/1](https://fekujson.herokuapp.com/api/v1/products/1)

    Request :
    
     ```yaml
     const options = {
     method: 'GET',
     headers: {
       'X-RapidAPI-Key': '2548137a99msh3307ab54622080cp1504d8jsn53b20928f346',
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
       'X-RapidAPI-Key': '2548137a99msh3307ab54622080cp1504d8jsn53b20928f346',
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
## Demo

Let go to [Rapid API](https://rapidapi.com/jaymanale29/api/feku-json1/)

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://www.jayrammanale.com/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jayram-manale/)

##
Coded and maintained with ❤️ by - [@JayramManale](https://www.jayrammanale.com/)
© 2022