package com.toyProject.domain;

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
		return this.nowPageNum * this.nowPageNum;
	}

	// #{minRow}
	public int getMinRow() {
		return (this.pagingAmount - 1) * this.pagingAmount;
	}

}
