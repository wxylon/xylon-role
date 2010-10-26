package test;

import java.io.*; 
import java.util.*; 
import javax.comm.*; 
public class CommTest{ 
	public static void main(String[] args){ 
	
	SerialPort serialPort=null; 
	
	DataOutputStream doutput=null; 
	
	InputStream inputStream; 
	
	CommPortIdentifier portId=null; 
	
	String messageString="hello \n"; 
	
	try{ 
		portId=CommPortIdentifier.getPortIdentifier("COM1"); 
	}catch(NoSuchPortException ne) { 
		System.out.println("ne"); ne.printStackTrace(); 
	} 
	try{ 
		serialPort=(SerialPort) portId.open("TestComm", 5); 
		OutputStream output = serialPort.getOutputStream(); 
		doutput=new DataOutputStream(output); 
		inputStream = serialPort.getInputStream(); 
	}catch(PortInUseException ex) { 
		System.out.println("ex"); ex.printStackTrace(); 
	}catch(IOException ie) { 
		System.out.println("ie"); 
		ie.printStackTrace(); 
	// serialPort.close();
	} 
	
	try { 
		serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE); 
	} catch (UnsupportedCommOperationException e) {} 
	try { 
		doutput.write(messageString.getBytes()); 
	} catch (IOException e) {} 
	}
} 
