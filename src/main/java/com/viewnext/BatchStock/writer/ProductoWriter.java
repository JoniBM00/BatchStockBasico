package com.viewnext.BatchStock.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import com.viewnext.BatchStock.model.Producto;

@Component
public class ProductoWriter {

	@Bean
	public FlatFileItemWriter<Producto> writer() {

		return new FlatFileItemWriterBuilder<Producto>().name("productoItemWriter")
				.resource(new PathResource("stockTerminales.csv")).delimited()
				.names("lugar", "id", "stock", "stockReal", "stockVirtual").build();

	}

//	@Bean		//ESTE TAMBIEN FUNCIONA
//
//	public FlatFileItemWriter<Producto> writer() {
//
//		FlatFileItemWriter<Producto> writer = new FlatFileItemWriter<>();
//
//		writer.setShouldDeleteIfExists(true);
//		writer.setEncoding("UTF-8");
//
//		writer.setResource(new PathResource("stockTerminales.csv"));
//
//		writer.setAppendAllowed(true);
//
//		DelimitedLineAggregator<Producto> aggregator = new DelimitedLineAggregator<>();
//
//		aggregator.setDelimiter(",");
//
//		BeanWrapperFieldExtractor<Producto> extractor = new BeanWrapperFieldExtractor<>();
//
//		extractor.setNames(new String[] { "lugar", "id", "stock", "stockReal", "stockVirtual" });
//
//		aggregator.setFieldExtractor(extractor);
//
//		writer.setLineAggregator(aggregator);
//
//		return writer;
//
//	}

}
