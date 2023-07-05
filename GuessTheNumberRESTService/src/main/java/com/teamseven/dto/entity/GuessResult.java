package com.teamseven.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuessResult {
    private int exact;
    private int partial;
    
	@Override
	public String toString() {
		return "e:" + exact + ":p:" + partial;
	}

	public int getExact() {
		return exact;
	}

	public void setExact(int exact) {
		this.exact = exact;
	}

	public int getPartial() {
		return partial;
	}

	public void setPartial(int partial) {
		this.partial = partial;
	}

	public GuessResult(int exact, int partial) {
		super();
		this.exact = exact;
		this.partial = partial;
	}

	public GuessResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}