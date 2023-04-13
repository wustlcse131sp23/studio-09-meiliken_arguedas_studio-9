package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.

public class Student {
		private String fName;
		private String lName;
		private int idNum;
		private int attCredits;
		private int passCredits;
		private double tGQP;
		private double bBB;


		public Student (String firstName, String lastName, int idNumber) {
			this.fName = firstName;
			this.lName = lastName;
			this.idNum = idNumber;
		}
		// GETTER METHODS
		/**
		     * 
		     * @return returns first name
		     */
		public String getFirstName() {
			return this.fName;
		}
		/**
		     * 
		     * @return returns last name
		     */
		public String getLastName(String lName) {
			return this.lName = lName;
		}

		public String getFullName () {
			return this.fName + " " +  this.lName;
		}

		public int  getId() {
			return this.idNum;
		}
		// SETTER METHODS
		public void setLastName(String lastName) {
			this.lName = lastName;
		}
		// CLASS METHODS
	/**
		     *   Setter method - calculates number of quality points, adds how many attempted and passing credits
		     * @param grade    grade received for the course
		     * @param credits  amount of credits received for the course
		     * 
		     * return 
		     */

		public void submitGrade(double grade, double credits) {
			this.tGQP += grade * credits; // definition of quality points
			if (grade >= 1.7 ) {
				this.passCredits += credits; }
			this.attCredits += credits;
		}
	/**
		     * returns number of attempted credits
		     * @return attempted credits
		     */
		public int getTotalAttemptedCredits() {
			return this.attCredits;
		}
		public int getTotalPassingCredits() { 
			return this.passCredits;
		}
		/**
		     * calculates GPA for a student
		     * @return GPA
		     */
		public double calculateGradePointAverage () {
			return this.tGQP / this.attCredits;
		}
		
	/**
		     * Decides what grade student is in based on how many attempted credits student has
		     * @return grade of student
		     */
		public String getClassStanding () {
			if (this.passCredits < 30) {
				return "First Year";
			}
			else if (this.passCredits < 60) {
				return "Sophomore";
			}
			else if	(this.passCredits < 90) {
				return "Junior";
			}
			else {
				return "Senior";
			}
		}
		
		/**
		     * decides whether student is eligible for Phi Beta Kappa based on credits and GPA
		     * @return boolean of whether student is eligible
		     */
		
		public boolean isEligibleForPhiBetaKappa() {
			if (this.passCredits >= 98 && this.calculateGradePointAverage() >= 3.6 || this.passCredits >= 75 && calculateGradePointAverage() >= 3.8) {
				return true;
			}
			else { 
				return false;
			}
		}
		
	/**
		     * takes in from other methods student's bear bucks balance
		     * @return number of bear bucks student has
		     */
		
		public double getBearBucksBalance() { 
			return this.bBB;
		}
	/**
		     * adds bear bucks to student balance
		     * @param amount amount student wishes to add
		     */
		
		public void depositBearBucks (double amount) {
			this.bBB += amount;
		}
		/**
		     * deducts bear bucks from student balance
		     * @param amount amount student wishes to deduct
		     */
		public void deductBearBucks (double amount) {
			if (this.bBB <= amount) {
				this.bBB = 0.0;
			}
			else { 
				this.bBB -=amount;
			}
		}
		/**
		     * cashes out bear buck account 
		     * @return number of bear bucks left minus $10 fee
		     */
		
		public double cashOutBearBucks () { 
			double back = 0.0;
			if (this.bBB >= 10) {
				back = this.bBB -10;
			}
			this.bBB = 0;
			return back;
		}
		/**
		     * creates new student who is a legacy using parents' information
		     * @param firstName    legacy's first name
		     * @param other        parent #2
		     * @param isHyphenated describes whether legacy's last name is hyphenated
		     * @param id           id number of legacy
		     * @return
		     */
		public Student createLegacy (String first, Student other, boolean isHyphenated, int id) {
		
				String lastName = "";
				if (isHyphenated == true) {
					lastName = this.lName + "-" + other.lName;
				}
				else { 
					lastName = this.lName;
				}
				Student legacy = new Student (first, lastName, id);
				legacy.bBB = this.cashOutBearBucks() + other.cashOutBearBucks();
				return legacy;
			}
			@Override
			public String toString() {
				return getFullName () + " " + getId();
			}
		}


