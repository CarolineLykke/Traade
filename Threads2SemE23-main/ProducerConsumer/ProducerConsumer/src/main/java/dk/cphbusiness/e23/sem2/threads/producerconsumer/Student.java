package dk.cphbusiness.e23.sem2.threads.producerconsumer;

import java.util.Random;

public class Student implements Runnable
{
	private String name;
	private ISyncBuffer<Question> box;

	public Student(String name, ISyncBuffer<Question> box)
	{
		this.name = name;
		this.box = box;
	}

	public void receiveResult(Question question)
	{
		System.out.println(name + " recieved result: " +
			question.getN1() +
			" + " + question.getN2() +
			" = " + question.getResult());
	}

	@Override
	public void run()
	{
		Random rnd = new Random();
		while(true)
		{
			int n1 = rnd.nextInt(100) + 1;
			int n2 = rnd.nextInt(100) + 1;
			Question question = new Question(n1, n2, this);
			box.addProduct(question);
			System.out.println(name + " asked: " +
				question.getN1() +
				" + " + question.getN2() +
				" = ?");
			try
			{
				long waitTime = rnd.nextInt(10000) + 3000;
				Thread.sleep(waitTime);
			} catch (InterruptedException e)
			{
			}
		}
	}
}
