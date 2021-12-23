#Bestelling
Besteling draait op poort 8085

De API van bestellingen heeft de volgende URLS met functionaliteit

|methods|URL|omschrijving|
|:---:|:---:|:---:|
|Get|/bestelling|Geeft alle bestellingen|
|Get|/bestelling/{id}|Geeft bestelling bij id|
|Get|/bestelling/bezorgt/{id}|Update de status van bestelling naar bezorgt
|Get|/bestelling/temp/klant|Geeft alle klanten die opgeslagen zijn in de database van de Bestelling serves
|Get|/bestelling/temp/item|Geeft alle item/gerechten die opgeslagen zijn in de database van de Bestelling serves
|Post|/bestelling|Hij vraagt om de volgende json body <br />'"klantId": uuid van klant "bestelingLijst":<br />{ string gerechtid :aantal, <br />string gerechtid :aantal}'|

Hij kijkt dan of deze klant en gerechten er zijn, haalt hier informatie van op uit de database en stuurt dit door naar de q publisher

Bestelling heeft de volgende rabbitMQ functionaliteit<br />
•	Een publisher die de bestelde gerechten door stuurt naar gerechten<br />
•	Een listener die luister naar de registreren q en daar op luister naar het aanmaken / update van een klant en deze opslaat<br />
•	Een listener die luister naar de gerechten q en daar luistert naar een nieuwe lijst van beschikbare gerechten en dan de oude verwijderd en de nieuwe lijst van beschikbare gerechten opslaat


#Gerecht
Gerecht draait op poort 8082

de API van gerecht heeft de volgende URLS met functionaliteiten

|methods|URL|omschrijving|
|:---:|:---:|:---:|
|Get|gerecht/getAll/geeft alle gerechten|
|Post|gerecht/create|ingredient aan een lijst en maakt daarna een gerecht met ingredient
|Delete|gerecht/delete/{id}|verwijderd het gerecht
|Get|/gerecht /sendAll |verstuurd een lijst van gerechten naar voorraad
|Get|/gerecht /sendGerecht |dummy data als test

Gerecht heeft de volgende rabbitMQ functionaliteit<br />
•	Een publisher die een lijst met gerechten stuurt naar voorraad
              Een pubisher die een lijst van beschikbare geruchten stuurt naar bestelling<br />
•	Een listener die luister naar voorraad die beschikbare gerecht opstuurt 
•	Een listener die luister naar bestelling voor beschikbare gerechten voor die bestelling<br />


#Voorraad
Voorraad draait op poort 8083

De API van voorraad heeft de volgende URLS met functionaliteit

|methods|URL|omschrijving|
|:---:|:---:|:---:|
|Get|/voorraad/getAll|Geeft alles in voorraad|
|Post|/voorraad/create|Maakt voorraad aan|
|Delete|/voorraad/delete/{id}|Verwijderd voorraad|

Bestelling heeft de volgende rabbitMQ functionaltiteiten<br />
• Een publisher die de beschikbare gerechten door stuurt naar gerecht<br />
• Een listener die luistert naar gerecht<br />

#Registreren

