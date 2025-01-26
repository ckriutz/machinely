from flask_sqlalchemy import SQLAlchemy
#import db


db = SQLAlchemy()

class Employee(db.Model):
    __tablename__ = 'employee'

    employeeid = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String(255), nullable=False)
    position = db.Column(db.String(255))
    start_date = db.Column(db.DateTime)
    end_date = db.Column(db.DateTime)

    def __repr__(self):
        return f'<Employee {self.name}>'