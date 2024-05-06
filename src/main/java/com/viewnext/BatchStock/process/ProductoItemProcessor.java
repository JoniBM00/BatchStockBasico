package com.viewnext.BatchStock.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.viewnext.BatchStock.model.Producto;

public class ProductoItemProcessor implements ItemProcessor<Producto, Producto> {

	private static final Logger log = LoggerFactory.getLogger(Producto.class);

	@Override
	public Producto process(Producto item) throws Exception {
		if (item.getLugar().equalsIgnoreCase("PENINSULA")) {
			return item;
		} else {
			return null;
		}

	}

}
