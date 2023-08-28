package dk.cphbusiness.e23.sem2.threads.producerconsumer;

public class Question
{
	private Student student;
	private int n1;
	private int n2;
	private int result;

	public Question(int n1, int n2, Student student)
	{
		this.n1 = n1;
		this.n2 = n2;
		this.student = student;
		this.result = 0;
	}

	public int getN1()
	{
		return n1;
	}

	public int getN2()
	{
		return n2;
	}

	public void setResult(int result)
	{
		this.result = result;
	}

	public int getResult()
	{
		return result;
	}

	public Student getStudent()
	{
		return student;
	}

}
