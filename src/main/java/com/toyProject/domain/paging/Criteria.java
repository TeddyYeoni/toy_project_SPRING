package com.toyProject.domain.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	int nowPageNum;
	int pagingAmount;
	
	public Criteria() {
		this(1,15);
	}
	
	public Criteria(int nowPageNum, int pagingAmount) {
		this.nowPageNum = nowPageNum;
		this.pagingAmount = pagingAmount;
	}	
	
	// #{maxRow}
	public int getMaxRow() {
		return this.nowPageNum * this.pagingAmount;
	}

	// #{minRow}
	public int getMinRow() {
		return (this.nowPageNum - 1) * this.pagingAmount;
	}

}
