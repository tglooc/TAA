package sample.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.simple.client.IRun;

@SpringBootApplication
public class SampleSimpleApplication implements CommandLineRunner {

	// Simple example shows how a command line spring application can execute an
	// injected bean service. Also demonstrates how you can use @Value to inject
	// command line args ('--name=whatever') or application properties

	@Autowired(required = true)
	private IRun irun;

	public void run(String... args) {
		this.irun.run();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleSimpleApplication.class, args);
	}

}
