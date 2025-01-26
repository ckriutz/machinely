from flask import Flask, render_template
from flask_sqlalchemy import SQLAlchemy
from routes import routes
from models import db

app = Flask(__name__)
import os

#print db user and password with key and value
print("#### " + os.getenv('DB_USER'))
print("####" + os.getenv('DB_PASSWORD'))


#connect to db on localhost:5432

app.config['SQLALCHEMY_DATABASE_URI'] = f"postgresql://{os.getenv('DB_USER')}:{os.getenv('DB_PASSWORD')}@localhost:5432/employees"
print("#### " + app.config['SQLALCHEMY_DATABASE_URI'])
#print db uri


app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
#set db user and password

#db = SQLAlchemy(app)
#init db
db.init_app(app)


# Register routes
app.register_blueprint(routes)

@app.route('/')
def index():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)