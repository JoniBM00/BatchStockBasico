package com.viewnext.BatchStock.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import com.viewnext.BatchStock.model.Producto;

@Component
public class ProductoWriter {

	@Bean
	FlatFileItemWriter<Producto> writer() {

		FlatFileItemWriter<Producto> writer = new FlatFileItemWriter<>();

		writer.setShouldDeleteIfExists(true);
		writer.setEncoding("UTF-8");

		writer.setResource(new PathResource("./../ficheroSalida/terminalesStock.csv"));

		writer.setAppendAllowed(true);

		DelimitedLineAggregator<Producto> aggregator = new DelimitedLineAggregator<>();

		aggregator.setDelimiter(";");

		BeanWrapperFieldExtractor<Producto> extractor = new BeanWrapperFieldExtractor<>();

		extractor.setNames(new String[] { "lugar", "id", "stock", "stockReal", "stockVirtual" });

		aggregator.setFieldExtractor(extractor);

		writer.setLineAggregator(aggregator);

		return writer;

	}

}
