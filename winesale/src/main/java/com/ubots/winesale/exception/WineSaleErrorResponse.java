package com.ubots.winesale.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WineSaleErrorResponse {

	private int status;
	private String message;
	private long timeStamp;

}
