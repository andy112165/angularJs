/**
* Project Name:springRabbitMQ
* File Name:WebSocketConfig.java
* Package Name:com.zsy.websocket
* Date:2018年1月31日下午1:10:33
* Copyright (c) 2018, zhaoshouyun All Rights Reserved.
*
*/
/**
 * Project Name:springRabbitMQ
 * File Name:WebSocketConfig.java
 * Package Name:com.zsy.websocket
 * Date:2018年1月31日下午1:10:33
 * Copyright (c) 2018, zhaoshouyun All Rights Reserved.
 *
 */

package angularJs.controllor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * ClassName: WebSocketConfig Function: TODO ADD FUNCTION. date: 2018年1月31日
 * 下午1:10:33
 * 
 * @author zhaoshouyun
 * @version
 * @since JDK 1.7
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	/**
	 * 注册handle
	 * 
	 * @see org.springframework.web.socket.config.annotation.WebSocketConfigurer#registerWebSocketHandlers(org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry)
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myHandler(), "/testHandler").addInterceptors(new WebSocketInterceptor());
		registry.addHandler(myHandler(), "/socketJs/testHandler").addInterceptors(new WebSocketInterceptor())
				.withSockJS();

	}

	@Bean
	public WebSocketHandler myHandler() {
		return new MyMessageHandler();
	}

}
