package com.willner.mist_gaming_store;

import com.willner.mist_gaming_store.util.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MistGamingStoreApplication implements CommandLineRunner {

	@Autowired
	DBUtils dbUtils;

	public static void main(String[] args) {
		SpringApplication.run(MistGamingStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dbUtils.populateDB();
		System.out.println("Aplicação rodando e pronta para uso...");
	}
}
