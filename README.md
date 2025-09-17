## Lagerhantering – Backend

### Beskrivning
Detta är backend-delen av ett enkelt lagerhanteringssystem byggt med **Spring Boot**, **Java 17** och en **H2-databas**.

API:et gör det möjligt att:
* Lägga till nya produkter
* Visa en lista över alla produkter
* Uppdatera produktens antal
* Ta bort produkter

Systemet används av frontend-applikationen (React + TypeScript) men kan även testas separat med t.ex. `curl` eller ett verktyg som Postman.
Länk till Frontend-applikationen: (https://github.com/AliMalla/item-frontend)

---

### Förutsättningar
* **Java 17** eller senare installerat
* **Maven 3.8+** (om du kör via kommandorad)

---

### Installation & Körning

1. **Klona projektet**
   ```bash
   git clone <repo-url>
   cd <projektmapp>
   ```

2. **Bygg och starta applikationen**
   ```bash
   ./mvnw spring-boot:run
   ```
   eller, om du har Maven globalt:
   ```bash
   mvn spring-boot:run
   ```

3. **API tillgängligt**
    * REST-API körs på: `http://localhost:8080/items`
    * H2-konsol (för att se databasen): `http://localhost:8080/h2-console`
        * **JDBC URL:** `jdbc:h2:file:./data/itemsDB`
        * **User:** `sa`
        * **Password:** (lämna tomt)

---

### Viktiga Endpoints
| Metod | Endpoint        | Beskrivning                              |
|------|-----------------|------------------------------------------|
| GET  | `/items`        | Hämta alla artiklar                      |
| POST | `/items`        | Skapa en ny artikel                      |
| PUT  | `/items/{name}` | Uppdatera antal (saldo) för vald artikel |
| DELETE | `/items/{name}` | Ta bort en artikel                       |

---

### Antaganden
* H2-databasen sparas på disk (`./data/itemsDB.mv.db`) så data finns kvar även efter omstart.
* Ingen autentisering eller auktorisering är implementerad – systemet antas köras i en kontrollerad miljö.

---

### Testning
Du kan testa API:et med t.ex. `curl` om du inte har frontend projektet:
```bash
curl -X POST http://localhost:8080/items -H "Content-Type: application/json" -d "{\"name\":\"Handskar\",\"quantity\":50,\"unity\":\"paket\"}"
```
