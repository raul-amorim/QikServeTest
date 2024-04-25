The code on this repository is divided into 2 different projects, the API to return the data and the code to run the grocery store.

I've created a simple Java API to return the data necessary when called to the same endpoints on the json files (/products and /products/{id}). The Main project access directly the endpoint to retreive the products list and with it calls the same endpoints for each product registered. The promotions are calculated whenever possible and all money saved is calculated and shown at the end of the purchase.
