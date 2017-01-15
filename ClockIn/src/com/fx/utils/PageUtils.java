package com.fx.utils;

/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageUtils {
	
	/**
	 * 三个参数  得出其他
	 * @param everyPage  每页显示的数据
	 * @param totalCount  总的记录数
	 * @param currentPage  当前页
	 * @return
	 */
	public static Page createPage(int everyPage,int totalCount,int currentPage) {//创建分页信息对象
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage);
	}
	
	/**
	 * 每页显示的记录数  如果为0  默认 一个数据  
	 * @param everyPage
	 * @return
	 */
	public static int getEveryPage(int everyPage) {		//获得每页显示记录数
		return everyPage == 0 ? 1 : everyPage;
	}
	
	/**
	 * 获取当前页  如果为0    默认为第1页
	 * @param currentPage
	 * @return
	 */
	public static int getCurrentPage(int currentPage) {	//获得当前页
		return currentPage == 0 ? 1 : currentPage;
	}
	
	
	/**
	 * 获得总的页数
	 * @param everyPage
	 * @param totalCount
	 * @return
	 */
	public static int getTotalPage(int everyPage,int totalCount) {//获得总页数
		int totalPage = 0;
		if(totalCount != 0 &&totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}
	
	
	/**
	 * 获得起始点
	 * @param everyPage 每页显示的数据
	 * @param currentPage  当前页
	 * @return
	 */
	public static int getBeginIndex(int everyPage,int currentPage) {//获得起始位置
		return (currentPage - 1) * everyPage;
	}
	
	/**
	 * 判断是否还有上一页  当前页为 1 就为false
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasPrePage(int currentPage) {//获得是否有上一页
		return currentPage == 1 ? false : true;
	}
	
	
	/**
	 * 判断是否还有下一页 
	 * @param totalPage
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasNextPage(int totalPage, int currentPage) {	//获得是否有上一页
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
	
}
