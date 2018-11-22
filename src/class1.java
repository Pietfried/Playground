import javax.lang.model.type.UnionType;

import org.hyperic.sigar.ptql.ProcessFinder;

import com.jezhumble.javasysmon.JavaSysMon;
import com.jezhumble.javasysmon.Monitor;
import com.jezhumble.javasysmon.ProcessInfo;

public class class1 {

	public static void main(String[] args) {

		JavaSysMon sysmon = new JavaSysMon();

		ProcessInfo[] infos = sysmon.processTable();
		ProcessInfo info = null;
		
		
		for (ProcessInfo processinfo : infos) {
			if (processinfo.getPid() == sysmon.currentPid()) {
				info = processinfo;
			}
		}

		System.out.println(info.getPid());
		
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(info.getResidentBytes());
		}
	}
}
