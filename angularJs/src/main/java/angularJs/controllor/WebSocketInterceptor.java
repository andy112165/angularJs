package angularJs.controllor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * ClassName: WebSocketInterceptor Function: TODO ADD FUNCTION. date: 2018年1月31日
 * 上午11:42:34
 * 
 * @author zhaoshouyun
 * @version
 * @since JDK 1.7
 */
public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor {
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor#beforeHandshake(org.springframework.http.server.ServerHttpRequest,
	 *      org.springframework.http.server.ServerHttpResponse,
	 *      org.springframework.web.socket.WebSocketHandler, java.util.Map)
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
			// 获取参数
			String userId = serverHttpRequest.getServletRequest().getParameter("userId");
			attributes.put(MyMessageHandler.USER_KEY, userId);
		}

		return true;
	}
}
