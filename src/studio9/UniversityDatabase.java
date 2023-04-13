package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final HashMap<String, Student> database;
	
	public UniversityDatabase() {
		database = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		database.put(accountName, student);
	}

	public int getStudentCount() {
		
	int count = 0;
	for(Entry<String, Student> dbEntry : database.entrySet()) {
		count++;
	}
		return count;
		
	}

	public String lookupFullName(String accountName) {
		
		if(!database.containsKey(accountName)) {
			return null;	
		}
		else  {
			Student student = database.get(accountName);
			return student.getFullName();
		}
			
	}

	public double getTotalBearBucks() {

		double total = 0.0;
		for(Entry<String, Student> dbEntry : database.entrySet()) {
			Student student = dbEntry.getValue();
			total += student.getBearBucksBalance();
		}
		
		return total;
	}
}
