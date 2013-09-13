/**
 * jh , 2013.08.09
 * Object as superclass
 */
package com.jh.ex;

/**
 * @author Administrator
 *
 */



public class ChildOfObject implements Cloneable {

	private String name ;
	
	private ToBeRefer toBe = null; 
	
	static public class  ToBeRefer{
		private String info ;
		public ToBeRefer(String info){
			this.info = info;			
		}
		
		public String getInfo(){
			return info;
		}
	}
	
	public ChildOfObject() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ChildOfObject(String name, String toBeInfo){
		super();
		this.name = name;
		this.toBe = new ToBeRefer(toBeInfo);
	}
	
	public String getName(){
		return name;
	}
	
	public String getToBe(){
		return toBe.getInfo();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setToBeInfo(String info){
		this.toBe.info = info;
	}
	/*  
	public Object clone()  throws CloneNotSupportedException{
		ChildOfObject newObj = (ChildOfObject)super.clone();
		newObj.name = this.getName();
		return newObj;
	} 
	*/

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ChildOfObject newObj = new ChildOfObject("jianghang", "Run");
		System.out.println(newObj.getName());
		System.out.println(newObj.getToBe());
		
		ChildOfObject copyObj = new ChildOfObject();
		copyObj = (ChildOfObject) newObj.clone();// clone 和直接赋值的区别，
		
		System.out.println(copyObj.getName());
		System.out.println(copyObj.getToBe());  // 可以clone 过来显示信息
		
		//测试是否独立？？
		//改变 引用数据类型的值 toBeInfo 的值
		newObj.setName("changed jianghang.");
		newObj.setToBeInfo("changed toBeInfo.");		
		System.out.println("修改原始对象后原始数据的 原始对象里的数据：");
		System.out.println(newObj.getName());
		System.out.println(newObj.getToBe());
		
		System.out.println("修改原始对象后原始数据的 clone对象里的数据：");
		System.out.println(copyObj.getName());
		System.out.println(copyObj.getToBe());  // 可以clone 过来显示信息
		/*
		 * output :
		 * 修改原始对象后原始数据的 原始对象里的数据：
				changed jianghang.
				changed toBeInfo.
				修改原始对象后原始数据的 clone对象里的数据：
				jianghang
				changed toBeInfo.
		*/
		// 说明是不独立的，这时就需要自己 override clone 函数
		
	}

}
