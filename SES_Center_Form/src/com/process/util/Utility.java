package com.process.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

public final class Utility {

	/**
	 * Don't let anyone instantiate this class
	 */
	private Utility() {}

	/**
	 * Object[] 의 복제. Object의 Array 를 복제(clone)하여
	 * 새로운 Instance를 만들어 줍니다.
	 *
	 * @param objects java.lang.Object[]
	 * @return java.lang.Object[]
	 *
	 * @see clone(java.lang.Object)
	 * @see clone(java.lang.Vector)
	 */
	public static Object[] clone(Object[] objects)
	{
		int length = objects.length;
		Class c = objects.getClass().getComponentType();
		Object array = Array.newInstance(c, length);

		for(int i=0;i<length;i++){
			Array.set(array, i, Utility.clone(objects[i]));
		}
		return (Object[])array;
	}

	/**
	 * Object 의 복제. 일반적으로 <code>java.lang.Object.clone()</code> 함수를
	 * 를 사용하여 Object를 복제하면 Object내에 있는 Primitive type을 제외한 Object
	 * field들은 복제가 되는 것이 아니라 같은 Object의 reference를
	 * 갖게 된다.<br>
	 * 그러나 이 Method를 사용하면 각 field의 동일한 Object를 새로 복제(clone)하여
	 * 준다.
	 *
	 * @param object java.lang.Object
	 * @return java.lang.Object
	 *
	 * @see clone(java.lang.Object[])
	 * @see clone(java.lang.Vector)
	 */
	public static Object clone(Object object)
	{
		Class c = object.getClass();
		Object newObject = null;
		try {
			newObject = c.newInstance();
		}
		catch(Exception e ){
			return null;
		}

		Field[] field = c.getFields();
		for (int i=0 ; i<field.length; i++) {
			try {
				Object f = field[i].get(object);
				field[i].set(newObject, f);
			}
			catch(Exception e){
			}
		}
		return newObject;
	}

	/**
	 * Vector 의 복제. 일반적으로 Vector Object를 clone()을 하면
	 * Vector내의 Element Object는 새로 생성되는 것이 아니라
	 * 동일한 Object에 대한 reference만 새로 생성되기 때문에 같은 Element Object를
	 * reference하는 Vector를 생성하게 된다. 그러나 이 method를 사용하면
	 * Vector내의 모든 Element Object도 새로 복제하여 준다.
	 *
	 * @param objects java.util.Vector
	 * @return java.util.Vector
	 *
	 * @see clone(java.lang.Object)
	 * @see clone(java.lang.Object[])
	 */
	public static Vector clone(Vector objects)
	{
		Vector newObjects = new Vector();
		Enumeration e = objects.elements();
		while(e.hasMoreElements()){
			Object o = e.nextElement();
			newObjects.addElement(Utility.clone(o));
		}
		return newObjects;
	}

