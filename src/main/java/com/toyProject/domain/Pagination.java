package com.toyProject.domain;

import lombok.Getter;

@Getter
public class Pagination {

	Criteria criteria;
	int startPage; // Pagination 시작 페이지
	int endPage; // Pagination 마지막 페이지
	int realEndPage; // 끝 페이지
	int totalCount;
	int displayPageNumber = 10;

	boolean prev;
	boolean next;

	public Pagination(Criteria criteria, int totalCount) {
		this.criteria = criteria;
		this.totalCount = totalCount;
		int pageNumber = criteria.getNowPageNum();
		endPage = (int) Math.ceil((double) pageNumber / displayPageNumber) * displayPageNumber;
		startPage = endPage - displayPageNumber + 1;
		realEndPage = (int) Math.ceil((double) totalCount / criteria.getPagingAmount());

		prev = startPage != 1;
		next = endPage < realEndPage;

		if (endPage > realEndPage)
			endPage = realEndPage;
	}

}
