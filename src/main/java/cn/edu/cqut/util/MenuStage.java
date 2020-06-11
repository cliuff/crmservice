package cn.edu.cqut.util;

import java.util.HashMap;
import java.util.List;

public class MenuStage {

	private String title = null;
	private List<HashMap<String, String>> children = null;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<HashMap<String, String>> getChildren() {
		return children;
	}
	public void setChildren(List<HashMap<String, String>> children) {
		this.children = children;
	}
	
	
	

}