	/**
	 * Entity Class의 null string field 초기화.
	 * <p>
	 * Entity class 내에 있는 java.lang.String형의 field는 DB의 Column과
	 * 밀접한 연관이 있는 경우가 많다. 이러한 Entity Field가 특히 GUI의 특정
	 * TextFiled에 표현되어야 하는 경우도 많다. 만약 그 String Filed가 null일
	 * 경우 일일이 검사를 한다는 것은 참으로 답답한 일이 아닐 수 없다.
	 * <p>
	 * 이 method는 여하한의 Object 내에 있는 모든 java.lang.String형의 field 변수 중
	 * null 값으로 된 field를 길이가 0 인 blank string("")으로 초기화 시켜준다.
	 * <p>
	 *
	 * <xmp>
	 * Sample Code:
	 * public java.util.Vector selectAll() throws Exception
	 * {
	 *  java.util.Vector list = new Vector();
	 * 	Statement stmt = null;
	 * 	ResultSet rs =null;
	 * 	try{
	 * 		stmt = conn.createStatement();
	 * 		String query = "select " +
	 * 			"id, " +
	 * 			"name, " +
	 * 			"desc " +
	 * 			"from THE10 " +
	 * 			"order by id ";
	 *
	 * 		rs = stmt.executeQuery(query);
	 *
	 * 		while ( rs.next() ) {
	 * 			AdminAuth entity = new AdminAuth();
	 * 			entity.id = rs.getString("id");
	 * 			entity.name = rs.getString("name");
	 * 			entity.desc = rs.getString("desc");
	 * 			Utility.fixNull(entity);
	 * 			list.addElement(entity);
	 * 		}
	 * 	}
	 * 	finally {
	 * 		try{rs.close();}catch(Exception e){}
	 * 		try{stmt.close();}catch(Exception e){}
	 * 	}
	 * 	return list;
	 * }
	 *</xmp
	 *
	 * @param java.lang.Object Object내의 public java.lang.String 형의
	 *        member variable에만 영향을 준다.
	 *
	 * @see fixNullAll(java.lang.Object)
	 * @see fixNullAndTrim(java.lang.Object)
	 * @see fixNullAndTrimAll(java.lang.Object)
	 */
	public static void fixNull(Object o)
	{
		if ( o == null ) return;

		Class c = o.getClass();
		if ( c.isPrimitive() ) return;

		Field[] fields = c.getFields();
		for (int i=0 ; i<fields.length; i++) {
			try {
				Object f = fields[i].get(o);
				Class fc = fields[i].getType();

				if ( fc.getName().equals("java.lang.String") ) {
					if ( f == null ) fields[i].set(o, "");
					else	fields[i].set(o, f);
				}
			}
			catch(Exception e){
			}
		}
	}

	/**
	 * Entity Class의 재귀적인 null string field 초기화.
	 * <p>
	 * fixNull() 과 유사한 기능을 하는데, java.lang.String field 뿐만 아니라
	 * Member 변수 중 Array, Object 가 있으면 재귀적으로 찾아 가서 String형을
	 * blank string("")으로 만들어 준다.<br>
	 * 정상적인 String인 경우 trim()을 시켜준다.<br>
	 * 만약 Array나, Vector가 null일 경우 Instance화는 하지 않는다.
	 *
	 * <p>
	 * 재귀적으로 추적되는 만큼, 부모와 자식간에 서로 양방향 reference를 갖고 있으면
	 * 절대 안된다. Stack Overflow를 내며 JVM을 내릴 것이다.
	 *
	 *
	 * @param java.lang.Object Object내의 public String 형뿐만 아니라, Object[], Vector 등과
	 *        같은 public Object형 Member Variable에 영향을 준다.
	 *
	 * @see fixNull(java.lang.Object)
	 * @see fixNullAndTrim(java.lang.Object)
	 * @see fixNullAndTrimAll(java.lang.Object)
	 */
	public static void fixNullAll(Object o)
	{
		if ( o == null ) return;

		Class c = o.getClass();
		if ( c.isPrimitive() ) return;

		if( c.isArray() ) {
			int length = Array.getLength(o);
			for(int i=0; i<length ;i++){
				Object element = Array.get(o, i);
				Utility.fixNullAll(element);
			}
		}
		else {
			Field[] fields = c.getFields();
			for (int i=0 ; i<fields.length; i++) {
				try {
					Object f = fields[i].get(o);
					Class fc = fields[i].getType();
					if ( fc.isPrimitive() ) continue;
					if ( fc.getName().equals("java.lang.String") ) {
						if ( f == null ) fields[i].set(o, "");
						else	fields[i].set(o, f);
					}
					else if ( f != null ) {
						Utility.fixNullAll(f);
					}
					else {} // Some Object, but it's null.
				}
				catch(Exception e) {
				}
			}
		}
	}

