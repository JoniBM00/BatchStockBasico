package com.viewnext.BatchStock.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.viewnext.BatchStock.listener.JobCompletionNotificationListener;
import com.viewnext.BatchStock.model.Producto;
import com.viewnext.BatchStock.process.ProductoItemProcessor;

@Configuration
public class ProductoSteps {

	@Bean
	public Job importUserJob(JobRepository jobRepository, Step step1, JobCompletionNotificationListener listener) {
		return new JobBuilder("importUserJob", jobRepository).listener(listener).start(step1).build();
	}

	@Bean
	public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
			FlatFileItemReader<Producto> reader, ProductoItemProcessor processor, FlatFileItemWriter<Producto> writer) {

		return new StepBuilder("step1", jobRepository).<Producto, Producto>chunk(10, transactionManager).reader(reader)
				.processor(processor).writer(writer).build();
	}

}
