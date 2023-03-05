# Gravity

## Game Description
- This game is similar to the famous tic-tac-toe game, but has different rules, hence requires different strategy to win.
- At first you will be greated with 7*7 board.
- Two player will choose their symbols to fill up the cells of the board.
- There will be alternative turn for players to put their symbols on the board.
- Player with the turn will click on the cell to fill the cell with his/her choosen symbol.
- The game will be played according to following rules.

## Rules

- The player who first fills 4 consecutive horizontal, vertical or diagonal cells will be the winner.
- No upper cell can be filled unless all the cell below the given cell (if present) is filled.

## Site
- https://www.logigame.tk/ (Final website)
- https://gravity-q8e6.onrender.com (Backend)

## API documentation
- Swagger UI can be accessed at `<URL>/swagger-ui/#/`
- Where `URL` can be `http://localhost:8080` or `https://www.logigame.tk`

## Local Dev Setup
1. Fork and clone the repo.
2. Make sure jdk11 is installed.
3. Replace the content of `application.properties` to `spring.crossoriginallow.url=null`, so that it can be tested from local using [gravity-frontend](https://github.com/himanshuhsn/Gravity-Frontend).

## Deployment
1. Currently, it's deployed to render using docker.
2. Make sure to reset the content of `application.properties` back to `spring.crossoriginallow.url=https://www.logigame.tk`.
3. Try to build the docker image locally. `docker build --platform linux/amd64 . -t gravity:latest`
4. Try to run locally using docker. `docker run -it -p 8080:8080 gravity`.
5. Raise PR against master branch. Code in master branch should auto deploy to render.