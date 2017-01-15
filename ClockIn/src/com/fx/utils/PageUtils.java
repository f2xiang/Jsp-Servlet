package com.fx.utils;

/**
 * ��ҳ������
 * @author Administrator
 *
 */
public class PageUtils {
	
	/**
	 * ��������  �ó�����
	 * @param everyPage  ÿҳ��ʾ������
	 * @param totalCount  �ܵļ�¼��
	 * @param currentPage  ��ǰҳ
	 * @return
	 */
	public static Page createPage(int everyPage,int totalCount,int currentPage) {//������ҳ��Ϣ����
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
	 * ÿҳ��ʾ�ļ�¼��  ���Ϊ0  Ĭ�� һ������  
	 * @param everyPage
	 * @return
	 */
	public static int getEveryPage(int everyPage) {		//���ÿҳ��ʾ��¼��
		return everyPage == 0 ? 1 : everyPage;
	}
	
	/**
	 * ��ȡ��ǰҳ  ���Ϊ0    Ĭ��Ϊ��1ҳ
	 * @param currentPage
	 * @return
	 */
	public static int getCurrentPage(int currentPage) {	//��õ�ǰҳ
		return currentPage == 0 ? 1 : currentPage;
	}
	
	
	/**
	 * ����ܵ�ҳ��
	 * @param everyPage
	 * @param totalCount
	 * @return
	 */
	public static int getTotalPage(int everyPage,int totalCount) {//�����ҳ��
		int totalPage = 0;
		if(totalCount != 0 &&totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}
	
	
	/**
	 * �����ʼ��
	 * @param everyPage ÿҳ��ʾ������
	 * @param currentPage  ��ǰҳ
	 * @return
	 */
	public static int getBeginIndex(int everyPage,int currentPage) {//�����ʼλ��
		return (currentPage - 1) * everyPage;
	}
	
	/**
	 * �ж��Ƿ�����һҳ  ��ǰҳΪ 1 ��Ϊfalse
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasPrePage(int currentPage) {//����Ƿ�����һҳ
		return currentPage == 1 ? false : true;
	}
	
	
	/**
	 * �ж��Ƿ�����һҳ 
	 * @param totalPage
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasNextPage(int totalPage, int currentPage) {	//����Ƿ�����һҳ
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
	
}
