# Flashcards API
REST api built on Java's Spring framework connected to MariaDB database for Flashcards app.  
  
Front end for this API can be found [here](https://github.com/smiauek/flashcards-client)  
  
## Database ERD:  
  
![erd](/erd/flashcards_db.png)  
  
## Open Endpoints:  
Requests to open endpoints do not require authorization token, however requests only from allowed origins will be accepted.  
  
- `POST /users/new`  
This endpint consumes JSON body with use details, creates new user and saves it to database.  
- `POST /user/login`  
This endpint consumes JSON body with user credentials, upon succesful credential verification returns authorization token.  
- `GET /decks/`  
This endpoint returns list of all existing decks.  
- `GET /decks/:deckId`  
This endpoint returns deck details for a given deckId.  
- `GET /decks/find?searchTerm=______`  
This endpoint returns all decks where name or description inludes provided search term.  
- `GET /cards/:deckId`  
This endpoint list of flashcards for a given deckId.  
  
## Restricted Enpoints:  
Requests to restricted endpoints require authorization token, also requests only from allowed origins will be accepted.  
  
- `GET /users/one?username=______`  
This endpoint returns user details (excluding password) for a given username.
- `GET /decks/user/:userId`  
This endpoint returns list of decks for a given userId.  
- `GET /cards/one/:cardId`  
This endpoint returns card details for a given cardId.  
- `POST /decks/new`  
This endpoint consumes JSON body with deck details, creates new deck and saves it to database.  
- `POST /cards/new`  
This endpoint consumes JSON body with card details, creates new card and saves it to database.  
- `PUT /decks/update/:deckId`  
This enpoint consumes JSON body with deck details and saves updates to a given deck in database.  
- `PUT /cards/update/:cardId`  
This enpoint consumes JSON body with card details and saves updates to a given card in database.  
- `DELETE /decks/delete/:deckId`  
This endpoint removes given deck (and all cards associated with it) from database.  
- `DELETE /cards/delete/:cardId`  
This endpoint removes given card from database.


