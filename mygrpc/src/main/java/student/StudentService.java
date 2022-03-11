package student;

import com.san.mygrpc.Student.LoginRequest;
import com.san.mygrpc.Student.None;
import com.san.mygrpc.Student.Response;
import com.san.mygrpc.studentGrpc.studentImplBase;

import io.grpc.stub.StreamObserver;

public class StudentService extends studentImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<Response> responseObserver) {
		System.out.println("login started");
		String stdName = request.getUsername();
		String passwd = request.getPassword();
		Response.Builder response = Response.newBuilder();
		//System.out.println(stdName+"::"+passwd);
		if(stdName.equalsIgnoreCase(passwd)) {
			response.setResponsecode(0).setResponsemessage("You are in");
			System.out.println(stdName+" logged in");
		}else {
			response.setResponsecode(500).setResponsemessage("You are out");
			System.out.println(stdName+" login failed");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
			
	}

	@Override
	public void logout(None request, StreamObserver<Response> responseObserver) {
		
	}

}
