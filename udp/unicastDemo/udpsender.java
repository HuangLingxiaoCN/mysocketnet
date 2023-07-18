package unicastDemo;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpsender {

    public static void main(String[] args) throws IOException {
        // 通过udp协议发送数据
        // 1. 新建提供data socket对象
        // 无参:对象表示随机发送到可用端口
        // 有参:传递port端口号作参数
        DatagramSocket ds = new DatagramSocket();

        // 2. 新建data packet数据包
        // 并将它与指定的接收端ip地址和端口链接
        String data = "你好呀";
        byte[] bytes = data.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);


        // 3. 发送数据
        ds.send(dp);

        // 4. 释放资源
        ds.close();
    }


}
