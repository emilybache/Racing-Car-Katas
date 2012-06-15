package tddmicroexercises.telemetrysystem;

public interface IDataChannel {
	
	public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

	void send(String diagnosticMessage);

	String receive();
}
