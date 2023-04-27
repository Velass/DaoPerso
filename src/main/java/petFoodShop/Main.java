package petFoodShop;

import org.apache.log4j.BasicConfigurator;

import petFoodShop.dao.UserDAO;
import petFoodShop.model.IDAO;
import petFoodShop.model.User;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		 User user1=new User();
	        user1.setFirstName("Nathalie");
	        user1.setLastName("Forget");
	        user1.setLogin("nforget");
	        user1.setPwd("pwd1");

	       
	        IDAO<User> userDAO = UserDAO.getInstance();
	        //userDAO.create(user1);
	        userDAO.readAll();

	        
}
}
