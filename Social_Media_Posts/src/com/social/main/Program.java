package com.social.main;

import com.social.db.PostDbManager;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PostDbManager.SavePost();
		PostDbManager.LoadPosts();
		PostDbManager.displayPost();
	}

}
