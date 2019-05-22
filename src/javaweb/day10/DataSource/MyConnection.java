package javaweb.day10.DataSource;

import com.sun.jdi.connect.spi.Connection;

import java.io.IOException;
import java.util.LinkedList;

public class MyConnection extends Connection {

    private Connection conn;
    private LinkedList<Connection> pool;

    public MyConnection(Connection conn, LinkedList<Connection> pool) {
        this.conn = conn;
        this.pool = pool;
    }

    @Override
    public void close() throws IOException {
        pool.add(this.conn);

    }


    /*--------------------------------------------------未实现部分-----------------------------------------------------*/

    @Override
    public byte[] readPacket() throws IOException {
        return new byte[0];
    }

    @Override
    public void writePacket(byte[] pkt) throws IOException {

    }

    @Override
    public boolean isOpen() {
        return false;
    }
}
