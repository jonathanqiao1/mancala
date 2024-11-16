# Mancala Leaderboard API

This is a Flask application that implements a leaderboard API for a mancala game.

## Endpoints
### `/leaderboard/<api_key>`
This is the base route for the API. An API key must be provided to access all resources of this endpoint. 

#### GET
The GET method returns a list of all leaderboard entries.
```json 
{
  "leaderboard": [
    {
      "name": "bob",
      "opponent": "alice",
      "score": 34,
      "timestamp": 1731770356
    },
    {
      "name": "alice",
      "opponent": "bob",
      "score": 35,
      "timestamp": 1731770556
    }
  ]
}
```

### POST
The POST method adds an entry to the leaderboard. It expects a JSON body with the following format:
```json
{
  "name": string,
  "opponent": string,
  "score": int,
  "timestamp": int
}
```
Returns a status code 500 if the request is invalid. On a successful addition it returns the entire leaderboard in the same format as the GET request.

### DELETE
The DELETE method clears all entries in the leaderboard. On a successful clear returns the following response:
```json
{
  "leaderboard": []
}
```

## API Keys
An API key can be any string of URL-encodable characters of any length. API keys are stored one-per-line in the `api_keys.txt` file, which should be located in the same directory as `app.py`.

## Running the Api
To run the app, create a virtual environment and execute the `app.py` script. The app is configured to run on port `6969`. It will use a gunicorn server if ran on a linux host, otherwise it will default to Flask's default development server. 