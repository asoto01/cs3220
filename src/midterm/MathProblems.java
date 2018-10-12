package midterm;

import java.util.Random;

public class MathProblems {

	double num0 = 0.0;
	double num1 = 0.0;
	double answer = 0.0;
	String problem = "";
	




	public static void main(String[] args) {
		MathProblems maths = new MathProblems(1,2);
		
		System.out.println(maths.generateAddProb() + maths.addition());
		
		maths.setProblem("");
		System.out.println(maths.generateSubProb() + maths.subtraction());

	}
	
	
	public MathProblems(double num0, double num1) {
		super();
		this.num0 = num0;
		this.num1 = num1;
	}
	
	public MathProblems() {
		super();
		num0 = 0.0;
		num1 = 0.0;
		answer = 0.0;
	}
	
	// Methods that generates random math problems
	public String generateAddProb() {
		Random rand = new Random();
		int randNum0 = rand.nextInt(10);
		num0 = randNum0;
		int randNum1 = rand.nextInt(10);
		num1 = randNum1;
		StringBuilder strBuild = new StringBuilder(problem);
		strBuild.append(randNum0);
		strBuild.append(" + ");
		strBuild.append(randNum1);
		strBuild.append(" = ");
		problem = strBuild.toString();
		answer = num0 + num1;
		return problem;		
	}
	public String generateSubProb() {
		Random rand = new Random();
		int randNum0 = rand.nextInt(10);
		num0 = randNum0;
		int randNum1 = rand.nextInt(10);
		num1 = randNum1;
		StringBuilder strBuild = new StringBuilder(problem);
		strBuild.append(randNum0);
		strBuild.append(" - ");
		strBuild.append(randNum1);
		strBuild.append(" = ");
		problem = strBuild.toString();
		answer = num0 - num1;
		return problem;		
	}
	
	public String generateMultProb() {
		Random rand = new Random();
		int randNum0 = rand.nextInt(10);
		num0 = randNum0;
		int randNum1 = rand.nextInt(10);
		num1 = randNum1;
		StringBuilder strBuild = new StringBuilder(problem);
		strBuild.append(randNum0);
		strBuild.append(" * ");
		strBuild.append(randNum1);
		strBuild.append(" = ");
		problem = strBuild.toString();
		answer = num0 * num1;
		return problem;		
	}
	
	public String generateDivProb() {
		Random rand = new Random();
		int randNum0 = rand.nextInt(10);
		num0 = randNum0;
		int randNum1 = rand.nextInt(10);
		while (randNum1 == 0) {
			randNum1 = rand.nextInt(10);
		}
		num1 = randNum1;
		StringBuilder strBuild = new StringBuilder(problem);
		strBuild.append(randNum0);
		strBuild.append(" / ");
		strBuild.append(randNum1);
		strBuild.append(" = ");
		problem = strBuild.toString();
		answer = num0 / num1;
		return problem;		
	}
	
	
	
	// Define elementary operations
	public double addition() {
		answer = num0 + num1;
		return answer;
	}
	
	public double subtraction() {
		answer = num0 - num1;
		return answer;
	}
	
	public double multiplication() {
		answer = num0 * num1;
		return answer;
	}
	
	public double division() {
		answer = num0 / num1;
		return answer;
	}
	
	// Setters and Getters for each field
	public double getNum0() {
		return num0;
	}

	public void setNum0(double num0) {
		this.num0 = num0;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getAnswer() {
		return answer;
	}

	public void setAnswer(double answer) {
		this.answer = answer;
	}
	
	public String getProblem() {
		return problem;
	}


	public void setProblem(String problem) {
		this.problem = problem;
	}

	
	
	
}
