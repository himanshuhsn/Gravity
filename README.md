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
- https://logigame-gravity.herokuapp.com (Backend)

## Local Dev Setup
1. Fork and clone the repo.
2. Provide `CROSS_ORIGIN_ALLOW_URL` as environment variable or replace `${CROSS_ORIGIN_ALLOW_URL}` with a `url` from which call will be made.
   1. If called from local set `null`
   2. If called from other website set it as `<website-name>` (i.e. https://www.logigame.tk)

## Deployment
1. Currently, it's deployed to heroku.
2. Make sure `CROSS_ORIGIN_ALLOW_URL` environment variable is set to the website name to allow cross-origin. 