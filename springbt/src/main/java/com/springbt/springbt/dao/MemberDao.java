package com.springbt.springbt.dao;

import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springbt.springbt.dto.Member;


@Repository
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Member selectById(Long id) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where id = ?",
				(rs, rowNum)-> {
						Member member = new Member(
								rs.getString("name"),
								rs.getInt("age"),
								rs.getString("email"),
								rs.getString("memo")
								);
						member.setId(id);
						return member;
				}, id);

		return results.isEmpty() ? null : results.get(0);
	}
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER",
				(rs, rowNum)-> {
						Member member = new Member(
								rs.getLong("id"),
								rs.getString("name"),
								rs.getInt("age"),
								rs.getString("email"),
								rs.getString("memo")
								);
						return member;
				});
		return results;
	}
	public void insert2(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((con) -> {
				PreparedStatement pstmt = con.prepareStatement
						("insert into member(name, age, email, memo ) values(?, ?, ?, ?)", new String[] {"id"});
				pstmt.setString(1, member.getName());
				pstmt.setInt(2, member.getAge());
				pstmt.setString(3, member.getEmail());
				pstmt.setString(4, member.getMemo());
				return pstmt;
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	} 

	public void update(Member member) {
		jdbcTemplate.update("update member set name=?, age=?, email=?, memo=? where id=?",
							member.getName(), member.getAge(), member.getEmail(), member.getMemo(), member.getId());
	}
	
	public void delete(Long id) {
		jdbcTemplate.update("delete from member where id =?", id);
	}

}
