package com.social.models;

public class Posts {
	int post_id;
	int comment_count;
	int like_count;
	String caption;
	int share_count;
	
	
	public Posts(int post_id, int comment_count, int like_count, String caption, int share_count) {
		super();
		this.post_id = post_id;
		this.comment_count = comment_count;
		this.like_count = like_count;
		this.caption = caption;
		this.share_count = share_count;
	}


	@Override
	public String toString() {
		return "Posts [post_id=" + post_id + ", comment_count=" + comment_count + ", like_count=" + like_count
				+ ", caption=" + caption + ", share_count=" + share_count + "]";
	}


	public int getPost_id() {
		return post_id;
	}


	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}


	public int getComment_count() {
		return comment_count;
	}


	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}


	public int getLike_count() {
		return like_count;
	}


	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public int getShare_count() {
		return share_count;
	}


	public void setShare_count(int share_count) {
		this.share_count = share_count;
	}
	
	
}
