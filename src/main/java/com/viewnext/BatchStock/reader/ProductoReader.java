package com.viewnext.BatchStock.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.viewnext.BatchStock.model.Producto;

@Component
public class ProductoReader {

//	@Bean	//NO FUNCIONA
//	public FlatFileItemReader<Producto> reader() {
//		return new FlatFileItemReaderBuilder<Producto>().name("productoItemReader").linesToSkip(1)
//				.resource(new ClassPathResource("stockTerminales.dat")).delimited()
//				.names("lugar", "id", "stock", "stockReal", "stockVirtual").targetType(Producto.class).build();
//	}

	@Bean
	public FlatFileItemReader<Producto> reader() {
		FlatFileItemReader<Producto> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new ClassPathResource("stockTerminales.dat"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}

	private LineMapper<Producto> lineMapper() {
		DefaultLineMapper<Producto> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("lugar", "id", "stock", "stockReal", "stockVirtual");
		BeanWrapperFieldSetMapper<Producto> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Producto.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}

}
