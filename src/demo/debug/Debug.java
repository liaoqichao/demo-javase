package demo.debug;

import java.util.Arrays;

import demo.DemoInterface;

public class Debug implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 断点调试模式Run as debug。
		 * debug的用处：	1.	调试程序
		 * 			 	2.	查看程序源代码
		 */
//		demo1();
//		demo2();
	}
	public void demo1(){
		/*
		 * 从1加到100
		 * 
		 * 第一步：设置断点(让程序停止在断点的那一行),双击行号,出现一个蓝点。
		 * 第二步：Run as debug,会弹出一个是否进入调试模式的确认框。选择yes。目前设置断点的那一行变成绿色。程序就停止在那一行(那一行没有执行),
		 * 没有向下运行。
		 * 第三步：双击sum,右键选中watch。右上角出现Expressions中的sum,没有值。
		 * 第四部：按F6(执行下一条语句),sum的值变0,再2次按下一步,执行完sum+=i那一行。值变1
		 * 		Step Into(f5) Step Over(f6) Step Return(f7) 
		 * 		Resume(f8)表示调试结束,直接向下运行到下一个断点,没有断点则直接运行结束。
		 * 第五步：点击右上角的Java,回到Java界面
		 */
		int sum = 0;
		for(int i=1; i<=100; i++){
			sum += i;
		}
		System.out.println(sum);
	}
	public void demo2(){
		/*
		 * 数组排序
		 * 不知道sort的排序方式。在sort设置断点。
		 * Step Into(f5)进入源代码,Step Return(f7)返回
		 */
		int[] a = {2,4,1,5,3};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
