from flask import Blueprint, request, jsonify
from models import Employee, db
from sqlalchemy.sql import text

routes = Blueprint('routes', __name__)

@routes.route('/employees', methods=['POST'])
def create_employee():
    data = request.get_json()
    new_employee = Employee(
        name=data['name'],
        position=data.get('position'),
        start_date=data.get('start_date'),
        end_date=data.get('end_date')
    )
    db.session.add(new_employee)
    db.session.commit()
    return jsonify({'message': 'Employee created successfully', 'employeeid': new_employee.employeeid}), 201

@routes.route('/employees', methods=['GET'])
def get_employees():
    employees = Employee.query.all()
    return jsonify([{
        'employeeid': emp.employeeid,
        'name': emp.name,
        'position': emp.position,
        'start_date': emp.start_date,
        'end_date': emp.end_date
    } for emp in employees]), 200

@routes.route('/employees/search', methods=['GET'])
def search_employees():
    wildcard_name = request.args.get('name')
    employees = db.session.execute(
        text("SELECT * FROM getEmployeesByWildcardName(:wildcard_name)"),
        {'wildcard_name': wildcard_name}
    ).fetchall()
    return jsonify([{
        'employeeid': emp.employeeid,
        'name': emp.name,
        'position': emp.position,
        'start_date': emp.start_date,
        'end_date': emp.end_date
    } for emp in employees]), 200