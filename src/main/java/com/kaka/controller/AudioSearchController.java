package com.kaka.controller;

import com.baidu.mobileopen.library.json.GsonUtils;
import com.baidu.mobileopen.library.log.Logger;
import com.baidu.mobileopen.library.log.LoggerFactory;
import com.kaka.dao.UserMapper;
import com.kaka.model.User;
import com.kaka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sundaoping on 2018/1/30.
 */

@WebServlet("/audio/search")
public class AudioSearchController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Resource(name = "userService")
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(AudioSearchController.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AudioSearchController() {
        super();
    }

    /**
     *
     * 重写doPost方法，处理POST请求
     *
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("/audio/search doPost start").add("request", GsonUtils.toJson(request.getParameterMap())).end();

        //System.out.println("tpId:" + request.getParameter("tpId"));
        // 根据request创建Bot
       /* TaxBot bot = new TaxBot(request);

        // 打开签名验证
        // bot.enableVerify();

        // 线下调试时，可以关闭签名验证
        bot.disableVerify();

        try {
            // 调用bot的run方法
            String responseJson = bot.run();
            // 设置response的编码UTF-8
            response.setCharacterEncoding("UTF-8");
            // 返回response
            response.getWriter().append(responseJson);
        } catch (Exception e) {
            response.getWriter().append("{\"status\":1,\"msg\":\"\"}");
        }
*/
        response.getWriter().append("sdfsdfsssss");

        //char[] responseToSend = new char[response.getBufferSize()];
        //response.getWriter().write(responseToSend);

     //   char[] responseToSend = new char[response.getBufferSize()];
       // response.getWriter().write(responseToSend);
       // logger.info("/audio/search end").add("response", new String(responseToSend)).end();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("/audio/search doGet start").add("request", GsonUtils.toJson(request.getParameterMap())).end();

        //System.out.println("tpId:" + request.getParameter("tpId"));
        // 根据request创建Bot
       /* TaxBot bot = new TaxBot(request);

        // 打开签名验证
        // bot.enableVerify();

        // 线下调试时，可以关闭签名验证
        bot.disableVerify();

        try {
            // 调用bot的run方法
            String responseJson = bot.run();
            // 设置response的编码UTF-8
            response.setCharacterEncoding("UTF-8");
            // 返回response
            response.getWriter().append(responseJson);
        } catch (Exception e) {
            response.getWriter().append("{\"status\":1,\"msg\":\"\"}");
        }
*/

        String id = "1";

       // userService = new UserService();
        User user = userService.getUserById(id);


        logger.info("/audio/search doGet username").add("username",user.getName()).end();



        response.getWriter().append("lakjdflaskdfj;alf");

        //char[] responseToSend = new char[response.getBufferSize()];
        //response.getWriter().write(responseToSend);

        //   char[] responseToSend = new char[response.getBufferSize()];
        // response.getWriter().write(responseToSend);
        // logger.info("/audio/search end").add("response", new String(responseToSend)).end();

    }

}
