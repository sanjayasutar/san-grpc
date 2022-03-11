package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import student.StudentService;

public class StudentGRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Server server  = ServerBuilder.forPort(8080).addService(new StudentService()).build();
		server.start();
		
		System.out.println("Student service is up and running on "+ server.getPort());
		
		server.awaitTermination();
		
	}
	
}