	/**
	 * Entity Class의 null string field 초기화 &amp; trim().
	 * <p>
	 * Entity class 내에 있는 java.lang.String형의 field는 DB의 Column과
	 * 밀접한 연관이 있는 경우가 많다. 이러한 Entity Field가 특히 GUI의 특정
	 * TextFiled에 표현되어야 하는 경우도 많다. 만약 그 String Filed가 null일
	 * 경우 일일이 검사를 한다는 것은 참으로 답답한 일이 아닐 수 없다.
	 * <p>
	 * 이 method는 여하한의 Object 내에 있는 모든 java.lang.String형의 field 변수 중
	 * null 값으로 된 field를 길이가 0 인 blank string("")으로 초기화 시켜준다.
	 * 만약 null이 아닌 정상적인 String이 대입되어 있으면 강제적으로 trim()를
	 * 시켜준다.
	 * <p>
	 * 이 때 trim() 함수는 java.lang.String 의 trim()을 사용하지 않았다.
	 *
	 * <xmp>
	 * Sample Code:
	 * public java.util.Vector selectAll() throws Exception
	 * {
	 *  java.util.Vector list = new Vector();
	 * 	Statement stmt = null;
	 * 	ResultSet rs =null;
	 * 	try{
	 * 		stmt = conn.createStatement();
	 * 		String query = "select " +
	 * 			"id, " +
	 * 			"name, " +
	 * 			"desc " +
	 * 			"from THE10 " +
	 * 			"order by id ";
	 *
	 * 		rs = stmt.executeQuery(query);
	 *
	 * 		while ( rs.next() ) {
	 * 			AdminAuth entity = new AdminAuth();
	 * 			entity.id = rs.getString("id");
	 * 			entity.name = rs.getString("name");
	 * 			entity.desc = rs.getString("desc");
	 * 			Utility.fixNull(entity);
	 * 			list.addElement(entity);
	 * 		}
	 * 	}
	 * 	finally {
	 * 		try{rs.close();}catch(Exception e){}
	 * 		try{stmt.close();}catch(Exception e){}
	 * 	}
	 * 	return list;
	 * }
	 *</xmp
	 *
	 * @param java.lang.Object Object내의 public java.lang.String 형의
	 *        member variable에만 영향을 준다.
	 *
	 * @see fixNull(java.lang.Object)
	 * @see fixNullAll(java.lang.Object)
	 * @see fixNullAndTrimAll(java.lang.Object)
	 * @see trim(String)
	 */
	public static void fixNullAndTrim(Object o)
	{
		if ( o == null ) return;

		Class c = o.getClass();
		if ( c.isPrimitive() ) return;

		Field[] fields = c.getFields();
		for (int i=0 ; i<fields.length; i++) {
			try {
				Object f = fields[i].get(o);
				Class fc = fields[i].getType();
				if ( fc.getName().equals("java.lang.String") ) {
					if ( f == null ) fields[i].set(o, "");
					else {
						String item = Utility.trim( (String)f );
						fields[i].set(o, item);
					}
				}
			}
			catch(Exception e){
			}
		}
	}

	/**
	 * Entity Class의 재귀적인 null string field 초기화  &amp; trim().
	 * <p>
	 * fixNull() 과 유사한 기능을 하는데, java.lang.String field 뿐만 아니라
	 * Member 변수 중 Array, Object 가 있으면 재귀적으로 찾아 가서 String형을
	 * blank string("")으로 만들어 준다.<br>
	 * 정상적인 String인 경우 trim()을 시켜준다.<br>
	 * 만약 Array나, Vector가 null일 경우 Instance화는 하지 않는다.
	 *
	 * <p>
	 * 재귀적으로 추적되는 만큼, 부모와 자식간에 서로 양방향 reference를 갖고 있으면
	 * 절대 안된다. Stack Overflow를 내며 JVM을 내릴 것이다.
	 *
	 *
	 * @param java.lang.Object Object내의 public String 형뿐만 아니라, Object[], Vector 등과
	 *        같은 public Object형 Member Variable에 영향을 준다.
	 *
	 * @see fixNull(java.lang.Object)
	 * @see fixNullAll(java.lang.Object)
	 * @see fixNullAndTrim(java.lang.Object)
	 * @see trim(String)
	 */
	public static void fixNullAndTrimAll(Object o)
	{
		if ( o == null ) return;

		Class c = o.getClass();
		if ( c.isPrimitive() ) return;

		if( c.isArray() ) {
			int length = Array.getLength(o);
			for(int i=0; i<length ;i++){
				Object element = Array.get(o, i);
				Utility.fixNullAndTrimAll(element);
			}
		}
		else {
			Field[] fields = c.getFields();
			for (int i=0 ; i<fields.length; i++) {
				try {
					Object f = fields[i].get(o);
					Class fc = fields[i].getType();
					if ( fc.isPrimitive() ) continue;
					if ( fc.getName().equals("java.lang.String") ) {
						if ( f == null ) fields[i].set(o, "");
						else {
							String item = Utility.trim( (String)f );
							fields[i].set(o, item);
						}
					}
					else if ( f != null ) {
						Utility.fixNullAndTrimAll(f);
					}
					else {} // Some Object, but it's null.
				}
				catch(Exception e) {
				}
			}
		}
	}

