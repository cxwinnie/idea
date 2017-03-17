package cn.xuxianda.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class Page<T> implements Serializable{

	private static final long serialVersionUID = 4433498202034731463L;

	private Long page;//当前页
	
	private Long totalCount;
	
	private Long rows;//每页记录数
	
	private Long totalPage;
	
	private List<T> list; 
	
	private String keyWords;
	
	private Long start;//需要这里处理

	private T paramEntity;
	
	private Map map = new HashMap<String,Object>();
	
	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	/*public Long getTotalCount() {
		return totalCount;
	}*/

	public void setTotalCount(Long totalCount) {
		map.put("total", totalCount);
		this.totalCount = totalCount;
	}

	public Long getRows() {
		return rows;
	}

	public void setRows(Long rows) {
		this.rows = rows;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	/*public List<T> getList() {
		return list;
	}*/

	public void setList(List<T> list) {
		map.put("rows", list);
		this.list = list;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Long getStart() {
		return (page-1)*rows;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public T getParamEntity() {
		return paramEntity;
	}

	public void setParamEntity(T paramEntity) {
		this.paramEntity = paramEntity;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
}
