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

├── public
│   ├── css
│   │   └── style.css
│   └── index.html
├── src
    └── app
        ├── core.cljs
        ├── state.cljs
        └── views.cljs
├── README.md
├── package.json
└── shadow-cljs.edn
```