	/**
	 *
	 * @param e java.lang.Throwable
	 */
	public static String getStackTrace(Throwable e) {
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		java.io.PrintWriter writer = new java.io.PrintWriter(bos);
		e.printStackTrace(writer);
		writer.flush();
		return bos.toString();
	}

	/**
	 * Remove special white space from both ends of this string.
	 * <p>
	 * All characters that have codes less than or equal to
	 * <code>'&#92;u0020'</code> (the space character) are considered to be
	 * white space.
	 * <p>
	 * java.lang.String의 trim()과 차이점은 일반적인 white space만 짜르는 것이
	 * 아니라 위에서와 같은 특수한 blank도 짤라 준다.<br>
	 * 이 소스는 IBM HOST와 데이타를 주고 받을 때 유용하게 사용했었다.
	 * 일반적으로 많이 쓰이지는 않을 것이다.
	 *
	 * @param  java.lang.String
	 * @return trimed string with white space removed
	 *         from the front and end.
	 */
	public static String trim(String s) {
		int st = 0;
		char[] val = s.toCharArray();
		int count = val.length;
		int len = count;

		while ((st < len) && ((val[st] <= ' ') || (val[st] == ' ') ) )   st++;
		while ((st < len) && ((val[len - 1] <= ' ') || (val[len-1] == ' ')))  len--;

		return ((st > 0) || (len < count)) ? s.substring(st, len) : s;
	}

    /**
     * @ nLen의 자리수 대로의 랜덤한 숫자를 얻을수 있다.
     *
     *
     *
     * @param  int            랜덤한 수의 길이.
     * @return random String     
     */
    public static String getRandom( int nLen ) throws Exception {

            double dVar = 0;
            int    nVar = 1;
            StringBuffer sbBuf = new StringBuffer();

            for( int i=0; i< nLen; i++ ) {
                 nVar *= 10;
                 sbBuf.append("0");
            }

            java.text.DecimalFormat df = new java.text.DecimalFormat( sbBuf.toString() );
            dVar = Math.random()*nVar;

            return df.format( (int)dVar ); 
    }
    
    
    /**
     * @ 주민번호를 이용하여 나이를 구한다
     *
     *
     *
     * @param  idNum           주민번호(연속13자리 "-" 없음)
     * @return 만 나이
     */
	public static int getAge(String idNum){
	
		String today = ""; //시스템 날짜
		String birthday = ""; //생일
		int myAge = 0; //만 나이
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy", Locale.KOREA);
	
		today = formatter.format(new Date()); //시스템 날짜를 가져와서 yyyy 형태로 변환
	
		if(idNum.charAt(6) == '1' || idNum.charAt(6) == '2' || idNum.charAt(6) == '5' || idNum.charAt(6) == '6'){
			birthday = "19" + idNum.substring(0, 2); //주민번호 7번째 자리수가 1 또는 2이면 1900년대 출생
		}else{ 
			birthday = "20" + idNum.substring(0, 2); //주민번호 7번째 자리수가 1 또는 2가 아니면 2000년대 출생
		} 
	
		myAge = Integer.parseInt(today) - Integer.parseInt(birthday); //현재년도 - 생년 + 1
	
		formatter = new SimpleDateFormat("mmdd", Locale.KOREA);
		birthday =  idNum.substring(2, 6);
		if (Integer.parseInt(birthday) >  Integer.parseInt(formatter.format(new Date()))) myAge = myAge - 1;
	
		return myAge;
	}

}
