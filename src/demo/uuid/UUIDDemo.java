package demo.uuid;

import java.util.UUID;

import demo.DemoInterface;

public class UUIDDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
//		UUID��Universally Unique Identifierͨ��Ψһʶ���롣 SessionID����һ��UUID
		demo1();
	}
	public void demo1(){
		UUID uuid = UUID.randomUUID();
		String str_uuid = uuid.toString();
		System.out.println(str_uuid);//0dd49165-4b1f-4e72-887c-20540c4e5df0
//		ȥ������,��ɴ�д
		str_uuid = str_uuid.replace("-", "");
		System.out.println(str_uuid.toUpperCase());
	}

}
