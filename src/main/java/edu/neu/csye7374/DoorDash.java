package edu.neu.csye7374;
import java.util.*;
/**
 * DoorDash model:
 * 
 * 100 TOTAL POINTS
 *  
 * USE AND COMPLETE CODING THIS SINGLE (partially coded) CLASS (add inner classes)
 * to Model Door Dash service demonstrating the correct use of all following design patterns:
 * 
 * Adapter, Builder, Bridge, Composite, Decorator, Singleton, Factory Method, Strategy
 * 
 * Demonstrate Point of Sale (POS) by displaying (on console stdout) 
 * ALL orders, totaled with all discounts as follows:
 * 	
 * 	Show ALL Orders NormalDiscount (0% decrease applied to each item price and Total), 
 * 	Show ALL Orders	MemberDiscount (10% decrease applied to each item price and Total), 
 * 	Show ALL Orders	SpecialDiscount (20% decrease applied to each item price and Total), 
 * 	Show ALL Orders	SuperBowlDiscount (20% increase applied to each item price and Total), 
 * 
 * 
 * 20 POINTS
 * 1. Create following food items using the following design patterns: 
 *    Builder, 
 *    Decorator,
 *    Singleton Factory (Eager, Lazy and Enum implementations)
 *    AND with the following attributes:
 * 
 * $ 0.99 French Fries
 * $ 1.29 Medium Drink
 * $ 3.49 Hamburger
 * $ 1.49 Hot Dog
 * $ 3.79 Cheeseburger
 * $ 4.49 Buffalo Wings
 * $ 2.49 Salad
 * $ 5.49 Pizza ($1 OPTIONS: cheese, mushrooms, onions, pepperoni, sausage)
 * 
 * 
 * 30 POINTS
 * 2. Create the following customer orders using the following design patterns: 
 *    Builder, 
 *    Singleton Factory (Eager, Lazy and Enum implementations)
 *    AND with the following attributes:
 *    
 * 	Dan's Customer Door Dash Order ID #1 Hamburger, Medium Drink
 * 	Pam's Customer Door Dash Order ID #2 HotDogCombo (HotDog, French Fries, Medium Drink)
 * 	Jim's Customer Door Dash Order ID #3 BurgerCombo (Hamburger, French Fries, Medium Drink)
 * 	Jen's Customer Door Dash Order ID #4 Cheeseburger, French Fries
 * 	Len's Customer Door Dash Order ID #5 WingCombo (Buffalo Wings, Medium Drink, Salad)
 * 	Sam's Customer Door Dash Order ID #6 PizzaCombo (Buffalo Wings, French Fries, Salad, Medium Drink, Pizza)
 * 
 * 
 * 40 POINTS
 * 3. Develop TWO Point of Sale APIs for Order purchases with DISCOUNTS (to change prices): 
 * 	NormalDiscount (0% decrease), 
 * 	MemberDiscount (10% decrease), 
 * 	SpecialDiscount (20% decrease), 
 * 	SuperBowlDiscount (20% increase)
 * 
 * MUST DEVELOPE APIs (PosAPI and CalculatorAPI) IN TWO PHASES (NOTE: all names with 1 & 2) 
 * using Bridge design pattern:
 * 
 * PosAPI Point of Sale API (PosAPI1 & PosAPI2)
 * 
 * 	Phase I 	class Pos1 and interface PosAPI1 with methods:
 * 		double sumTotal(List<Double> itemList); // add customer total
 * 		void setStrategy(PriceStrategyAPI s);	// set strategy for price adjustments
 *		double getSum();	// return sum total
 *		String toStringSumTotal();	// return String representation of sum total
 *
 * 	Phase II 	class Pos2 and interface PosAPI2 with methods:
 * 		double getChange(double cash);		// accept cash, return change
 *		String toStringCash();		// return String representation of customer cash submitted
 *		String toStringChange();	// return String representation of customer change received
 *
 * Calculator API (CalculatorAPI1 & CalculatorAPI2)
 * 
 *  PHASE I		class Calculator1 and interface CalculatorAPI1 with method:
 *      double add(double a, double b);
 *  
 *  PHASE II	class Calculator2 and interface CalculatorAPI2 with methods:
 *  	double sub(double a, double b);
 *  	double mult(double a, double b);
 *  	double div(double a, double b);
 *  
 *  
 * 10 POINTS
 *  4. Develop class OrderAdapter using Adapter design pattern, 
 *  to adapt Order to use an ItemAPI object
 *   
 * @author dpeters
 *
 */
