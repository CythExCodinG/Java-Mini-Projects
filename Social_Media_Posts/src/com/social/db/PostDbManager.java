package com.social.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.social.models.Posts;
import com.social.util.UserInputValidation;



public class PostDbManager {
	
	static List<Posts> postsList= new ArrayList<>();
	
	public static void SavePost() {
		try {
			Posts p=new Posts(0, 2, 3, "hellow this is first post", 4);
			Connection conn=ConnectDb.connectToDb();
			
			PreparedStatement psmt=conn.prepareStatement("INSERT INTO posts (comment_count,like_count,caption,share_count) VALUES(?,?,?,?)");
			psmt.setInt(1, p.getComment_count());
			psmt.setInt(2, p.getLike_count());
			psmt.setString(3, p.getCaption());
			psmt.setInt(4, p.getShare_count());
			
			int result = psmt.executeUpdate();
			
			System.out.println(result);
			
		} catch (SQLException | UserInputValidation e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void LoadPosts() {
		Connection conn;
		try {
			conn = ConnectDb.connectToDb();
			PreparedStatement psmt=conn.prepareStatement("SELECT * from posts");
			
			ResultSet rs=psmt.executeQuery();
			
			while(rs.next()) {
				int post_id= rs.getInt(1);
				int comment_count= rs.getInt(2);
				int like_count= rs.getInt(3);
				String caption= rs.getString(4);
				int share_count= rs.getInt(5);
				Posts p=new Posts(post_id, comment_count, like_count, caption, share_count);
				postsList.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserInputValidation e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void displayPost() {
		for (Posts posts : postsList) {
			System.out.println("Hwl bot");
			System.out.println( posts.toString());
		}
	}
}
