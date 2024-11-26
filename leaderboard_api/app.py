from flask import Flask, request, jsonify, Response
from flask_restful import Resource, Api
import pickle
import pathlib
from dataclasses import dataclass
import logging
import platform
import socket


@dataclass
class Entry:
    name: str
    opponent: str
    score: int
    timestamp: int


DATABASE_PATH = pathlib.Path(__file__).parent / "leaderboard.pickle"
API_KEYS_PATH = pathlib.Path(__file__).parent / "api_keys.txt"
app = Flask(__name__)
api = Api(app)

def get_leaderboard() -> list:
    if DATABASE_PATH.exists():
        with open(DATABASE_PATH, "rb") as f:
            return pickle.load(f)
    else:
        return []

api_keys = set()
with open(API_KEYS_PATH, "r") as f:
    for key in f.readlines():
        api_keys.add(key)


class Leaderboard(Resource):
    def get(self, api_key):
        assert api_key in api_keys
        return jsonify_leaderboard(get_leaderboard())

    def post(self, api_key):
        assert api_key in api_keys
        req_json = request.get_json()
        assert "name" in req_json
        assert "opponent" in req_json
        assert "score" in req_json
        assert "timestamp" in req_json

        leaderboard = get_leaderboard()
        leaderboard.append(
            Entry(
                name=req_json["name"][:40],
                opponent=req_json["opponent"][:40],
                score=int(req_json["score"]),
                timestamp=int(req_json["timestamp"])
            )
        )

        with open(DATABASE_PATH, "wb") as f:
            pickle.dump(leaderboard, f)

        return jsonify_leaderboard(leaderboard)

    def delete(self, api_key):
        assert api_key in api_keys

        with open(DATABASE_PATH, "wb") as f:
            pickle.dump([], f)

        return jsonify_leaderboard([])


def jsonify_leaderboard(lb):
    lb_json = {"leaderboard": []}
    for entry in lb:
        lb_json["leaderboard"].append(
            {
                "name": entry.name,
                "opponent": entry.opponent,
                "score": entry.score,
                "timestamp": entry.timestamp,
            }
        )
    return jsonify(lb_json)

api.add_resource(Leaderboard, '/leaderboard/<string:api_key>')


__all__ = ("main",)


def main() -> None:
    import gunicorn.app.base

    class StandaloneApplication(gunicorn.app.base.BaseApplication):
        def __init__(self, app, options=None):
            self.options = options or {}
            self.application = app
            super().__init__()

        def load_config(self):
            self.cfg = gunicorn.app.base.Config()
            config = {
                key: value for key, value in self.options.items() if key in self.cfg.settings and value is not None
            }
            for key, value in config.items():
                self.cfg.set(key.lower(), value)

        def load(self):
            return self.application

    if platform.uname().system.lower() == "linux":
        logging.info("Starting web server with gunicorn")
        options = {
            "bind": "0.0.0.0:6969",
            "workers": 1,
            "timeout": 120,
        }
        StandaloneApplication(app, options).run()
    else:
        logging.info("Starting web server with flask development server")
        app.run(debug=True, host=socket.gethostbyname(socket.gethostname()), port=6969)


if __name__ == "__main__":
    main()