public class DoorDash {
	/**
	 * static initialization block REQUIRED FOR DevelopmentLogEnum
	 * executed only once
	 */
	static {
		/**
		 * Set outer class (replace Driver)
		 */
		DevelopmentLogEnum.LOG.setOuterClass(DoorDash.class);
	}
	/**
	 * object initialization block REQUIRED FOR DevelopmentLogEnum
	 * executed with each constructor
	 */
	{
		/**
		 * Set outer class (use DevelopmentLogEnum defined below)
		 */
		DevelopmentLogEnum.LOG.setOuterClass(this.getClass());
	}
	
	/**
	 * DevelopmentLogEnum manages development log entries for this class
	 * 
	 * @author dgpeters
	 *
	 */
	public static enum DevelopmentLogEnum {
		LOG;
		
		private static final int MAJOR_REVISION;
		private static final int MINOR_REVISION;
		private static final String REVISION;
		private final static List<String> DEVELOPMENT_LOG_ENTRY_LIST;
		private Class outerClass = null;
		
		/**
		 * static initialization block
		 * executed once for this class
		 */
		static {
			MAJOR_REVISION = 1;
			MINOR_REVISION = 0;
			REVISION = Integer.valueOf(MAJOR_REVISION) + "." + Integer.valueOf(MINOR_REVISION);
			/**
			 * Detailed development log for this class
			 * 
			 * NOTE:	Everything here is contained in the specification of this enum 
			 * 				DevelopmentLogEnum
			 * 			and is compiled to be initialized BEFORE any code execution
			 * 			EVERYTHING IN THIS LOG IS CODE TO BE COMPILED AND NEVER EXECUTES
			 * 			EXCEPT TO DISPLAY 
			 * 				DEVELOPMENT_LOG_ENTRY_LIST
			 * 			Strings AND
			 * 				REVISION
			 * 	 		ON THE CONSOLE (STDOUT) OUTPUT.
			 * 
			 * 
			 * FOR EACH CHANGE to this class during development 
			 * (e.g., bug fixes or new features, inner classes or inner interfaces),
			 * add a detailed descriptive Literal String (with trailing comma) to this list
			 * BEFORE " **End of Log Entry List **" String
			 * e.g. 
			 * 
			 * "1.2: made changes to blah blah to fix bug blah",
			 * " **End of Log Entry List **"
			 * 
			 * OR
			 * 
			 * "3.7: created new inner class blah to add new blah blah feature",
			 * " **End of Log Entry List **"
			 * 
			 */
			DEVELOPMENT_LOG_ENTRY_LIST = new ArrayList<>(Arrays.asList(
					"1.0: initial version of class created",
					"** End of Log Entry List **"
					));
			} // end static block
		
		public void setOuterClass(Class outerClass) {
			this.outerClass = outerClass;
		}
		public Class getOuterClass() {
			return outerClass;
		}

		public String getRevision() {
			return DevelopmentLogEnum.REVISION + "." + DevelopmentLogEnum.DEVELOPMENT_LOG_ENTRY_LIST.size();
		}
		/**
		 * revisionLog shows all the entries in the development log made during the development of this class
		 * @return
		 */
		public String getDevelopmentLog() {
			StringBuilder sb = new StringBuilder(outerClass.getSimpleName());
			
			sb.append(" Development Log ").append(this.getRevision()).append("\n");
			DevelopmentLogEnum.DEVELOPMENT_LOG_ENTRY_LIST.forEach((e) -> sb.append(e).append("\n"));
			
			return sb.toString();
		}
	} // end of enum DevelopmentLogEnum
	
	
	/**
	 * ItemAPI implemented by all Item objects for sale
	 *
	 * @author dpeters
	 */
	private interface ItemAPI {
		double getPrice();
		String getName();
	}
	/**
	 * OrderAPI implemented by all Order objects for customer orders
	 *
	 * @author dpeters
	 */
	private interface OrderAPI {
		int getId();
		double getPrice();
		String getName();
		String getDescription();
	}
	
	
	/**
	 * Student ToDO: 
	 * Adapter Design Pattern:
	 * 
	 * 4. Develop inner class OrderAdapter using Adapter design pattern, 
	 * to adapt Order to use an ItemAPI object
	 */

	public static class OrderAdapter implements OrderAPI{

		ItemAPI itemAPI;

