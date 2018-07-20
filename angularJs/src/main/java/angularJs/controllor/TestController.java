package angularJs.controllor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: TestController Function: TODO ADD FUNCTION. date: 2017年12月14日
 * 上午11:11:23
 * 
 * @author zhaoshouyun
 * @version
 * @since JDK 1.7
 */
@Controller
public class TestController {

	@Autowired
	MyMessageHandler handler;

	@RequestMapping("/get")
	public String get() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/get1")
	public String send(String name) {
		handler.sendMessageToUser("zhaoshouyun", "服务端发送的内容:" + name);
		return "success";
	}

}
