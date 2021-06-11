package com.hexaware.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.hexaware.main.beans.Account;
import com.hexaware.main.beans.AccountType;




@Component
public class DBConfig {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
		
	}
	public Account processLogin(Account account) {
		Map<String,Object> map=new HashMap<>();
		map.put("email", account.getEmail());
		map.put("password", account.getPassword());
		String sql="select email,password from account where email=:email and password=:password";
		return jdbc.queryForObject(sql, map, new AccountMapper());
	}
	class AccountMapper implements RowMapper<Account>{
		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException{
			Account acc=new Account();		
			acc.setId(Long.parseLong(Integer.toString(rs.getInt("id"))));
			acc.setEmail(rs.getString("email"));
			acc.setPassword(rs.getString("password"));

			return acc;
		}
		public int addAmount(AccountType accounttype) {
			Map<String,Object> map=new HashMap<>();
			map.put("type", accounttype.getType());
			map.put("amount", accounttype.getAmount());
			
			
			String sql="insert into accounttype(type,amount)values(:type,:amount)";
			return jdbc.update(sql,map);
	}
}
	
}
