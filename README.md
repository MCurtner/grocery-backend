# grocery-backend
Springboot application server backend for comparing groceries of different stores.


## Summary

This web application is designed to be run with the angular [Groceries Web App](https://github.com/MCurtner/groceriesapp) and [Python Web Scraper](https://github.com/MCurtner/Scraper-Python) and a PostgresDB. In the current configuration the web scraper scrapes relevant grocery product from two different site and store the formatted objects in the PostgresDB.  The springboot backend server creates the REST API to retrieve the grocery values to be displayed in the web application. 