This is a demo project for a player setup API endpoint that accepts
a groovy script to set up a player. See my blog post [The Player Setup Endpoint – Let the Frontend run Backend code](https://tech.innogames.com/the-player-setup-endpoint-let-the-frontend-run-backend-code/).

Start the application via `./gradlew bootRun`.

Example request to set up player:
```
POST /setup-player HTTP/1.1
Host: localhost:8080
Content-Type: text/plain

player
    .withName("The Mighty")
    .withLevel(99)
    .withWeapon(weapon -> weapon
        .withType(Weapon.Type.AXE)
        .withAttackPoints(20)
        .withColor("#26639b")
        .entityRef(ref("weapon"))
    )
    .withHeadgear(headgear -> headgear
        .withType(Headgear.Type.HELMET)
        .withDefense(35)
        .withColor("#711284")
        .entityRef(ref("helmet"))
    )
```

Then open http://localhost:8080/player that shows the current state of the player as an SVG image.

