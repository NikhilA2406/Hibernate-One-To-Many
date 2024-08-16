package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.AnswerTable;
import com.nikhil.model.QuestionTable;



public class UpdateRetrive {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		QuestionTable question = session.get(QuestionTable.class,1);
		
		System.out.println(question.getQuestion());
		
		for(AnswerTable answers: question.getAnswerList())
		{
			System.out.println(answers.getAnswer());
		}
		try
		{
			
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
			
			session.close();
			sessionFactory.close();
		}


	}

}
