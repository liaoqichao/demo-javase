package demo.uuid;

import java.util.UUID;

import demo.DemoInterface;

public class UUIDDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
//		UUID：Universally Unique Identifier通用唯一识别码。 SessionID就是一种UUID
		demo1();
	}
	public void demo1(){
		UUID uuid = UUID.randomUUID();
		String str_uuid = uuid.toString();
		System.out.println(str_uuid);//0dd49165-4b1f-4e72-887c-20540c4e5df0
//		去掉减号,变成大写
		str_uuid = str_uuid.replace("-", "");
		System.out.println(str_uuid.toUpperCase());
	}

}
