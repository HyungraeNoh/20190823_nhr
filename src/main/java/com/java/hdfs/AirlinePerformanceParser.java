package com.java.hdfs;

import org.apache.hadoop.io.Text;

public class AirlinePerformanceParser {
	private int year;
	private int month;
	private int departureDealyTime = 0;
	private boolean departureDelayAvailable = true;
	
	public AirlinePerformanceParser(Text text) {
		try {
			String[] values = text.toString().split(",");
			
			if(!values[15].equals("NA")) {
				departureDealyTime = Integer.parseInt(values[15])/60;
			} else{
				departureDelayAvailable = false;
			}
			
			year =  Integer.parseInt(values[0]);
			
			month =  Integer.parseInt(values[1]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int getYear() {return year;}
	public int getMonth() {return month;}
	public int getDepartureDealyTime() {return departureDealyTime;}
	public boolean isDepartureDelayAvailable() {return departureDelayAvailable;}
}
