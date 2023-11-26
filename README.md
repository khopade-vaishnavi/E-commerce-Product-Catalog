# E-commerce-Product-Catalog

## Category

## 1. Create Category
### Endpoint
- **URL**: `http://localhost:1012/api/category/createCategory`
- **Method**: `POST`
### Request
{
    "name" :"Fruit"
}
## Response:
{
    "flag": true,
    "msg": "category add successfully",
    "responseCode": 200
}

## Product

## 1. Create Product

### Endpoint
- **URL**: `http://localhost:1012/api/product/createProduct`
- **Method**: `POST`

### Request
```json
{
    "name": "Mango",
    "price": 150,
    "categoryId": 2
}
### Response
{
    "flag": true,
    "msg": "Product added successfully",
    "responseCode": 200
}
## 2. Update Product
- **URL**: ` http://localhost:1012/api/product/updateProduct`
- **Method**: `PUT`
### Request
```json
{
    "productId": 10,
    "name": "Bangles",
    "price": 150,
    "categoryId": 1
}
### Response
{
    "flag": true,
    "msg": "Product updated successfully",
    "responseCode": 200
}

## 3.Remove Product
- **URL**: ` http://localhost:1012/api/product/removeProduct/productId`
- **Method**: `DELETE`
### Reuest : None
### Response:
{
    "flag": false,
    "msg": "Failed to remove product",
}
## 4.Get Products by Category
- **URL**: `http://localhost:1012/api/product/AllProductCategoryWise/categoryId`
- **Method**: `GET`
### Request : None
### Response:
[
    {
        "productId": 4,
        "name": "Mango",
        "price": 150.0,
        "categoryMaster": {
            "categoryId": 2,
            "name": "Fruit"
        }
    }
]





