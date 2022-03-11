package StudentClient;

import com.san.mygrpc.Student.LoginRequest;
import com.san.mygrpc.Student.Response;
import com.san.mygrpc.studentGrpc;
import com.san.mygrpc.studentGrpc.studentBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {

	public static void main(String[] args) {
		
		ManagedChannel channel =  ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
		
		studentBlockingStub stub = studentGrpc.newBlockingStub(channel);
		LoginRequest  inRequest = LoginRequest.newBuilder().setUsername("sanjay").setPassword("sanjay").build();
		System.out.println("Valid login");
		Response rs = stub.login(inRequest);
		
		System.out.println("Server response ::"+rs.getResponsemessage());
		
		System.out.println("Invalid login");
		
		LoginRequest  badRequest = LoginRequest.newBuilder().setUsername("vijay").setPassword("sanjay").build();
		
		Response rs1 = stub.login(badRequest);
		
		System.out.println("Server response ::"+rs1.getResponsemessage());
		
		channel.shutdown();
		
	}
}
