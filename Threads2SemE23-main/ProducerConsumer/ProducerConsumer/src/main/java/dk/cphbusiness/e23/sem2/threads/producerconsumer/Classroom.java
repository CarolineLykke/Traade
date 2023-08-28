package dk.cphbusiness.e23.sem2.threads.producerconsumer;

import java.util.ArrayList;

public class Classroom
{
	public static void main(String[] args)
	{
		ISyncBuffer<Question> box = new SingleSynchronizedBuffer<>();
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Alice", box));
		students.add(new Student("Bob", box));
		students.add(new Student("Carol", box));
		students.add(new Student("Dave", box));
		students.add(new Student("Eve", box));
		students.add(new Student("Frank", box));
		ArrayList<Teacher> teachers = new ArrayList<>();
		teachers.add(new Teacher("Mr. Anderson", box));
		teachers.add(new Teacher("Mrs. Brown", box));
		teachers.add(new Teacher("Mr. Clark", box));
		for(Student student : students)
		{
			new Thread(student).start();
		}
		Object lock = new Object();
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
		}
		for(Teacher teacher : teachers)
		{
			new Thread(teacher).start();
		}
		System.out.println("All threads started");


	}
}