		@Override
		public int getId() {
			return 0;
		}

		@Override
		public double getPrice() {
			return 0;
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public String getDescription() {
			return null;
		}

		public OrderAdapter(){
			itemAPI = ItemFactory.getObject();
		}

		public ItemAPI getItem(){
			return this.itemAPI;
		}

	}

	private static class ItemBuilder {

		public ItemAPI getItem(){
			ItemAPI itemFactory = new ItemFactory().getObject();

			return itemFactory;

		}
	}


	/**
	 * Student ToDO: 
	 * Builder Design Pattern:
	 * 
	 * Using Builder design pattern, develop inner class ItemBuilder 
	 * to custom configure an Item object
	 */
	public static class Item implements ItemAPI{


		private double price;
		private String name;

		public void setPrice(double price) {
			this.price = price;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Item(){
		}

		public Item(double price, String name){
			this.price = price;
			this.name = name;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String toString() {
			return "\nItem [Name= "+ getName() + ", Price=" + getPrice() +  "]\n";
		}

		public double getItemPrice() {
			return this.price;
		}

		public String getItemName() {
			return this.name;
		}

		public class ItemBuilder {
		}
	}
	
	
	/**
	 * Student ToDO: 
	 * Composite Design Pattern:
	 * 
	 * Using Composite and Builder design pattern, 
	 * develop inner classes:
	 * 
	 *  Order, IndividualOrder, IndividualOrderBuilder, 
	 * ComboOrder and ComboOrderBuilder
	 * 
	 */

	public static class Order implements OrderAPI{

		@Override
		public int getId() {
			return 0;
		}

		@Override
		public double getPrice() {
			return 0;
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public String getDescription() {
			return null;
		}
	}

	public class IndividualOrder extends Order{

	}

	public class IndividualOrderBuilder{



	}

	public class ComboOrder extends Order{

	}

	public class ComboOrderBuilder{

	}


	
	/**
	 * Student ToDO: 
	 * Decorator Design Pattern:
	 * 
	 * Using Decorator design pattern, 
	 * develop inner classes:
	 * 
	 *  ItemDecoratorAPI, and others as needed for all ItemAPI options
	 * 
	 */
	
	public interface ItemDecoratorAPI{
		public Item ItemDiscount();
	}


	/**
	 * Student ToDO: 
	 * Factory Design Pattern:
	 * 
	 * Using Factory design pattern and supplied ItemFactoryAPI, 
	 * develop inner classes:
	 *  
		 * ItemFactory, ItemFactoryEnumSingleton,
	 * ItemFactoryEagerSingleton and ItemFactoryLazySingleton
	 * 
	 * Using Factory design pattern and supplied OrderComponentFactoryAPI, 
	 * develop inner classes:
	 *  
	 * IndividualOrderComponentFactory, IndividualOrderComponentFactoryEnumSingleton, 
	 * IndividualOrderComponentFactoryEagerSingleton and IndividualOrderComponentFactoryLazySingleton
	 * 
	 * ComboOrderComponentFactory, ComboOrderComponentFactoryEnumSingleton, 
	 * ComboOrderComponentFactoryEagerSingleton and ComboOrderComponentFactoryLazySingleton
	 * 
	 * Using Factory design pattern and supplied OrderAdapterFactoryAPI, 
	 * develop inner classes:
	 * 
	 * OrderAdapterFactory, OrderAdapterFactoryEnumSingleton, 
	 * OrderAdapterFactoryEagerSingleton and OrderAdapterFactoryLazySingleton
	 * 
	 */
	

	/**
	 * ItemFactoryAPI for Factory method design pattern
	 * @author dpeters
	 *
	 */
	private interface ItemFactoryAPI {
		ItemAPI getObject();
		ItemAPI getObject(ItemBuilder b);
	}

	public static class ItemFactory implements ItemFactoryAPI{

		@Override
		public ItemAPI getObject() {
			return new Item();
		}

		@Override
		public ItemAPI getObject(ItemBuilder b) {
			return null;
		}


	}

	public class ItemFactoryEnumSingleton extends ItemFactory{

		private ItemFactoryEnumSingleton instance;


		private ItemFactoryEnumSingleton() {
			instance = null;

		}
		public synchronized ItemFactoryEnumSingleton getInstance() {
			if (instance == null) {
				instance = new ItemFactoryEnumSingleton();
			}
			return instance;
		}


	}

	public static class ItemFactoryEagerSingleton extends ItemFactory{

		private ItemFactoryEagerSingleton instance;

		public  ItemFactoryEagerSingleton getInstance() {

			return instance;
		}

	}

	public class ItemFactoryLazySingleton extends ItemFactory{

		public ItemFactoryLazySingleton() {
			instance = null;
		}
		private ItemFactoryLazySingleton instance;

		public synchronized ItemFactoryLazySingleton getInstance() {
			if (instance == null) {
				instance = new ItemFactoryLazySingleton();
			}
			return instance;
		}


	}

	
	/**
	 * OrderComponentFactoryAPI for Factory method design pattern
	 * @author dpeters
	 *
	 */
	public class OrderComponentAPI implements OrderAPI{

		@Override
		public int getId() {
			return 0;
		}

		@Override
		public double getPrice() {
			return 0;
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public String getDescription() {
			return null;
		}
	}

	private interface OrderComponentFactoryAPI {
		OrderComponentAPI getObject();
		OrderComponentAPI getObject(OrderBuilderAPI b);


	}

	class OrderBuilderAPI {
	}
	
	
	
	
	/**
	 * Student ToDO: 
	 * Strategy Design Pattern:
	 * 
	 * Using Strategy design pattern to change retail prices: 
	 * NormalDiscount (0% decrease), MemberDiscount (10% decrease), 
	 * SpecialDiscount (20% discount), SuperBowlDiscount (20% increase)
	 */

	public interface DiscountStrategy{
		public String discount(Item item);
	}

	public static class NormalDiscount implements DiscountStrategy{

		@Override
		public String discount(Item item) {
			// TODO Auto-generated method stub
			double discountedPrice= item.getItemPrice() - item.getItemPrice()* 0 ;
			return "Received Normal Discount of 0% on "+ item.getItemName()+". Final price = "+ Math.round(discountedPrice*100.0)/100.0;
		}
	}

	public static class MemberDiscount implements DiscountStrategy{

		@Override
		public String discount(Item item) {
			// TODO Auto-generated method stub
			double discountedPrice= item.getItemPrice() - item.getItemPrice()* 0.10 ;
			return "Received Member Discount of 10% on "+ item.getItemName()+". Final price = "+ Math.round(discountedPrice*100.0)/100.0;
		}
	}

	public static class SpecialDiscount implements DiscountStrategy{

		@Override
		public String discount(Item item) {
			// TODO Auto-generated method stub
			double discountedPrice= item.getItemPrice() - item.getItemPrice()* 0.20 ;
			return "Received Special Discount of 20% on "+ item.getItemName()+". Final price = "+ Math.round(discountedPrice*100.0)/100.0;
		}
	}

	public static class SuperBowlDiscount implements DiscountStrategy{

		@Override
		public String discount(Item item) {
			// TODO Auto-generated method stub
			double discountedPrice= item.getItemPrice() + item.getItemPrice()* 0.20 ;
			return "Received SuperBowl Discount of 20% on "+ item.getItemName()+". Final price = "+ Math.round(discountedPrice*100.0)/100.0;
		}
	}


	/**
	 * Student ToDO: 
	 * Bridge Design Pattern:
	 * 
	 * Develop TWO Point of Sale APIs for Order purchases with DISCOUNTS (to change prices):
	 * Using Bridge design pattern to in TWO design phases 
	 * developing inner interfaces PosAPI1, PosAPI2, CalculatorAPI1, CalculatorAPI2 and 
	 * developing inner classes Pos1, Pos2, Calculator1 and Calculator2
	 * 
	 */

	private static class Pos1 {
		public Pos1(Calculator1 calculator1) {
			
		}

		public void setStrategy(DiscountStrategy strategy) {

		}


		public void sumTotal(List<Double> asList) {
		}
	}

	private static class Pos2 {
		public Pos2(Calculator2 calculator2) {

		}

		public void setStrategy(DiscountStrategy strategy) {

		}

		public void sumTotal(List<Double> asList) {
		}

		public void getChange(double v) {
		}
	}

	private static class Calculator1 {
		public void add(double a, double b) {
			
		}
	}
	private static class Calculator2 {
		public void add(double a, double b) {
			
		}

		public void sub(double a, double b) {
		}

		public void mult(double a, double b) {
		}

		public void div(double a, double b) {
		}
	}



	/**
	 * Testing Code for DoorDash class
	 */	
	
	
	/**
	 * test Point of Sale (POS) Bridge Abstraction Phase I Pos1 (Calculator1) and Phase II Pos2 (Calculator2)
	 */
	public static void demoPos(Double... a ) {
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoPos()...");
		{
			System.out.println("TESTING Pos1 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");
			
			Pos1 obj = new Pos1(new Calculator1());
			
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);
			
			System.out.println("applying 0% Normal Discount");
			obj.setStrategy(new NormalDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);
			
			System.out.println("applying 10% Member Discount");
			obj.setStrategy(new MemberDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);
			
			System.out.println("applying 20% Special Discount");
			obj.setStrategy(new SpecialDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);
			
			System.out.println("applying 20% SuperBowl MarkUp");
			obj.setStrategy(new SuperBowlDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);
		}
		{
			System.out.println("TESTING Pos2 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");
			
			Pos2 obj = new Pos2(new Calculator2());
			
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);
			
			System.out.println("applying 10% Normal Discount");
			obj.setStrategy(new NormalDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);
			
			System.out.println("applying 10% Member Discount");
			obj.setStrategy(new MemberDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);
			
			System.out.println("applying 20% Special Discount");
			obj.setStrategy(new SpecialDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);
			
			System.out.println("applying 20% SuperBowl MarkUp");
			obj.setStrategy(new SuperBowlDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);
		}
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoPos()... done!");
	}
	
	/**
	 * test the Point of Sale (POS) Bridge Abstraction
	 */
	public static void testPos() {
		System.out.println("\n\t" + DoorDash.class.getName() + ".testPos()...");
		
		/*
		 * Using:	1.1,2.2,3.1
		 * Test Pos1: sumTotal
		 * Test Pos2: getChange
		 */
		Double array[] = { 1.1, 2.2, 3.3 };
		
		DoorDash.demoPos(array);

		System.out.println("\n\t" + DoorDash.class.getName() + ".testPos()... done!");
	}
	
	/**
	 * test Point of Sale (POS) Bridge Implementor
	 */
	public static void testCalculator() {
		System.out.println("\n\t" + DoorDash.class.getName() + ".testCalculator()...");
		
		/*
		 * Using:	a = 4.2, b = 2.1
		 * Test Calculator1: add
		 * Test Calculator2: sub, mult, div
		 */
		double a = 4.2;
		double b = 2.1;
		DoorDash.demoCalculator(a, b);
		
		System.out.println("\n\t" + DoorDash.class.getName() + ".testCalculator()... done!");
	}

	/**
	 * test Point of Sale Bridge (POS) Implementor Phase I Calculator1 and Phase II Calculator2 
	 */
	public static void demoCalculator(double a, double b) {
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculator()...");
		{
			System.out.println("TESTING Calculator1 (add " + a + "," + b + "):...");
			Calculator1 obj = new Calculator1();
			obj.add(a, b);
			System.out.println(obj);
		}
		{
			System.out.println("TESTING Calculator2 (add,sub,mult,div " + a + "," + b + "):...");
			Calculator2 obj = new Calculator2();
			obj.add(a, b);
			System.out.println(obj);
			obj.sub(a, b);
			System.out.println(obj);
			obj.mult(a, b);
			System.out.println(obj);
			obj.div(a, b);
			System.out.println(obj);
		}
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculator()... done!");
	}
	
	/**
	 * demonstrate the use of class DoorDash
	 */
	public static void demo() {
		System.out.println("\n\t" + DoorDash.class.getName() + "demo()...");
		System.out.println(DevelopmentLogEnum.LOG.getDevelopmentLog()); // REMOVE MY SOLUTION
		
		/**
		 * test Calculator
		 */
		DoorDash.testCalculator();
		
		/**
		 * test Point of Sale (PoS)
		 */
		DoorDash.testPos();
		
		/**
		 * Student ToDO: 
		 * use Point of Sale (PoS) to total all orders with all discounts
		 */
		
		System.out.println("\n\t" + DoorDash.class.getName() + "demo()... done!");
	}


}


//DevelopmentLog
//Added the OrderAdapter class using Adapter Design pattern
//Developed ItemBuilder using Builder design pattern
//Developed Order, IndividualOrder, IndividualOrderBuilder,ComboOrder and ComboOrderBuilder using Composite and builder Design Pattern
//Developed ItemDecoratorAPI using decorator design pattern
//Developed inner classes using Factory Design Pattern
//Developed inner classes using Strategy Design Pattern
//