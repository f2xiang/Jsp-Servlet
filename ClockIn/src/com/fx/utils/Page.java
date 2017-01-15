package com.fx.utils;

/**
 * 分页实体类
 * @author Administrator
 *
 */
public class Page {
	//5个数据  2个是否
	
	
	private int everyPage;     //每页显示记录数
	
	private int totalCount;   //总的记录数
	
	private int currentPage;   //当前页
	
	private int totalPage;   //总页数
	
	private int beginIndex;   //起始点
	
	private boolean hasNextPage;   //是否还有下一页
	
	private boolean hasPrePage;   //是否还有上一页

	public Page(int everyPage, int totalCount, int currentPage, int totalPage,
			int beginIndex, boolean hasNextPage, boolean hasPrePage) {
		super();
		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.beginIndex = beginIndex;
		this.hasNextPage = hasNextPage;
		this.hasPrePage = hasPrePage;
	}

	
	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int gettotalCount() {
		return totalCount;
	}

	public void settotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}


	@Override
	public String toString() {
		return "Page [everyPage=" + everyPage + ", totalCount=" + totalCount
				+ ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", beginIndex=" + beginIndex + ", hasNextPage=" + hasNextPage
				+ ", hasPrePage=" + hasPrePage + "]";
	}
	
	
	
	
	
}
