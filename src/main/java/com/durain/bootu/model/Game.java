package com.durain.bootu.model;

public class Game {
	private Integer id;

	private String type;

	private String name;

	private String define;

	private String template;

	private String sort;

	private String gkey;

	private String showName;

	private String funR;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDefine() {
		return define;
	}

	public void setDefine(String define) {
		this.define = define == null ? null : define.trim();
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template == null ? null : template.trim();
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort == null ? null : sort.trim();
	}

	public String getGkey() {
		return gkey;
	}

	public void setGkey(String gkey) {
		this.gkey = gkey == null ? null : gkey.trim();
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName == null ? null : showName.trim();
	}

	public String getFunR() {
		return funR;
	}

	public void setFunR(String funR) {
		this.funR = funR == null ? null : funR.trim();
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", type=" + type + ", name=" + name + ", define=" + define + ", template=" + template
				+ ", sort=" + sort + ", gkey=" + gkey + ", showName=" + showName + ", funR=" + funR + "]";
	}

}