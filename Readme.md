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

#Voorraad

#Registreren

