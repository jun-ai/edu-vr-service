package com.zhejianglab.edu.websocket;

import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.base.DataResult;
import com.zhejianglab.edu.model.constants.PlatFormEnum;
import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.starter.auth.user.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/webSocket/{userId}")
@Component
@Slf4j
public class WebSocketServer {

    //静态变量,用来记录当前在线连接数,应该把它设计成线程安全的
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全Set,用来存放每个客户端对应的WebSocketServer对象
    public static ConcurrentHashMap<String, RoomUserDto> sessionPools = new ConcurrentHashMap<>();



    //发送消息
    public void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
                session.getBasicRemote().sendText(message);
            }
        }
    }
//    //给指定用户发送信息
//    public void sendInfo(String userId, String message){
//        Session session = sessionPools.get(userId).getSession();
//        try {
//            sendMessage(session, message);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    //建立连接成功调用
    @OnOpen
    public AjaxResult onOpen(Session session, @PathParam(value = "userId") String userId){
        RoomUserDto roomUserDto=new RoomUserDto();
        userId= SessionUtil.get().getEmpId();
        if (sessionPools.size()>0){
            boolean userDto = sessionPools.containsKey(userId);
            if (userDto){
                return  AjaxResult.error(PlatFormEnum.INSERT_ROOM_FAIL.code,PlatFormEnum.getValue(PlatFormEnum.INSERT_ROOM_FAIL.code), DataResult.success());
            }else {
                //学生加入房间
                roomUserDto.setUserId(userId);
                roomUserDto.setRoleId(String.valueOf(2));
                roomUserDto.setAuthFlag(String.valueOf(1));
                roomUserDto.setName(SessionUtil.get().getEmpName());
                sessionPools.put(userId,roomUserDto);
                addOnlineCount();
                log.info(userId + "学生加入webSocket！当前人数为" + onlineNum+"用户信息为"+roomUserDto);
            }
        }else {
            //教师创建房间
            roomUserDto.setUserId(userId);
            roomUserDto.setRoleId(String.valueOf(1));
            roomUserDto.setAuthFlag(String.valueOf(0));
            roomUserDto.setName(SessionUtil.get().getEmpName());
            //roomUserDto.setSession(session);
            sessionPools.put(userId,roomUserDto);
            addOnlineCount();
            log.info(userId + "教师加入webSocket！当前人数为" + onlineNum+"用户信息为"+roomUserDto);
        }
        try {
            sendMessage(session, "欢迎" + userId + "加入连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AjaxResult.success();
    }

    //关闭连接时调用
    @OnClose
    public void onClose(@PathParam(value = "userId") String userId){
        userId= SessionUtil.get().getEmpId();
        sessionPools.remove(userId);
        subOnlineCount();
        System.out.println(userId + "断开webSocket连接！当前人数为" + onlineNum);
        log.info(userId + "断开webSocket连接！当前人数为" + onlineNum);
    }

//    //收到客户端信息
//    @OnMessage
//    public void onMessage(String message) throws IOException {
//        message = "客户端：" + message + ",已收到";
//        System.out.println(message);
//        for (Session session: sessionPools.values()) {
//            try {
//                sendMessage(session, message);
//            } catch(Exception e){
//                e.printStackTrace();
//                continue;
//            }
//        }
//    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable){
        log.info("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }
}
