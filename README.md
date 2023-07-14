# movies-api
Movies API consuming TMDB (https://developer.themoviedb.org/reference/intro/getting-started)

## Set token environment variable
### Windows
In terminal, run $env:MOVIES_TOKEN = {your_tmdb_token} replacing the text in curly braces with your TMDB token.

### macOS
In terminal, run export MOVIES_TOKEN = {your_tmdb_token} replacing the text in curly braces with your TMDB token.

## Run in local environment
Run ./gradlew bootRun in terminal. <br/>
In browser, put the URL http://localhost:8080/movies?name={movie_title}&page={page_number}

## Build jar
Run ./gradlew build in terminal.