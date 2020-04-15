## Telepítés és futtatás
#### Szükséges hozzá:
- Clojure
- shadow-cljs

#### Függelékek telepítése
```shell
npm install
```

#### Fejlesztői szerver indítása
```shell
shadow-cljs watch app

```

#### Elérés
```shell
http://localhost:3000
```

#### Szerkezet
```shell

├── public               /html,css,js
│   ├── css
│   │   └── style.css
│   └── index.html 
├── src                  /Clojurescript forráskód
    └── app
        ├── core.cljs    /Webapp betöltése
        ├── state.cljs   /Kliens oldali adatok
        └── views.cljs   /Felhasználói felület
├── README.md            /Github leírás
├── package.json         /Javascript npm függelékek
└── shadow-cljs.edn      /Clojurescript függgelékek
```
