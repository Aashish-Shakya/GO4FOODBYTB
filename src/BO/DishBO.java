package BO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.DishDAO;
import DAO.DishJdbcDAO;
import entity.Dish;

public class DishBO {
//	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//	DishDAO dao = context.getBean("DishDAO", DishDAO.class);
//	
//	public List<Dish> getAllDishList() {
//		return dao.getAllDishes();
//	} 
	
	
	DishJdbcDAO dao = new DishJdbcDAO();
	
	public List<Dish> getAllDishList() throws Exception {
		return dao.list();
	}
	
	public Dish getDishByName(String dishName) {
		return dao.getDishByName(dishName);
	}
	
	public Map<String, List<Dish>> categorizeDishes() throws Exception {
		Map<String, List<Dish>> al = new HashMap<>();
		
		for (Dish dish : dao.list()) {
			if (al.containsKey(dish.getCategory())) {
				al.get(dish.getCategory()).add(dish);
			} else {
				al.put(dish.getCategory(), new ArrayList<Dish>() {{
					add(dish);
				}});
			}
		}
		return al;
	}
}
