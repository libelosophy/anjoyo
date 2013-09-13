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
		copyObj = (ChildOfObject) newObj.clone();// clone ��ֱ�Ӹ�ֵ������
		
		System.out.println(copyObj.getName());
		System.out.println(copyObj.getToBe());  // ����clone ������ʾ��Ϣ
		
		//�����Ƿ��������
		//�ı� �����������͵�ֵ toBeInfo ��ֵ
		newObj.setName("changed jianghang.");
		newObj.setToBeInfo("changed toBeInfo.");		
		System.out.println("�޸�ԭʼ�����ԭʼ���ݵ� ԭʼ����������ݣ�");
		System.out.println(newObj.getName());
		System.out.println(newObj.getToBe());
		
		System.out.println("�޸�ԭʼ�����ԭʼ���ݵ� clone����������ݣ�");
		System.out.println(copyObj.getName());
		System.out.println(copyObj.getToBe());  // ����clone ������ʾ��Ϣ
		/*
		 * output :
		 * �޸�ԭʼ�����ԭʼ���ݵ� ԭʼ����������ݣ�
				changed jianghang.
				changed toBeInfo.
				�޸�ԭʼ�����ԭʼ���ݵ� clone����������ݣ�
				jianghang
				changed toBeInfo.
		*/
		// ˵���ǲ������ģ���ʱ����Ҫ�Լ� override clone ����
		
	}

}
