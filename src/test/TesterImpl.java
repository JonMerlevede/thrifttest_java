package test;

import org.apache.thrift.TException;

public class TesterImpl implements Tester.Iface {
	@Override
	public String makeString(TTest test) throws TException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < test.numberOfTimes; i++) {
			sb.append(test.mekker);
		}
		System.out.println("Method accessed!");
		return sb.toString();
	}

}
