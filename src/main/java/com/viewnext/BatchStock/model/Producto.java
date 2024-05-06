package com.viewnext.BatchStock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private String lugar;
	private Long id;
	private int stock;
	private int stockReal;
	private int stockVirtual;

}
