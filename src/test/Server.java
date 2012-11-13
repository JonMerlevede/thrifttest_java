package test;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {

	private void start() {
		try {
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(7911);
			TesterImpl impl = new TesterImpl();
			Tester.Processor<Tester.Iface> processor = new Tester.Processor<Tester.Iface>(impl);
			TNonblockingServer.Args args = new TNonblockingServer.Args(serverTransport);
			TServer server = new TNonblockingServer(args.processor(processor));
			System.out.println("Starting server on port 7911...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("test");
		Server srv = new Server();
		srv.start();
	}

}
