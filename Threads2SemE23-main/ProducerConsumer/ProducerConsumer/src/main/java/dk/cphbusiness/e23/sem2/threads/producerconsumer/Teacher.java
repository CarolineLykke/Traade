package dk.cphbusiness.e23.sem2.threads.producerconsumer;

import java.util.Random;

public class Teacher implements Runnable
{
	private String name;
	private ISyncBuffer<Question> box;

	public Teacher(String name, ISyncBuffer<Question> box)
	{
		this.name = name;
		this.box = box;
	}

	@Override
	public void run()
	{
		Random rnd = new Random();
		while(true)
		{
			Question question = box.getProduct();
			int result = question.getN1() + question.getN2();
			question.setResult(result);
			System.out.println(name + " answered: " +
				question.getN1() +
				" + " + question.getN2() +
				" = " + question.getResult());
			question.getStudent().receiveResult(question);
			try
			{
				long waitTime = rnd.nextInt(10000) + 10000;
				Thread.sleep(waitTime);
			} catch (InterruptedException e)
			{
			}
		}
	}
}
