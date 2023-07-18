package chattingRoom;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class chattingRoomServer {

    public static void main(String[] args) throws IOException {
        // 通过udp协议接收数据
        // 1. 新建提供data socket对象
        // 无参:对象表示随机发送到可用端口
        // 有参:传递port端口号作参数
        DatagramSocket ds = new DatagramSocket(10086);

        while (true) {
        // 2. 新建data packet数据包
        // 与指定的接收端ip地址和端口链接
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 3. 接收并解析数据
        // 注意：解析数据用的是dp对象，因为是
        // 对数据包的解析

            ds.receive(dp);
            byte[] dpData = dp.getData();
            InetAddress address = dp.getAddress();
            int port = dp.getPort();
            int length = dp.getLength();

            // new一个字符串对象传递字节数组可以来解码字节数组成字符串
            System.out.println("ip地址为：" + address + "， 端口号为：" + port + "，发出了数据: " + new String(dpData));
        }

    }


}
