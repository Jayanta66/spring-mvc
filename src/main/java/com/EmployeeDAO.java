package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class EmployeeDAO {
	
	JdbcTemplate template;
	
	DriverManagerDataSource ds;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public static List<Employee> l = new ArrayList<>();
	
	public Employee addEmployee(Employee emp) {
		l.add(emp);
		return emp;
	}
	
/*	public List<Employee> getAllEmployees(){
		return template.query("select * from Emp", new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Employee emp = new Employee();
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEband(rs.getString(3));
				
				return emp;
				
			}
			
		});
	}
*/	
	public Employee addEmployee(int eid) {
		for(Employee emp:l) {
			if(emp.getEid()==eid) {
				return emp;
			}
		}
		return null;
	}
	/* ---------------------*/
	
	public int save(Employee p) {
		String sql = "insert into Emp(ename, eband) values('"+p.getEname()+"', '"+p.getEband()+"')";
		return template.update(sql);
	}
	
	
	public int update(Employee p) {		
		String sql = "update Emp set ename='"+p.getEname()+"', eband='"+p.getEband()+"' where eid="+p.getEid()+"";

	//	String sql = "update Emp set name='"+p.getEname()+"', band='"+p.getEband()+"'";
		return template.update(sql);
		
	}
	
	
	public int delete(int eid) {
		String sql = "delete from Emp where eid="+eid+"";
		return template.update(sql);
	}
	
	public Employee getEmpById(int eid) {
		String sql="select * from Emp where eid=?";
		return template.queryForObject(sql, new Object[] {eid}, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	
	public List<Employee> getEmployees(){
		return template.query("select * from Emp", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee emp = new Employee();
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEband(rs.getString(3));
				return emp;
			}
		});
	}
	
	
}
